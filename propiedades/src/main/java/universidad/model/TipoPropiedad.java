package universidad.model;

public enum TipoPropiedad {
    APARTAMENTO("Apartamento"),
    HABITACION("Habitación"),
    CASA("Casa");

    private final String valor;

    TipoPropiedad(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static TipoPropiedad fromString(String texto) {
        for (TipoPropiedad tipo : TipoPropiedad.values()) {
            if (tipo.valor.equalsIgnoreCase(texto)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de propiedad no válido: " + texto);
    }
}