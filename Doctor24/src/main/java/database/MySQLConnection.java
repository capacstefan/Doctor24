package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clasa conexiune baza de date MySQL
 */
public class MySQLConnection {
    /**
     * Metoda connect
     * @return Connection object
     */
    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/pacienti"; 
        String user = "root"; 
        String password = "root"; 
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexiune reusita!");
        } catch (SQLException e) {
            System.out.println("Eroare conexiune: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = connect();
        if (conn != null) {
            try {
                conn.close(); 
                System.out.println("Conexiune inchisa.");
            } catch (SQLException e) {
                System.out.println("Eroare la inchidere: " + e.getMessage());
            }
        }
    }
}
