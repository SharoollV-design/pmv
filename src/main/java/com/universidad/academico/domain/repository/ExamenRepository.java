package main.java.com.universidad.academico.domain.repository;

import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Examen;

public interface ExamenRepository {
    void save(Examen examen);
    Optional<Examen> findById(String id);
    List<Examen> findAll();
    List<Examen> findBySubjectCode(String subjectCode);
    void delete(String id);
}
