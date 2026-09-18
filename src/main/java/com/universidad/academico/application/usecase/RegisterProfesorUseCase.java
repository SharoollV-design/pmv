package main.java.com.universidad.academico.application.usecase;

import main.java.com.universidad.academico.domain.model.Profesor;
import main.java.com.universidad.academico.domain.repository.ProfesorRepository;

public class RegisterProfesorUseCase {
    private final ProfesorRepository profesorRepository;

    public RegisterProfesorUseCase(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public void execute(Profesor profesor) {
        if (profesorRepository.findByEmail(profesor.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un profesor registrado con el correo: " + profesor.getEmail());
        }

        profesorRepository.save(profesor);
        System.out.println("Profesor registrado exitosamente en el sistema");
    }
}
