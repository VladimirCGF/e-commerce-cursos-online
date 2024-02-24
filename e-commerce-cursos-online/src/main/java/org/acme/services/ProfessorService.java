package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.ProfessorDTO;
import org.acme.entities.Professor;
import org.acme.repositories.ProfessorRepository;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProfessorService {

    @Inject
    ProfessorRepository professorRepository;

    public List<ProfessorDTO> findAll() {
        List<Professor> list = professorRepository.findAll().list();
        return list.stream().map(x -> new ProfessorDTO(x)).toList();
    }

    public ProfessorDTO findById(Long id) {
        Professor professor = professorRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
        return new ProfessorDTO(professor);
    }

    @Transactional
    public ProfessorDTO create(ProfessorDTO professorDTO) {
        Professor entity = new Professor();
        entity.setNome(professorDTO.getNome());
        professorRepository.persist(entity);
        return new ProfessorDTO(entity);
    }

    @Transactional
    public void update(Long id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
        professor.setNome(professorDTO.getNome());
        professorRepository.persist(professor);
    }

    @Transactional
    public void delete(Long id) {
        Professor professor = professorRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
        professorRepository.delete(professor);
    }

}
