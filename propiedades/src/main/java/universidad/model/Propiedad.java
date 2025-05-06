package universidad.model;

public class Propiedad {
    private String nombre;
    private TipoPropiedad tipo;
    private int huespedes;

    public Propiedad(String nombre, String tipoStr, int huespedes) {
        this.nombre = nombre;
        this.tipo = TipoPropiedad.fromString(tipoStr);
        this.huespedes = huespedes;
    }

    @Override
    public String toString() {
        return String.format("Propiedad: %s - Tipo: %s - Huéspedes: %d", 
            nombre, tipo, huespedes);
    }
}