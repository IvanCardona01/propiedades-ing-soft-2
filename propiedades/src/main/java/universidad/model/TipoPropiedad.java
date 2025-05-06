package universidad.model;

public enum TipoPropiedad {
    APARTAMENTO,
    HABITACION,
    CASA;

    public static TipoPropiedad fromString(String texto) {
        try {
            return TipoPropiedad.valueOf(texto.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de propiedad no válido: " + texto);
        }
    }

    @Override
    public String toString() {
        return name().substring(0, 1) + name().substring(1).toLowerCase();
    }
}