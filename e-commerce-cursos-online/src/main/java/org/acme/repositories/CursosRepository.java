package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Cursos;

@ApplicationScoped
public class CursosRepository implements PanacheRepository<Cursos> {
}
