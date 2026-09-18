package main.java.com.universidad.academico.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.com.universidad.academico.domain.model.Inscripcion;
import main.java.com.universidad.academico.domain.repository.InscripcionRepository;

public class InMemoryInscripcionRepository implements InscripcionRepository {
    private final List <Inscripcion> database = new ArrayList<>();

    @Override
    public void save(Inscripcion inscripcion) {
        database.removeIf(i -> i.getId().equals(inscripcion.getId()));
        database.add(inscripcion);
    }

    @Override
    public Optional<Inscripcion> findById(String id) {
        return database.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Inscripcion> findByEstudianteId(String estudianteId) {
        return database.stream()
                .filter(i -> i.getEstudianteId().equals(estudianteId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Inscripcion> findBySubjectCode(String subjectCode) {
        return database.stream()
                .filter(i -> i.getSubjectCode().equals(subjectCode))
                .collect(Collectors.toList());
    }

    @Override
    public List<Inscripcion> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public void delete(String id) {
        database.removeIf(i -> i.getId().equals(id));
    }
}