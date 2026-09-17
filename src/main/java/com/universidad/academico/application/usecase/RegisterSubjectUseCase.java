package src.main.java.com.universidad.academico.application.usecase;

import src.main.java.com.universidad.academico.domain.model.Subject;
import src.main.java.com.universidad.academico.domain.repository.SubjectRepository;

public class RegisterSubjectUseCase {
    private final SubjectRepository subjectRepository;

    public RegisterSubjectUseCase(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public void execute(Subject subject){
        if(subjectRepository.findByCodigo(subject.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe la asignatura registrada con el codigo: " + subject.getCodigo());
        }

        subjectRepository.save(subject);
        System.out.println("Asignatura registrada en el sistema");
    }
}
