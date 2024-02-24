package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.CursosDTO;
import org.acme.entities.Cursos;
import org.acme.entities.Professor;
import org.acme.repositories.CursosRepository;
import org.acme.repositories.ProfessorRepository;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CursosService {

    @Inject
    CursosRepository cursosRepository;

    @Inject
    ProfessorRepository professorRepository;

    public List<CursosDTO> findAll() {
        List<Cursos> list = cursosRepository.findAll().list();
        return list.stream().map(x -> new CursosDTO(x)).toList();
    }

    public CursosDTO findById(Long id) {
        Cursos curso = cursosRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
        return new CursosDTO(curso);
    }

    @Transactional
    public CursosDTO create(CursosDTO cursosDTO) {
        Cursos cursos = new Cursos();
        copyDtoEntity(cursosDTO, cursos);
        cursosRepository.persist(cursos);
        return new CursosDTO(cursos);
    }

    @Transactional
    public void update(Long id, CursosDTO cursosDTO) {
        Cursos curso = cursosRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
        copyDtoEntity(cursosDTO, curso);
        cursosRepository.persist(curso);
    }

    @Transactional
    public void delete(Long id){
        Cursos curso = cursosRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
        cursosRepository.delete(curso);
    }

    private void copyDtoEntity(CursosDTO cursosDTO, Cursos entity) {
        entity.setNome(cursosDTO.getNome());
        entity.setDescricao(cursosDTO.getDescricao());
        entity.setCargaHoraria(cursosDTO.getCargaHoraria());
        entity.setPreco(cursosDTO.getPreco());
        Professor professor = professorRepository.findById(cursosDTO.getProfessor().getId());
        entity.setProfessor(professor);
    }


}
