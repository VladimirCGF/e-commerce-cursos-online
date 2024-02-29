package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.AlunoDTO;
import org.acme.entities.Aluno;
import org.acme.entities.Professor;
import org.acme.repositories.AlunoRepository;
import org.acme.repositories.ProfessorRepository;
import org.acme.services.exceptions.EntityValidationException;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;

@ApplicationScoped
public class AlunoService {
    @Inject
    AlunoRepository alunoRepository;

    @Inject
    ProfessorRepository professorRepository;

    public List<AlunoDTO> findAll() {
        List<Aluno> result = alunoRepository.findAllOrderById();
        return result.stream().map(x -> new AlunoDTO(x)).toList();
    }

    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        return new AlunoDTO(aluno);
    }

    @Transactional
    public AlunoDTO create(AlunoDTO alunoDTO) throws EntityValidationException {
        Aluno aluno = new Aluno();
        copyDtoEntity(alunoDTO, aluno);
        Aluno exist = alunoRepository.findByEmail(aluno.getEmail());
        Professor existProfessor = professorRepository.findByEmail(alunoDTO.getEmail());
        if (exist != null || existProfessor != null) {
            throw new EntityValidationException("Email em uso");
        }
        alunoRepository.persist(aluno);
        return new AlunoDTO(aluno);
    }

    @Transactional
    public void update(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        aluno.setNome(alunoDTO.getNome());
        aluno.setTelefone(alunoDTO.getTelefone());
        alunoRepository.persist(aluno);
    }

    @Transactional
    public void delete(Long id) throws EntityValidationException {
        Aluno aluno = alunoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        if (!aluno.getMatriculas().isEmpty()) {
            throw new EntityValidationException("Falha de integridade referencial");
        }
        alunoRepository.delete(aluno);
    }

    private void copyDtoEntity(AlunoDTO alunoDTO, Aluno entity) {
        entity.setNome(alunoDTO.getNome());
        entity.setEmail(alunoDTO.getEmail());
        entity.setTelefone(alunoDTO.getTelefone());
    }
}
