package main.java.com.universidad.academico.domain.repository;

import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Inscripcion;

public interface  InscripcionRepository {
    void save(Inscripcion inscripcion);
    Optional<Inscripcion> findById(String id);
    List<Inscripcion> findByEstudianteId(String estudianteId);
    List<Inscripcion> findBySubjectCode(String subjectCode);
    List<Inscripcion> findAll();
    void delete(String id);
}
