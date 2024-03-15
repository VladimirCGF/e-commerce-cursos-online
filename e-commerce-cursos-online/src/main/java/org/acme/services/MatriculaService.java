package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.MatriculaDTO;
import org.acme.entities.Cursos;
import org.acme.entities.Matricula;
import org.acme.entities.Usuario;
import org.acme.repositories.CursosRepository;
import org.acme.repositories.MatriculaRepository;
import org.acme.repositories.UsuarioRepository;
import org.acme.services.exceptions.EntityValidationException;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;

@ApplicationScoped
public class MatriculaService {
    @Inject
    MatriculaRepository matriculaRepository;
    @Inject
    UsuarioRepository usuarioRepository;
    @Inject
    CursosRepository cursosRepository;

    public List<MatriculaDTO> findAll() {
        List<Matricula> result = matriculaRepository.findByOrderId();
        return result.stream().map(x -> new MatriculaDTO(x)).toList();
    }

    public MatriculaDTO findById(Long id) {
        Matricula matricula = matriculaRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
        return new MatriculaDTO(matricula);
    }

    @Transactional
    public MatriculaDTO create(MatriculaDTO matriculaDTO) throws EntityValidationException {
        Matricula matricula = new Matricula();
        copyDtoEntity(matriculaDTO, matricula);
        if (!matricula.getCurso().getMatriculas().isEmpty()) {
            if (!matricula.getAluno().getMatriculas().isEmpty()) {
                throw new EntityValidationException("Matricula ja existe");
            }
        }
        matriculaRepository.persist(matricula);
        return new MatriculaDTO(matricula);
    }

    @Transactional
    public void update(Long id, MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
        copyDtoEntity(matriculaDTO, matricula);
        matriculaRepository.persist(matricula);
    }

    @Transactional
    public void delete(Long id) {
        Matricula matricula = matriculaRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
        matriculaRepository.delete(matricula);
    }

    private void copyDtoEntity(MatriculaDTO matriculaDTO, Matricula entity) {
        Usuario aluno = usuarioRepository.findById(matriculaDTO.getAlunos().getId());
        entity.setAluno(aluno);
        Cursos cursos = cursosRepository.findById(matriculaDTO.getCursos().getId());
        entity.setCurso(cursos);
        entity.setDataMatricula(matriculaDTO.getDataMatricula());
    }

}
