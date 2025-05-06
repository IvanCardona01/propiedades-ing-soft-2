package universidad.service;

import java.sql.SQLException;
import java.util.List;
import universidad.model.Propiedad;
import universidad.repository.PropiedadRepository;

public class PropiedadService {
    private final PropiedadRepository repository;

    public PropiedadService(PropiedadRepository repository) {
        this.repository = repository;
    }

    public void listarPropiedades() throws SQLException {
        List<Propiedad> propiedades = repository.findAll();
        for (Propiedad propiedad : propiedades) {
            System.out.println(propiedad);
        }
    }
}