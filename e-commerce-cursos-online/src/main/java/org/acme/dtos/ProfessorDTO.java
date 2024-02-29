package org.acme.dtos;

import org.acme.entities.Aluno;
import org.acme.entities.Cargo;
import org.acme.entities.Professor;

public class ProfessorDTO extends PessoaDTO{
    private Cargo cargo;

    public ProfessorDTO() {
        super();
    }

    public ProfessorDTO(Long id, String nome, Integer idade, String email, String telefone, Cargo cargo) {
        super(id, nome, idade, email, telefone);
        this.cargo = cargo;
    }

    public ProfessorDTO(Professor professor) {
        super(professor.getId(), professor.getNome(), professor.getIdade(), professor.getEmail(), professor.getTelefone());
        cargo = professor.getCargo();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
