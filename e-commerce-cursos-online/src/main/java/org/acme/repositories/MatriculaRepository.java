package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Matricula;

@ApplicationScoped
public class MatriculaRepository implements PanacheRepository<Matricula> {

}