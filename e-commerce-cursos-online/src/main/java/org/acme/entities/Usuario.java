package org.acme.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @NotNull
    private LocalDate data;
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String telefone;
    @OneToMany(mappedBy = "professor")
    private List<Cursos> cursos;
    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;
    public Usuario() {
    }

    public Usuario(Long id, String nome, LocalDate data, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.email = email;
        this.telefone = telefone;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate dataNascimento) {
        this.data = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Cursos> getCursos() {
        return cursos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
}
