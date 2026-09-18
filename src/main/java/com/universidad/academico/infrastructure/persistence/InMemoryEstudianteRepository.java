package main.java.com.universidad.academico.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.com.universidad.academico.domain.model.Estudiante;
import main.java.com.universidad.academico.domain.repository.EstudianteRepository;

public class InMemoryEstudianteRepository implements EstudianteRepository {
    private final List<Estudiante> database = new ArrayList<>();

    @Override
    public void save(Estudiante estudiante) {
        database.removeIf(e -> e.getId().equals(estudiante.getId()));
        database.add(estudiante);
    }

    @Override
    public Optional<Estudiante> findById(String id) {
        return database.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Estudiante> findByEmail(String email) {
        return database.stream()
                .filter(e -> e.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<Estudiante> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public void delete(String id) {
        database.removeIf(e -> e.getId().equals(id));
    }
    
}
