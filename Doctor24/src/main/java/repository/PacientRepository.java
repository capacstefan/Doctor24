package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import database.MySQLConnection;
import obiecte.Pacient;
import obiecte.Particularitati;

/**
 * Clasa repository pentru operatiile efectuate asupra pacientilor in baza de date
 */
public class PacientRepository {

    /**
     * Metoda validare credentiale
     * @param username
     * @param password
     * @return
     */
    public static boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM pacienti WHERE username = ? AND password = ?";
        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Eroare la validare credentiale: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metoda validare unicitate username
     * @param username
     * @return
     */
    public static boolean takenUsername(String username) {
        String sql = "SELECT COUNT(*) FROM pacienti WHERE username = ?";
        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Eroare la verificarea username-ului: " + e.getMessage());
        }
        return false;
    }

    /**
     * Metoda adaugare pacient in baza de date
     * @param pacient
     * @return
     */
    public static boolean addPacient(Pacient pacient) {
        String sql = "INSERT INTO pacienti (nume, username, password, particularitati, istoric) VALUES(?, ?, ?, ?, ?)";
        Particularitati partic = pacient.getParticularitati();
        Gson gson = new Gson();
        String particularitati = gson.toJson(partic);

        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pacient.getNume());
            pstmt.setString(2, pacient.getUsername());
            pstmt.setString(3, pacient.getPassword());
            pstmt.setString(4, particularitati);
            pstmt.setString(5, pacient.getIstoric());
            pstmt.executeUpdate();
            System.out.println("Pacient adaugat cu succes.");
            return true;
        } catch (SQLException e) {
            System.out.println("Eroare adaugare pacientului: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metoda update pacient in baza de date
     * @param pacient
     * @return
     */
    public static boolean updatePacient(Pacient pacient) {
        String sql = "UPDATE pacienti SET nume = ?, password = ?, particularitati = ?, istoric = ? WHERE username = ?";
        Particularitati partic = pacient.getParticularitati();
        Gson gson = new Gson();
        String particularitati = gson.toJson(partic);

        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pacient.getNume());
            pstmt.setString(2, pacient.getPassword());
            pstmt.setString(3, particularitati);
            pstmt.setString(4, pacient.getIstoric());
            pstmt.setString(5, pacient.getUsername());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Pacient modificat");
                return true;
            } else {
                System.out.println("Modficiari nerealizate");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Eroare modificare pacient: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metoda stergere pacient din baza de date
     * @param username
     */
    public static void deletePacient(String username) {
        String sql = "DELETE FROM pacienti WHERE username = ?";

        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            System.out.println("Pacient sters");
        } catch (SQLException e) {
            System.out.println("Eroare stergere: " + e.getMessage());
        }
    }

    /**
     * Metoda extragere particularitati pacient din baza de date
     * @param username
     * @return
     */
    public static Particularitati getParticularitati(String username) {
        String sql = "SELECT particularitati FROM pacienti WHERE username = ?";
        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String particularitatiJson = rs.getString("particularitati");
                Gson gson = new Gson();
                return gson.fromJson(particularitatiJson, Particularitati.class);
            }
        } catch (SQLException e) {
            System.out.println("Eroare extragerea particularitasti: " + e.getMessage());
        }
        return null;
    }

    /**
     * Metoda extragere istoric pacient din baza de date
     * @param username
     * @return
     */
    public static Map<String, String> getIstoric(String username) {
        String sql = "SELECT istoric FROM pacienti WHERE username = ?";
        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String istoricJson = rs.getString("istoric");
                Gson gson = new Gson();
                return gson.fromJson(istoricJson, new TypeToken<HashMap<String, String>>() {}.getType());
            }
        } catch (SQLException e) {
            System.out.println("Eroare preluare istoric: " + e.getMessage());
        }
        return new HashMap<>();
    }

    /**
     * Metoda update istoric pacient in baza de date
     * @param username
     * @param istoric
     */
    public static void updateIstoric(String username, Map<String, String> istoric) {
        String sql = "UPDATE pacienti SET istoric = ? WHERE username = ?";
        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            Gson gson = new Gson();
            String istoricJson = gson.toJson(istoric);
            pstmt.setString(1, istoricJson);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare actualizare istoric: " + e.getMessage());
        }
    }

    /**
     * Metoda update sex pacient in baza de date
     * @param username
     * @param sex
     */
    public static void updateSex(String username, String sex) {
        String sql = "UPDATE pacienti SET particularitati = JSON_SET(particularitati, '$.sex', ?) WHERE username = ?";

        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sex);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare modificare sex: " + e.getMessage());
        }
    }

    /**
     * Metoda update varsta in baza de date
     * @param username
     * @param varsta
     */
    public static void updateVarsta(String username, int varsta) {
        String sql = "UPDATE pacienti SET particularitati = JSON_SET(particularitati, '$.varsta', ?) WHERE username = ?";

        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, varsta);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare modificare varsta: " + e.getMessage());
        }
    }

    /**
     * Metoda update greutate in baza de date
     * @param username
     * @param greutate
     */
    public static void updateGreutate(String username, int greutate) {
        String sql = "UPDATE pacienti SET particularitati = JSON_SET(particularitati, '$.greutate', ?) WHERE username = ?";

        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, greutate);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare modificare greutate: " + e.getMessage());
        }
    }

    /**
     * Metoda update inaltime in baza de date
     * @param username
     * @param inaltime
     */
    public static void updateInaltime(String username, double inaltime) {
        String sql = "UPDATE pacienti SET particularitati = JSON_SET(particularitati, '$.inaltime', ?) WHERE username = ?";

        try (Connection conn = MySQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, inaltime);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare modificare inaltime: " + e.getMessage());
        }
    }
}
