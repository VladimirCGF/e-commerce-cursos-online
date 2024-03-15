package org.acme.dtos;

import org.acme.entities.Usuario;

import java.time.LocalDate;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private LocalDate data;
    private String email;
    private String telefone;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, LocalDate data, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.email = email;
        this.telefone = telefone;
    }

    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        data = usuario.getData();
        email = usuario.getEmail();
        telefone = usuario.getTelefone();
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

    public void setData(LocalDate data) {
        this.data = data;
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


}
