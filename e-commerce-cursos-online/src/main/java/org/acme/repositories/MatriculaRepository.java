package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Cursos;
import org.acme.entities.Matricula;
import org.acme.entities.Usuario;

import java.util.List;

@ApplicationScoped
public class MatriculaRepository implements PanacheRepository<Matricula> {

    public List<Matricula> findByOrderId() {
        return findAll(Sort.by("id")).list();
    }

    public Matricula findByCurso(Cursos id) {
        return find("curso", id.getId()).firstResult();
    }
    public Matricula findByAluno(Usuario id) {
        return find("aluno", id.getId()).firstResult();
    }

}