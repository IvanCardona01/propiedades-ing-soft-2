package universidad;

import java.sql.SQLException;
import universidad.repository.PropiedadRepository;
import universidad.service.PropiedadService;
import universidad.service.ReservaService;
import universidad.presentation.MenuController;

public class Main {
    public static void main(String[] args) {
        try {
            PropiedadRepository repository = new PropiedadRepository();
            repository.insertarDatosEjemplo();

            PropiedadService propiedadService = new PropiedadService(repository);
            ReservaService reservaService = new ReservaService();

            MenuController menuController = new MenuController(propiedadService, reservaService);
            menuController.mostrarMenu();

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }
}