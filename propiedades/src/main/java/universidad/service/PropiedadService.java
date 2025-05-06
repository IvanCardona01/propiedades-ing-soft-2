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

    public List<Propiedad> listarPropiedades() throws SQLException {
        return repository.findAll();
    }
}