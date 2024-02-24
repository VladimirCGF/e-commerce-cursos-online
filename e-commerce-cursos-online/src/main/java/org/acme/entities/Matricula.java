package org.acme.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private Cursos cursos;
    @Column(name = "data_matricula")
    private LocalDate dataMatricula;
    @ManyToOne
    @JoinColumn(name = "alunos_id")
    private Aluno alunos;

    public Matricula() {
    }

    public Matricula(Long id, Cursos cursos, LocalDate dataMatricula, Aluno aluno) {
        this.id = id;
        this.cursos = cursos;
        this.dataMatricula = dataMatricula;
        this.alunos = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Aluno getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno alunos) {
        this.alunos = alunos;
    }


}
