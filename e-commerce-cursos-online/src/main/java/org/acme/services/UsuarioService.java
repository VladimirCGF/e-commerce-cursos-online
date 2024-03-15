package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dtos.UsuarioDTO;
import org.acme.entities.Usuario;
import org.acme.repositories.UsuarioRepository;
import org.acme.services.exceptions.EntityValidationException;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        List<Usuario> list = usuarioRepository.findAllOrderById();
        return list.stream().map(x -> new UsuarioDTO(x)).toList();
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public UsuarioDTO create(UsuarioDTO usuarioDTO) throws EntityValidationException {
        Usuario entity = new Usuario();
        entity.setNome(usuarioDTO.getNome());
        entity.setData(usuarioDTO.getData());
        entity.setEmail(usuarioDTO.getEmail());
        entity.setTelefone(usuarioDTO.getTelefone());
        Usuario existEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        if (existEmail != null) {
            throw new EntityValidationException("Email ja esta em uso");
        }
        Usuario exist = usuarioRepository.findByNome(usuarioDTO.getNome());
        if (exist != null) {
            throw new EntityValidationException("Nome ja esta em uso");
        }
        usuarioRepository.persist(entity);
        return new UsuarioDTO(entity);
    }

    @Transactional
    public void update(Long id, UsuarioDTO usuarioDTO) throws EntityValidationException {
        Usuario usuario = usuarioRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
        Usuario exist = usuarioRepository.findByNome(usuarioDTO.getNome());
        if (!Objects.equals(usuarioDTO.getNome(), usuario.getNome())) {
            if (exist != null) {
                throw new EntityValidationException("Nome ja esta em uso");
            }
        }
        usuario.setNome(usuarioDTO.getNome());
        usuario.setData(usuarioDTO.getData());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuarioRepository.persist(usuario);
    }

    @Transactional
    public void delete(Long id) throws EntityValidationException {
        Usuario usuario = usuarioRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        if (!usuario.getCursos().isEmpty()) {
            throw new EntityValidationException("Falha de integridade referencial");
        }
        usuarioRepository.delete(usuario);
    }

}
