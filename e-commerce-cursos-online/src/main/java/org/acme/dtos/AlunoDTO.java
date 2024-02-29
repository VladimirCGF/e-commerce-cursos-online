package org.acme.dtos;

import org.acme.entities.Aluno;
import org.acme.entities.Cargo;

public class AlunoDTO  extends PessoaDTO{
    private Cargo cargo;

    public AlunoDTO() {
        super();
    }

    public AlunoDTO(Long id, String nome, Integer idade, String email, String telefone, Cargo cargo) {
        super(id, nome, idade, email, telefone);
        this.cargo = cargo;
    }

    public AlunoDTO(Aluno aluno) {
        super(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getEmail(), aluno.getTelefone());
        cargo = aluno.getCargo();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
