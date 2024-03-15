package org.acme.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cursos_id")
    @NotNull
    private Cursos curso;
    @Column(name = "data_matricula")
    @NotNull
    private LocalDate dataMatricula;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull
    private Usuario aluno;

    public Matricula() {
    }

    public Matricula(Long id, Cursos curso, LocalDate dataMatricula, Usuario aluno) {
        this.id = id;
        this.curso = curso;
        this.dataMatricula = dataMatricula;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos cursos) {
        this.curso = cursos;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }


}
