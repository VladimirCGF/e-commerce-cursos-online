package org.acme.dtos;

import org.acme.entities.Matricula;

import java.time.LocalDate;

public class MatriculaDTO {
    private Long id;
    private CursosDTO cursos;
    private LocalDate dataMatricula;
    private AlunoDTO alunos;

    public MatriculaDTO(Long id, CursosDTO cursos, LocalDate dataMatricula, AlunoDTO alunosDto) {
        this.id = id;
        this.cursos = cursos;
        this.dataMatricula = dataMatricula;
        this.alunos = alunosDto;
    }

    public MatriculaDTO(Matricula matricula) {
        this.id = matricula.getId();
        this.cursos = new CursosDTO(matricula.getCursos());
        this.dataMatricula = matricula.getDataMatricula();
        this.alunos = new AlunoDTO(matricula.getAlunos());
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

    public AlunoDTO getAlunos() {
        return alunos;
    }

    public void setAlunos(AlunoDTO alunos) {
        this.alunos = alunos;
    }
}
