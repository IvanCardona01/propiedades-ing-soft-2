package universidad.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import universidad.model.Propiedad;

public class PropiedadRepository {
    private Connection conn;

    public PropiedadRepository() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
    }

    public List<Propiedad> findAll() throws SQLException {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM propiedades";

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String tipo = rs.getString("tipo");

                Propiedad propiedad = new Propiedad(
                        rs.getString("nombre"),
                        tipo,
                        rs.getInt("huespedes"));
                propiedades.add(propiedad);
            }
        }
        return propiedades;
    }

    public void insertarDatosEjemplo() throws SQLException {
        // Primero limpiamos la tabla
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM propiedades");
        }

        String sql = "INSERT INTO propiedades (nombre, tipo, huespedes) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Propiedad 1
            pstmt.setString(1, "Apartamento de 3 habitaciones en el sur de la ciudad");
            pstmt.setString(2, "APARTAMENTO"); // Cambiado a mayúsculas para coincidir con el enum
            pstmt.setInt(3, 5);
            pstmt.executeUpdate();

            // Propiedad 2
            pstmt.setString(1, "Habitación con cama doble");
            pstmt.setString(2, "HABITACION"); // Cambiado a mayúsculas para coincidir con el enum
            pstmt.setInt(3, 2);
            pstmt.executeUpdate();

            // Propiedad 3
            pstmt.setString(1, "Casa campestre exclusiva");
            pstmt.setString(2, "CASA"); // Cambiado a mayúsculas para coincidir con el enum
            pstmt.setInt(3, 10);
            pstmt.executeUpdate();
        }
    }
}