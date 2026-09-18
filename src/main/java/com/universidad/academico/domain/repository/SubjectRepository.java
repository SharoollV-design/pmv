package main.java.com.universidad.academico.domain.repository;

import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Subject;

public interface SubjectRepository {
    void save(Subject subject);
    Optional<Subject> findByCodigo(String codigo);
    List<Subject> findAll();
    void delete(String codigo);
}
