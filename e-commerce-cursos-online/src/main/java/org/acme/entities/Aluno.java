package org.acme.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa {
    private Cargo cargo;
    @OneToMany(mappedBy = "alunos")
    private List<Matricula> matriculas;

    public Aluno() {
        super();
    }

    public Aluno(Long id, String nome, Integer idade, String email, String telefone, Cargo cargo) {
        super(id, nome, idade, email, telefone);
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
}
