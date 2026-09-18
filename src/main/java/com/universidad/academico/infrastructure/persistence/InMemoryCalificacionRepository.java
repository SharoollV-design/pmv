package main.java.com.universidad.academico.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import main.java.com.universidad.academico.domain.model.Calificacion;
import main.java.com.universidad.academico.domain.repository.CalificacionRepository;

public class InMemoryCalificacionRepository implements CalificacionRepository {
    private final List<Calificacion> calificaciones = new ArrayList<>();

    @Override
    public void save(Calificacion calificacion) {
        calificaciones.add(calificacion);
        System.out.println("Calificación registrada exitosamente para el estudiante: " + calificacion.getEstudianteId());
    }

    @Override
    public Optional<Calificacion> findById(String id) {
        return calificaciones.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Calificacion> findByEstudianteId(String estudianteId) {
        return calificaciones.stream()
                .filter(c -> c.getEstudianteId().equals(estudianteId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Calificacion> findBySubjectCode(String subjectCode) {
        return calificaciones.stream()
                .filter(c -> c.getSubjectCode().equals(subjectCode))
                .collect(Collectors.toList());
    }

    @Override
    public List<Calificacion> findAll() {
        return new ArrayList<>(calificaciones);
    }

    @Override
    public void delete(String id) {
        calificaciones.removeIf(c -> c.getId().equals(id));
    }
}
