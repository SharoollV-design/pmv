package main.java.com.universidad.academico.domain.repository;

import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Estudiante;

public interface EstudianteRepository {

    void save(Estudiante estudiante);

    Optional<Estudiante> findById(String id);

    Optional<Estudiante> findByEmail(String email);

    List<Estudiante> findAll();

    void delete(String id);
}
