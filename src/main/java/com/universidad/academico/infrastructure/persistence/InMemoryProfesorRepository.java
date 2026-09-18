package main.java.com.universidad.academico.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.java.com.universidad.academico.domain.model.Profesor;
import main.java.com.universidad.academico.domain.repository.ProfesorRepository;

public class InMemoryProfesorRepository implements ProfesorRepository{
    private final List<Profesor> database = new ArrayList<>();

    @Override
    public void save(Profesor profesor) {
        database.removeIf(p -> p.getEmail().equals(profesor.getEmail()));
        database.add(profesor);
    }

    @Override
    public Optional<Profesor> findByEmail(String email) {
        return database.stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public List<Profesor> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public void delete(String id) {
        database.removeIf(p -> p.getId().equals(id));
    }
    
}
