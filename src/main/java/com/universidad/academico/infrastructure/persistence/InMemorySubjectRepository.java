package main.java.com.universidad.academico.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Subject;
import main.java.com.universidad.academico.domain.repository.SubjectRepository;

public class InMemorySubjectRepository implements SubjectRepository{
    private final List<Subject> database = new ArrayList<>();

    @Override
    public void save(Subject subject) {
        database.removeIf(s -> s.getCodigo().equals(subject.getCodigo()));
        database.add(subject);
    }

    @Override
    public Optional<Subject> findByCodigo(String codigo) {
        return database.stream()
                .filter(s -> s.getCodigo().equals(codigo))
                .findFirst();
    }

    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public void delete(String codigo) {
        database.removeIf(s -> s.getCodigo().equals(codigo));
    }

}
