package org.acme.dtos;

import org.acme.entities.Professor;

public class ProfessorDTO {
    private Long id;
    private String nome;

    public ProfessorDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ProfessorDTO(Professor professor) {
        id = professor.getId();
        nome = professor.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
