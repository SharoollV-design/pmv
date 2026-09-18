package main.java.com.universidad.academico.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import main.java.com.universidad.academico.domain.model.Examen;
import main.java.com.universidad.academico.domain.repository.ExamenRepository;

public class InMemoryExamenRepository implements  ExamenRepository{
    private final List<Examen> database = new ArrayList<>();

    @Override
    public void save(Examen examen) {
        database.removeIf(e -> e.getId().equals(examen.getId()));
        database.add(examen);
    }

    @Override
    public Optional<Examen> findById(String id) {
        return database.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Examen> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public List<Examen> findBySubjectCode(String subjectCode) {
        return database.stream()
                .filter(e -> e.getSubjectCode().equals(subjectCode))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        database.removeIf(e -> e.getId().equals(id));
    }
}
