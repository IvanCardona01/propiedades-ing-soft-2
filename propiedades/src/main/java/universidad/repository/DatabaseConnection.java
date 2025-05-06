package universidad.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:propiedades.db";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(DB_URL);
            crearTablas();
        }
        return conn;
    }

    private static void crearTablas() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS propiedades (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "tipo TEXT NOT NULL," +
                "huespedes INTEGER NOT NULL)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
}