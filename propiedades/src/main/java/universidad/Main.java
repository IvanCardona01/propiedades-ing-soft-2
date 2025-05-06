package universidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:sqlite:propiedades.db";
    private static Connection conn;

    public static void main(String[] args) {
        try {
            // Establecer conexión con la base de datos
            establecerConexion();
            crearTablas();
            insertarDatosEjemplo();

            System.out.println("Connection to SQLite has been established.");
            System.out.println("Operaciones del sistema");
            System.out.println("1. Listar propiedades.");
            System.out.println("2. Ver si es posible cancelar reserva.");
            System.out.println("3. Salir.");

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.print("\nSeleccione una opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1":
                        listarPropiedades();
                        break;
                    case "2":
                        verificarCancelacionReserva();
                        break;
                    case "3":
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    private static void establecerConexion() throws SQLException {
        conn = DriverManager.getConnection(DB_URL);
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

    private static void insertarDatosEjemplo() throws SQLException {
        // Primero limpiamos la tabla
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM propiedades");
        }

        // Insertamos los datos de ejemplo
        String sql = "INSERT INTO propiedades (nombre, tipo, huespedes) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Propiedad 1
            pstmt.setString(1, "Apartamento de 3 habitaciones en el sur de la ciudad");
            pstmt.setString(2, "Apartamento");
            pstmt.setInt(3, 5);
            pstmt.executeUpdate();

            // Propiedad 2
            pstmt.setString(1, "Habitación con cama doble");
            pstmt.setString(2, "Habitación");
            pstmt.setInt(3, 2);
            pstmt.executeUpdate();

            // Propiedad 3
            pstmt.setString(1, "Casa campestre exclusiva");
            pstmt.setString(2, "Casa");
            pstmt.setInt(3, 10);
            pstmt.executeUpdate();
        }
    }

    private static void listarPropiedades() throws SQLException {
        String sql = "SELECT * FROM propiedades";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int huespedes = rs.getInt("huespedes");
                System.out.println(new Propiedad(nombre, tipo, huespedes));
            }
        }
    }

    private static void verificarCancelacionReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuántos días faltan para el inicio de la reserva?");
        int dias = Integer.parseInt(scanner.nextLine());

        System.out.println("¿Qué tipo de propiedad es? (1 = Apartamento, 2 = Habitación, 3 = Casa)");
        int tipoPropiedad = Integer.parseInt(scanner.nextLine());

        if (dias < 4) {
            System.out.println("No se puede cancelar la reserva");
        } else if (tipoPropiedad == 1 || tipoPropiedad == 3) {
            System.out.println("No se puede cancelar la reserva");
        } else {
            System.out.println("Se puede cancelar la reserva");
        }
    }
}