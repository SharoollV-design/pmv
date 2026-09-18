package main.java.com.universidad.academico.application.usecase;

import main.java.com.universidad.academico.domain.model.Examen;
import main.java.com.universidad.academico.domain.repository.ExamenRepository;

public class RegisterExamenUseCase {
    
    private final ExamenRepository examenRepository;

    public RegisterExamenUseCase(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    public void execute(Examen examen) {
    
        if (examenRepository.findById(examen.getId()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un examen registrado con el ID: " + examen.getId());
        }

        examenRepository.save(examen);
        System.out.println("Examen programado exitosamente: " + examen.getTitulo());
    }
}
