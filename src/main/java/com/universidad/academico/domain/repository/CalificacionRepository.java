package main.java.com.universidad.academico.domain.repository;

import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Calificacion;

public interface CalificacionRepository {
    Optional<Calificacion> findById(String id);
    List<Calificacion> findByEstudianteId(String estudianteId);
    List<Calificacion> findBySubjectCode(String subjectCode);
    List<Calificacion> findAll();
    void delete(String id);
    void save(Calificacion calificacion);
}
