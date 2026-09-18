package main.java.com.universidad.academico.application.usecase;

import main.java.com.universidad.academico.domain.model.Inscripcion;
import main.java.com.universidad.academico.domain.repository.EstudianteRepository;
import main.java.com.universidad.academico.domain.repository.InscripcionRepository;
import main.java.com.universidad.academico.domain.repository.SubjectRepository;


public class RegisterInscripcionUseCase {
    private final InscripcionRepository inscripcionRepository;
    private final EstudianteRepository estudianteRepository;
    private final SubjectRepository subjectRepository;

    public RegisterInscripcionUseCase(InscripcionRepository inscripcionRepository, EstudianteRepository estudianteRepository, SubjectRepository subjectRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.estudianteRepository = estudianteRepository;
        this.subjectRepository = subjectRepository;
    }

    public void execute(Inscripcion inscripcion) {
        if (estudianteRepository.findById(inscripcion.getEstudianteId()).isEmpty()) {
            throw new IllegalArgumentException("No se puede matricular: El estudiante con ID " + inscripcion.getEstudianteId() + " no está registrado.");
        }

       
        if (subjectRepository.findByCodigo(inscripcion.getSubjectCode()).isEmpty()) {
            throw new IllegalArgumentException("No se puede matricular: La asignatura con código " + inscripcion.getSubjectCode() + " no existe.");
        }

       
        boolean yaInscrito = inscripcionRepository.findByEstudianteId(inscripcion.getEstudianteId()).stream().anyMatch(i -> i.getSubjectCode().equals(inscripcion.getSubjectCode()));

        if (yaInscrito) {
            throw new IllegalArgumentException("El estudiante ya se encuentra matriculado en esta asignatura.");
        }

        inscripcionRepository.save(inscripcion);
        System.out.println("Inscripción exitosa: Estudiante " + inscripcion.getEstudianteId() + " en asignatura " + inscripcion.getSubjectCode());
    }
}
