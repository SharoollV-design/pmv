package main.java.com.universidad.academico.infrastructure.ui;

import main.java.com.universidad.academico.application.usecase.RegisterProfesorUseCase;
import main.java.com.universidad.academico.application.usecase.RegisterSubjectUseCase;
import main.java.com.universidad.academico.domain.model.Profesor;
import main.java.com.universidad.academico.domain.model.Subject;
import main.java.com.universidad.academico.domain.repository.ProfesorRepository;
import main.java.com.universidad.academico.domain.repository.SubjectRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemoryProfesorRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemorySubjectRepository;

public class Main {
    public static void main(String[] args) {
        // == Modulo asignaturas === //
        SubjectRepository repository = new InMemorySubjectRepository();


        RegisterSubjectUseCase registerUseCase = new RegisterSubjectUseCase(repository);

        try {
            Subject nuevaAsignatura = new Subject(
                "SIS-101", 
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

        System.out.println("*******");

        // == Modulo profesores == //

        ProfesorRepository profesorRepository = new InMemoryProfesorRepository();
        RegisterProfesorUseCase registerProfesorUseCase = new RegisterProfesorUseCase(profesorRepository);

        try {
            Profesor nuevoProfesor = new Profesor(
                "PROF-001",
                "Carlos",
                "Pérez",
                "carlos.perez@universidad.com",
                "Ingeniería de Sistemas"
            );

            registerProfesorUseCase.execute(nuevoProfesor);
            System.out.println("Total de profesores guardados: " + profesorRepository.findAll().size());

        } catch (Exception e) {
            System.out.println("Error en Profesores: " + e.getMessage());
        }
        
        System.out.println("=== EJECUCIÓN FINALIZADA EXITOSAMENTE ===");
    }
}
