package test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.MySQLConnection;

class MySQLConnectionTest {

    private MySQLConnection mySQLConnection;

    // Setup-ul înainte de fiecare test
    @BeforeEach
    void setUp() {
        mySQLConnection = new MySQLConnection();
    }

    // Testare conexiune reusita
    @Test
    void testConnect() throws SQLException {
        // Cream o conexiune
        Connection conn = mySQLConnection.connect();

        // Verificam sa nu fie null conexiunea
        assertNotNull(conn);
    }
}

    
