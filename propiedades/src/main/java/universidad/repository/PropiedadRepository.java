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
                propiedades.add(new Propiedad(
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("huespedes")));
            }
        }
        return propiedades;
    }

    public void insertarDatosEjemplo() throws SQLException {
        String sql = "INSERT INTO propiedades (nombre, tipo, huespedes) VALUES (?, ?, ?)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM propiedades");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Apartamento de 3 habitaciones en el sur de la ciudad");
            pstmt.setString(2, "Apartamento");
            pstmt.setInt(3, 5);
            pstmt.executeUpdate();

            pstmt.setString(1, "Habitación con cama doble");
            pstmt.setString(2, "Habitación");
            pstmt.setInt(3, 2);
            pstmt.executeUpdate();

            pstmt.setString(1, "Casa campestre exclusiva");
            pstmt.setString(2, "Casa");
            pstmt.setInt(3, 10);
            pstmt.executeUpdate();
        }
    }
}