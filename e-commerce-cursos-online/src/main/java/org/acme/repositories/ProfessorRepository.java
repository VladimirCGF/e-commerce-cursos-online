package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Aluno;
import org.acme.entities.Professor;

import java.util.List;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {

    public Professor findByNome(String nome){
        return find("nome", nome).firstResult();
    }
    public List<Professor> findAllOrderById() {
        return findAll(Sort.by("id")).list();
    }
    public Professor findByEmail(String email) {
        return find("email", email).firstResult();
    }

}
