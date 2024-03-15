package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.CursosDTO;
import org.acme.entities.Cursos;
import org.acme.entities.Usuario;
import org.acme.repositories.CursosRepository;
import org.acme.repositories.UsuarioRepository;
import org.acme.services.exceptions.EntityValidationException;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;

@ApplicationScoped
public class CursosService {

    @Inject
    CursosRepository cursosRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    public List<CursosDTO> findAll() {
        List<Cursos> list = cursosRepository.findByOrderId();
        return list.stream().map(x -> new CursosDTO(x)).toList();
    }

    public CursosDTO findById(Long id) {
        Cursos curso = cursosRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
        return new CursosDTO(curso);
    }

    @Transactional
    public CursosDTO create(CursosDTO cursosDTO) throws EntityValidationException {
        Cursos cursos = new Cursos();
        copyDtoEntity(cursosDTO, cursos);
        Cursos exist = cursosRepository.findByNome(cursos.getNome());
        if (exist != null) {
            throw new EntityValidationException("Nome ja está em uso");
        }
        cursosRepository.persist(cursos);
        return new CursosDTO(cursos);
    }

    @Transactional
    public void update(Long id, CursosDTO cursosDTO) throws EntityValidationException {
        Cursos curso = cursosRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
        Cursos exist = cursosRepository.findByNome(curso.getNome());
        if (exist != null) {
            throw new EntityValidationException("Nome ja está em uso");
        }
        copyDtoEntity(cursosDTO, curso);
        cursosRepository.persist(curso);
    }

    @Transactional
    public void delete(Long id) throws EntityValidationException {
        Cursos curso = cursosRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
        if (!curso.getMatriculas().isEmpty()) {
            throw new EntityValidationException("Falha de integridade referencial");
        }
        cursosRepository.delete(curso);
    }

    private void copyDtoEntity(CursosDTO cursosDTO, Cursos entity) {
        entity.setNome(cursosDTO.getNome());
        entity.setDescricao(cursosDTO.getDescricao());
        entity.setCargaHoraria(cursosDTO.getCargaHoraria());
        entity.setPreco(cursosDTO.getPreco());
        Usuario professor = usuarioRepository.findById(cursosDTO.getProfessor().getId());
        entity.setProfessor(professor);
    }


}
