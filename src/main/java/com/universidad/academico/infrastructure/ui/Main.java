package main.java.com.universidad.academico.infrastructure.ui;

import main.java.com.universidad.academico.application.usecase.RegisterSubjectUseCase;
import main.java.com.universidad.academico.domain.model.Subject;
import main.java.com.universidad.academico.domain.repository.SubjectRepository;
import main.java.com.universidad.academico.infrastructure.persistence.InMemorySubjectRepository;

public class Main {
    public static void main(String[] args) {
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
    }
}
