package test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import obiecte.Pacient;
import obiecte.Particularitati;
import repository.PacientRepository;

/**
 * Testare clasa PacientRepository pt interactiune cu baza de date
 */
public class PacientRepositoryTest {

	/**
	 * Cream un obiect tip Connection fals pentru a simula conexiunea fara modificari reale
	 */
    @Mock
    private Connection conn;
    
    /**
     * Cream un obiect tip PreaparedStatement false pt a simula statementurile fara modificari reale
     */
    @Mock
    private PreparedStatement pstmt;
    
    @Mock
    private ResultSet rs;

    /** 
     * Facem setup inainte de fiecare test
     * @throws SQLException
     */
    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);

        when(conn.prepareStatement(anyString())).thenReturn(pstmt);
    }

    /**
     * Testare adaugare pacient
     * @throws SQLException
     */
    @Test
    public void testAddPacient() throws SQLException {
        Particularitati particularitati = new Particularitati("M", 25, 70, 170); 
        Pacient pacient = new Pacient("Capac Stefan", "capacstefan", "BobDylan", particularitati);
        
        when(pstmt.executeUpdate()).thenReturn(1); 
        
        boolean result = PacientRepository.addPacient(pacient);
        
        assertTrue(result, "Pacientul a fost adăugat cu succes.");

        verify(pstmt, times(1)).executeUpdate();
    }
    
    /**
     * Testare validare login true
     * @throws SQLException
     */
    @Test
    public void testValidateLoginValid() throws SQLException {

        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true); 

        boolean result = PacientRepository.validateLogin("ionpopescu", "parola123");

        assertTrue(result, "Login valid.");
        verify(pstmt, times(1)).setString(1, "ionpopescu");
        verify(pstmt, times(1)).setString(2, "parola123");
    }

    /**
     * Testare valiare login false
     * @throws SQLException
     */
    @Test
    public void testValidateLoginInvalid() throws SQLException {
        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(false); 

        boolean result = PacientRepository.validateLogin("ionpopescu", "parola123");

        assertFalse(result, "Login invalid.");
        verify(pstmt, times(1)).setString(1, "ionpopescu");
        verify(pstmt, times(1)).setString(2, "parola123");
    }

    /**
     * Testare username bun
     * @throws SQLException
     */
    @Test
    public void testTakenUsernameTrue() throws SQLException {
        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true); 

        boolean result = PacientRepository.takenUsername("ionpopescu");

        assertTrue(result, "Username-ul este deja luat.");
        verify(pstmt, times(1)).setString(1, "ionpopescu");
    }

    /**
     * Testare username folosit
     * @throws SQLException
     */
    @Test
    public void testTakenUsernameFalse() throws SQLException {
        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(false); 
        boolean result = PacientRepository.takenUsername("ionpopescu");

        assertFalse(result, "Username-ul nu este luat.");
        verify(pstmt, times(1)).setString(1, "ionpopescu");
    }
    
    /**
     * Testare stergere pacient
     * @throws SQLException
     */
    @Test
    public void testDeletePacient() throws SQLException {
        when(pstmt.executeUpdate()).thenReturn(1); 
        
        PacientRepository.deletePacient("ionpopescu");
        
        verify(pstmt, times(1)).setString(1, "ionpopescu");
        verify(pstmt, times(1)).executeUpdate();
    }

    /**
     * Testare update pacient
     * @throws SQLException
     */
    @Test
    public void testUpdatePacient() throws SQLException {
        Particularitati particularitati = new Particularitati("M", 25, 70, 170);
        Pacient pacient = new Pacient("Ion Popescu", "ionpopescu", "parola123", particularitati);

        when(pstmt.executeUpdate()).thenReturn(1);
        
        boolean result = PacientRepository.updatePacient(pacient);
        
        assertTrue(result, "Pacientul a fost actualizat cu succes.");
        
        verify(pstmt, times(1)).executeUpdate();
    }
}

