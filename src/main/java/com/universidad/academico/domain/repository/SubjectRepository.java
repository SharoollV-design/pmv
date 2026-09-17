package src.main.java.com.universidad.academico.domain.repository;

import src.main.java.com.universidad.academico.domain.model.Subject;
import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    void save(Subject subject);
    Optional<Subject> findByCodigo(String codigo);
    List<Subject> findAll();
    void delete(String codigo);
}
