package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.ProfessorDTO;
import org.acme.entities.Professor;
import org.acme.repositories.ProfessorRepository;
import org.acme.services.exceptions.EntityValidationException;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ProfessorService {

    @Inject
    ProfessorRepository professorRepository;

    public List<ProfessorDTO> findAll() {
        List<Professor> list = professorRepository.findAllOrderById();
        return list.stream().map(x -> new ProfessorDTO(x)).toList();
    }

    public ProfessorDTO findById(Long id) {
        Professor professor = professorRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
        return new ProfessorDTO(professor);
    }

    @Transactional
    public ProfessorDTO create(ProfessorDTO professorDTO) throws EntityValidationException {
        Professor entity = new Professor();
        entity.setNome(professorDTO.getNome());
        Professor exist = professorRepository.findByNome(professorDTO.getNome());
        if (exist != null) {
            throw new EntityValidationException("Nome ja esta em uso");
        }
        professorRepository.persist(entity);
        return new ProfessorDTO(entity);
    }

    @Transactional
    public void update(Long id, ProfessorDTO professorDTO) throws EntityValidationException {
        Professor professor = professorRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
        Professor exist = professorRepository.findByNome(professorDTO.getNome());
        if (!Objects.equals(professorDTO.getNome(), professor.getNome())) {
            if (exist != null) {
                throw new EntityValidationException("Nome ja esta em uso");
            }
        }
        professor.setNome(professorDTO.getNome());
        professorRepository.persist(professor);
    }

    @Transactional
    public void delete(Long id) throws EntityValidationException {
        Professor professor = professorRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
        if (!professor.getCursos().isEmpty()) {
            throw new EntityValidationException("Falha de integridade referencial");
        }
        professorRepository.delete(professor);
    }

}
