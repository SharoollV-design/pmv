package main.java.com.universidad.academico.application.usecase;

import main.java.com.universidad.academico.domain.model.Calificacion;
import main.java.com.universidad.academico.domain.repository.CalificacionRepository;
import main.java.com.universidad.academico.domain.repository.EstudianteRepository;
import main.java.com.universidad.academico.domain.repository.SubjectRepository;

public class RegisterCalificacionUseCase {
    private final CalificacionRepository calificacionRepository;
    private final EstudianteRepository estudianteRepository;
    private final SubjectRepository subjectRepository;

    public RegisterCalificacionUseCase(CalificacionRepository calificacionRepository, EstudianteRepository estudianteRepository,SubjectRepository subjectRepository) {
        this.calificacionRepository = calificacionRepository;
        this.estudianteRepository = estudianteRepository;
        this.subjectRepository = subjectRepository;
    }

    public void execute(Calificacion calificacion) {
    
        boolean estudianteExiste = estudianteRepository.findById(calificacion.getEstudianteId()).isPresent();
        if (!estudianteExiste) {
            throw new IllegalArgumentException("No se puede registrar la calificación: El estudiante con ID " + calificacion.getEstudianteId() + " no existe.");
        }

 
        boolean subjectExiste = subjectRepository.findByCodigo(calificacion.getSubjectCode()).isPresent();
        if (!subjectExiste) {
            throw new IllegalArgumentException("No se puede registrar la calificación: La asignatura con código " + calificacion.getSubjectCode() + " no existe.");
        }


        calificacionRepository.save(calificacion);
    }
}
