package universidad;

public class Propiedad {
    private String nombre;
    private String tipo;
    private int huespedes;

    public Propiedad(String nombre, String tipo, int huespedes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.huespedes = huespedes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHuespedes() {
        return huespedes;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", Huéspedes: " + huespedes;
    }
}
