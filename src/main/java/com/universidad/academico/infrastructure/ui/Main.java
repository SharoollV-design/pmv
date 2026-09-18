package main.java.com.universidad.academico.infrastructure.ui;

import java.time.LocalDate;
import main.java.com.universidad.academico.application.usecase.RegisterCalificacionUseCase;
import main.java.com.universidad.academico.application.usecase.RegisterEstudianteUseCase;
import main.java.com.universidad.academico.application.usecase.RegisterExamenUseCase;
import main.java.com.universidad.academico.application.usecase.RegisterInscripcionUseCase;
import main.java.com.universidad.academico.application.usecase.RegisterProfesorUseCase;
import main.java.com.universidad.academico.application.usecase.RegisterSubjectUseCase;
import main.java.com.universidad.academico.domain.model.Calificacion;
import main.java.com.universidad.academico.domain.model.Estudiante;
import main.java.com.universidad.academico.domain.model.Examen;
import main.java.com.universidad.academico.domain.model.Inscripcion;
import main.java.com.universidad.academico.domain.model.Profesor;
import main.java.com.universidad.academico.domain.model.Subject;
import main.java.com.universidad.academico.domain.repository.CalificacionRepository;
import main.java.com.universidad.academico.domain.repository.EstudianteRepository;
import main.java.com.universidad.academico.domain.repository.ExamenRepository;
import main.java.com.universidad.academico.domain.repository.InscripcionRepository;
import main.java.com.universidad.academico.domain.repository.ProfesorRepository;
import main.java.com.universidad.academico.domain.repository.SubjectRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemoryCalificacionRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemoryEstudianteRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemoryExamenRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemoryInscripcionRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemoryProfesorRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemorySubjectRepository;

public class Main {
    public static void main(String[] args) {
        // == Modulo asignaturas === //
        SubjectRepository repository = new InMemorySubjectRepository();


        RegisterSubjectUseCase registerUseCase = new RegisterSubjectUseCase(repository);

        try {
            Subject nuevaAsignatura = new Subject(
                "SOF-101", 
                "Arquitectura de Software", 
                "Introducción a la arquitectura hexagonal y DDD", 
                4, 
                2026, 
                "Tercer Semestre", 
                "Lunes 8:00 AM"
            );

            registerUseCase.execute(nuevaAsignatura);

            System.out.println("Total de asignaturas guardadas: " + repository.findAll().size());

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }

        System.out.println("<<33");

        // == Modulo profesores == //

        ProfesorRepository profesorRepository = new InMemoryProfesorRepository();
        RegisterProfesorUseCase registerProfesorUseCase = new RegisterProfesorUseCase(profesorRepository);

        try {
            Profesor nuevoProfesor = new Profesor(
                "PROF-001",
                "Carlos",
                "Montoya",
                "carlos.perez@uchile.cl",
                "Ingeniería de software"
            );

            registerProfesorUseCase.execute(nuevoProfesor);
            System.out.println("Total de profesores guardados: " + profesorRepository.findAll().size());

        } catch (Exception e) {
            System.out.println("Error en Profesores: " + e.getMessage());
        }
        
        System.out.println("=== Ejecución finalizada ===");

        System.out.println(" <<33 ");

        // == Modulo examenes == 

        ExamenRepository examenRepository = new InMemoryExamenRepository();
        RegisterExamenUseCase registerExamenUseCase = new RegisterExamenUseCase(examenRepository);

        try {
            Examen nuevoExamen = new Examen(
                "EX-001",
                "Parcial 1: Arquitectura Hexagonal",
                "SOF-101",
                LocalDate.of(2026, 4, 15),
                30.0
            );

            registerExamenUseCase.execute(nuevoExamen);
            System.out.println("Total de exámenes programados: " + examenRepository.findAll().size());

        } catch (Exception e) {
            System.out.println("Error en Exámenes: " + e.getMessage());
        }
        
        System.out.println("=== Ejecucion finalizada ===");

        System.out.println(" <<33 ");

        System.out.println("     ");

        EstudianteRepository estudianteRepository = new InMemoryEstudianteRepository();
        RegisterEstudianteUseCase registerEstudianteUseCase = new RegisterEstudianteUseCase(estudianteRepository);

        try {
            Estudiante nuevoEstudiante = new Estudiante(
                "EST-001",
                "Sharoll ",
                "Meza Villadiego",
                "ana.gomez@uchile.cl",
                "Ingeniería de Software"
            );

            registerEstudianteUseCase.execute(nuevoEstudiante);
            System.out.println("Total de estudiantes guardados: " + estudianteRepository.findAll().size());

        } catch (Exception e) {
            System.out.println("Error en Estudiantes: " + e.getMessage());
        }
        
        System.out.println("=== Ejecucion finalizada ===");

        System.out.println("<<33");

        System.out.println("     ");

        // === Modulo inscripciones === 
       InscripcionRepository inscripcionRepository = new InMemoryInscripcionRepository();

        RegisterInscripcionUseCase registerInscripcionUseCase = new RegisterInscripcionUseCase(inscripcionRepository, estudianteRepository, repository);

        try {
            Inscripcion nuevaInscripcion = new Inscripcion(
                "INS-001",
                "EST-001", 
                "SOF-101", 
                LocalDate.now()
            );

            registerInscripcionUseCase.execute(nuevaInscripcion);
            System.out.println("Total de inscripciones guardadas: " + inscripcionRepository.findAll().size());

        } catch (Exception e) {
            System.out.println("Error en Inscripciones: " + e.getMessage());
        }
        
        System.out.println("=== Ejecucion finalizada ===");
        System.out.println(" <<333 ");

        System.out.println("    ");

        // == Modulo calificaciones ==
        CalificacionRepository calificacionRepository = new InMemoryCalificacionRepository();
        RegisterCalificacionUseCase registerCalificacionUseCase = new RegisterCalificacionUseCase(
            calificacionRepository, estudianteRepository, repository
        );

        try {
            Calificacion nuevaCalificacion = new Calificacion(
                "CAL-001",
                "EST-001",
                "SOF-101",
                4.8, 
                LocalDate.now()
            );

            registerCalificacionUseCase.execute(nuevaCalificacion);
            System.out.println("Total de calificaciones guardadas: " + calificacionRepository.findAll().size());
        } catch (Exception e) {
            System.out.println("Error en Calificaciones: " + e.getMessage());
        }

        System.out.println("=== Ejecucion finalizada ===");
        System.out.println("   ");
        System.out.println("=== Completado ===");
    }
    
}