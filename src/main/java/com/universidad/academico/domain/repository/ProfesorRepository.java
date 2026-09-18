package main.java.com.universidad.academico.domain.repository;

import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Profesor;

public interface ProfesorRepository {
    void save(Profesor profesor);
    Optional<Profesor> findByEmail(String email);
    List<Profesor> findAll ();
    void delete(String id);
}
