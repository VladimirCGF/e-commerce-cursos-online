package org.acme.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "professor")
    private List<Cursos> cursos;

    public Professor() {
    }

    public Professor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Cursos> getCursos() {
        return cursos;
    }
}
