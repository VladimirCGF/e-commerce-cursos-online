package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Professor;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {
}
