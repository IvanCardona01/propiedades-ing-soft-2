package universidad.service;

public class ReservaService {
    public boolean verificarCancelacion(int dias, int tipoPropiedad) {
        if (dias < 4) {
            return false;
        } else if (tipoPropiedad == 1 || tipoPropiedad == 3) {
            return false;
        }
        return true;
    }
}