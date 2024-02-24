package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.MatriculaDTO;
import org.acme.entities.Aluno;
import org.acme.entities.Cursos;
import org.acme.entities.Matricula;
import org.acme.repositories.AlunoRepository;
import org.acme.repositories.CursosRepository;
import org.acme.repositories.MatriculaRepository;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MatriculaService {
    @Inject
    MatriculaRepository matriculaRepository;
    @Inject
    AlunoRepository alunoRepository;
    @Inject
    CursosRepository cursosRepository;

    public List<MatriculaDTO> findAll() {
        List<Matricula> result = matriculaRepository.findAll().list();
        return result.stream().map(x -> new MatriculaDTO(x)).toList();
    }

    public MatriculaDTO findById(Long id) {
        Matricula matricula = matriculaRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
        return new MatriculaDTO(matricula);
    }

    @Transactional
    public MatriculaDTO create(MatriculaDTO matriculaDTO) {
        Matricula matricula = new Matricula();
        copyDtoEntity(matriculaDTO, matricula);
        matriculaRepository.persist(matricula);
        return new MatriculaDTO(matricula);
    }

    @Transactional
    public void update(Long id, MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
        copyDtoEntity(matriculaDTO, matricula);
        matriculaRepository.persist(matricula);
    }

    @Transactional
    public void delete(Long id){
        Matricula matricula = matriculaRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
        matriculaRepository.delete(matricula);
    }

    private void copyDtoEntity(MatriculaDTO matriculaDTO, Matricula entity) {
        Aluno aluno = alunoRepository.findById(matriculaDTO.getAlunos().getId());
        entity.setAlunos(aluno);
        Cursos cursos = cursosRepository.findById(matriculaDTO.getCursos().getId());
        entity.setCursos(cursos);
        entity.setDataMatricula(matriculaDTO.getDataMatricula());
    }

}
