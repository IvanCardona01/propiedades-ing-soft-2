package universidad.model;

public class Propiedad {
    private Long id;
    private String nombre;
    private TipoPropiedad tipo;
    private int huespedes;

    public Propiedad(String nombre, String tipo, int huespedes) {
        this.nombre = nombre;
        this.tipo = TipoPropiedad.valueOf(tipo);
        this.huespedes = huespedes;
    }

    @Override
    public String toString() {
        return "Propiedad: " + nombre + " - Tipo: " + tipo + " - Huéspedes: " + huespedes;
    }
}