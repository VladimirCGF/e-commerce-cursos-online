package org.acme.dtos;

import org.acme.entities.Cursos;

import java.math.BigDecimal;

public class CursosDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private BigDecimal preco;
    private UsuarioDTO professor;

    public CursosDTO(Long id, String nome, String descricao, Integer cargaHoraria, BigDecimal preco, UsuarioDTO professorDto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.preco = preco;
        this.professor = professorDto;
    }

    public CursosDTO(Cursos cursos) {
        id = cursos.getId();
        nome = cursos.getNome();
        descricao = cursos.getDescricao();
        cargaHoraria = cursos.getCargaHoraria();
        preco = cursos.getPreco();
        professor = new UsuarioDTO(cursos.getProfessor());
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public UsuarioDTO getProfessor() {
        return professor;
    }

    public void setProfessor(UsuarioDTO professor) {
        this.professor = professor;
    }
}
