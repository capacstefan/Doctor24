package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import database.MySQLConnection;
import obiecte.Diagnostic;
import obiecte.ParteCorp;

/**
 * Clasa repository pentru operatiile efectuate asupra consultarilor in baza de date
 */
public class ParteCorpRepository {

    /**
     * Metoda optinere parte corp impreuna cu diagnosticele aferente
     * @param numeParteCorp
     * @return
     */
    public static ParteCorp getParteCorp(String numeParteCorp) {
        ParteCorp parteCorp = null;
        String sqlParteCorp = "SELECT * FROM parti_corp WHERE nume = ?";
        String sqlDiagnostice = "SELECT * FROM diagnostice WHERE parte_corp_id = ?";
        
        try (Connection conn = MySQLConnection.connect(); PreparedStatement psParteCorp = conn.prepareStatement(sqlParteCorp)) {
            psParteCorp.setString(1, numeParteCorp);
            ResultSet rsParteCorp = psParteCorp.executeQuery();
            
            if (rsParteCorp.next()) {
                int parteCorpId = rsParteCorp.getInt("id");
                parteCorp = new ParteCorp(numeParteCorp, new ArrayList<>());
                
                try (PreparedStatement psDiagnostice = conn.prepareStatement(sqlDiagnostice)) {
                    psDiagnostice.setInt(1, parteCorpId);
                    ResultSet rsDiagnostice = psDiagnostice.executeQuery();
                    
                    while (rsDiagnostice.next()) {
                        String nume = rsDiagnostice.getString("nume");
                        String simptomeString = rsDiagnostice.getString("simptome");
                        String cauze = rsDiagnostice.getString("cauze");
                        String indicatii = rsDiagnostice.getString("indicatii");
                        boolean grav = rsDiagnostice.getInt("grav") == 1;
                        
                        ArrayList<String> simptome = Arrays.stream(simptomeString.split(","))
                                .map(String::trim).collect(Collectors.toCollection(ArrayList::new));
                        
                        parteCorp.getDiagnostice().add(new Diagnostic(nume, simptome, cauze, indicatii, grav));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Eroare la obtinere parte corp: " + e.getMessage());
        }
        return parteCorp;
    }

    /**
     * Metoda adaugare/update parte corp impreuna cu diagnosticele aferente
     * @param parteCorp
     * @return
     */
    public static boolean addOrUpdateParteCorp(ParteCorp parteCorp) {
        String checkParteCorpSql = "SELECT id FROM parti_corp WHERE nume = ?";
        String insertParteCorpSql = "INSERT INTO parti_corp (nume) VALUES (?)";
        String updateParteCorpSql = "UPDATE parti_corp SET nume = ? WHERE id = ?";
        String deleteDiagnosticeSql = "DELETE FROM diagnostice WHERE parte_corp_id = ?";
        String insertDiagnosticSql = "INSERT INTO diagnostice (nume, simptome, cauze, indicatii, grav, parte_corp_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.connect()) {
            conn.setAutoCommit(false);
            int parteCorpId;
            try (PreparedStatement psCheck = conn.prepareStatement(checkParteCorpSql)) {
                psCheck.setString(1, parteCorp.getNume());
                ResultSet rs = psCheck.executeQuery();
                
                if (rs.next()) {
                    parteCorpId = rs.getInt("id");
                    
                    try (PreparedStatement psUpdate = conn.prepareStatement(updateParteCorpSql)) {
                        psUpdate.setString(1, parteCorp.getNume());
                        psUpdate.setInt(2, parteCorpId);
                        psUpdate.executeUpdate();
                    }
                    
                    try (PreparedStatement psDelete = conn.prepareStatement(deleteDiagnosticeSql)) {
                        psDelete.setInt(1, parteCorpId);
                        psDelete.executeUpdate();
                    }
                } else {
                    try (PreparedStatement psInsert = conn.prepareStatement(insertParteCorpSql, Statement.RETURN_GENERATED_KEYS)) {
                        psInsert.setString(1, parteCorp.getNume());
                        psInsert.executeUpdate();
                        ResultSet rsKey = psInsert.getGeneratedKeys();
                        if (rsKey.next()) {
                            parteCorpId = rsKey.getInt(1);
                        } else {
                            throw new SQLException("Esuare adaugare parte corp, nu s-a generat ID");
                        }
                    }
                }
            }
            
            try (PreparedStatement psInsertDiagnostic = conn.prepareStatement(insertDiagnosticSql)) {
                for (Diagnostic diagnostic : parteCorp.getDiagnostice()) {
                    psInsertDiagnostic.setString(1, diagnostic.getNume());
                    psInsertDiagnostic.setString(2, String.join(",", diagnostic.getSimptome()));
                    psInsertDiagnostic.setString(3, diagnostic.getCauze());
                    psInsertDiagnostic.setString(4, diagnostic.getIndicatii());
                    psInsertDiagnostic.setBoolean(5, diagnostic.getGrav());
                    psInsertDiagnostic.setInt(6, parteCorpId);
                    psInsertDiagnostic.executeUpdate();
                }
            }
            
            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Eroare la adaugare/updatare parte corp: " + e.getMessage());
            return false;
        }
    }

}
