package universidad.presentation;

import java.sql.SQLException;
import java.util.Scanner;
import universidad.service.PropiedadService;
import universidad.service.ReservaService;

public class MenuController {
    private final PropiedadService propiedadService;
    private final ReservaService reservaService;
    private final Scanner scanner;

    public MenuController(PropiedadService propiedadService, ReservaService reservaService) {
        this.propiedadService = propiedadService;
        this.reservaService = reservaService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() throws SQLException {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOperaciones del sistema");
            System.out.println("1. Listar propiedades.");
            System.out.println("2. Ver si es posible cancelar reserva.");
            System.out.println("3. Salir.");
            System.out.print("\nSeleccione una opción: ");
            
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    propiedadService.listarPropiedades();
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
    }

    private void verificarCancelacionReserva() {
        System.out.println("¿Cuántos días faltan para el inicio de la reserva?");
        int dias = Integer.parseInt(scanner.nextLine());

        System.out.println("¿Qué tipo de propiedad es? (1 = Apartamento, 2 = Habitación, 3 = Casa)");
        int tipoPropiedad = Integer.parseInt(scanner.nextLine());

        boolean puedesCancelar = reservaService.verificarCancelacion(dias, tipoPropiedad);
        System.out.println(puedesCancelar ? "Se puede cancelar la reserva" : "No se puede cancelar la reserva");
    }
}