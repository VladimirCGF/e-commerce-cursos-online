package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Aluno;

import java.util.List;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {
    public Aluno findByEmail(String email) {
        return find("email", email).firstResult();
    }
    public List<Aluno> findAllOrderById() {
        return findAll(Sort.by("id")).list();
    }


}
