package org.acme.dtos;

import org.acme.entities.Professor;

public class ProfessorDTO {
    private Long id;
    private String nome;

    private String email;

    public ProfessorDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ProfessorDTO(Professor professor) {
        id = professor.getId();
        nome = professor.getNome();
        email = professor.getEmail();
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
