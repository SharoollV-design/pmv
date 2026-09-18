package main.java.com.universidad.academico.application.usecase;

import main.java.com.universidad.academico.domain.model.Estudiante;
import main.java.com.universidad.academico.domain.repository.EstudianteRepository;

public class RegisterEstudianteUseCase {
    private final EstudianteRepository estudianteRepository;

    public RegisterEstudianteUseCase(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public void execute(Estudiante estudiante) {

        if (estudianteRepository.findById(estudiante.getId()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un estudiante registrado con el ID: " + estudiante.getId());
        }
        if (estudianteRepository.findByEmail(estudiante.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un estudiante registrado con el correo: " + estudiante.getEmail());
        }

        estudianteRepository.save(estudiante);
        System.out.println("Estudiante registrado exitosamente: " + estudiante.getNombre() + " " + estudiante.getApellido());
    }
}
