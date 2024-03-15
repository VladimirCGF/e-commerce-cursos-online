package org.acme.dtos;

import org.acme.entities.Matricula;

import java.time.LocalDate;

public class MatriculaDTO {
    private Long id;
    private CursosDTO cursos;
    private LocalDate dataMatricula;
    private UsuarioDTO aluno;

    public MatriculaDTO(Long id, CursosDTO cursos, LocalDate dataMatricula, UsuarioDTO aluno) {
        this.id = id;
        this.cursos = cursos;
        this.dataMatricula = dataMatricula;
        this.aluno = aluno;
    }

    public MatriculaDTO(Matricula matricula) {
        this.id = matricula.getId();
        this.cursos = new CursosDTO(matricula.getCurso());
        this.dataMatricula = matricula.getDataMatricula();
        this.aluno = new UsuarioDTO(matricula.getAluno());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursosDTO getCursos() {
        return cursos;
    }

    public void setCursos(CursosDTO cursos) {
        this.cursos = cursos;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public UsuarioDTO getAlunos() {
        return aluno;
    }

    public void setAlunos(UsuarioDTO aluno) {
        this.aluno = aluno;
    }
}
