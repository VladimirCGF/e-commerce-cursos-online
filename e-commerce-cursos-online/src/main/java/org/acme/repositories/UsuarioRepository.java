package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Usuario;

import java.util.List;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public Usuario findByNome(String nome) {
        return find("nome", nome).firstResult();
    }

    public List<Usuario> findAllOrderById() {
        return findAll(Sort.by("id")).list();
    }

    public Usuario findByEmail(String email) {
        return find("email", email).firstResult();
    }

}
