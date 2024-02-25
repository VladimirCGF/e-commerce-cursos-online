package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Cursos;

import java.util.List;

@ApplicationScoped
public class CursosRepository implements PanacheRepository<Cursos> {

    public Cursos findByNome(String nome) {
        return find("nome", nome).firstResult();
    }

    public List<Cursos> findByOrderId(){
        return findAll(Sort.by("id")).list();
    }
}
