package br.com.emanuel.agendaPet.model.entity;

import br.com.emanuel.agendaPet.model.enums.Especialidades;
import br.com.emanuel.agendaPet.model.vo.CPF;
import br.com.emanuel.agendaPet.model.vo.Email;
import br.com.emanuel.agendaPet.model.vo.Nome;
import br.com.emanuel.agendaPet.model.vo.Telefone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "funcionario")
@Table(name = "funcionarios")
public class Funcionario extends Pessoa{

    @Setter
    @NotNull
    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    @OneToMany(mappedBy = "funcionario")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Funcionario(){

    }

    public Funcionario(Nome nome, CPF cpf, Email email, Telefone telefone, Especialidades especialidade){
        super(nome,cpf,email,telefone);
        setEspecialidade(especialidade);
    }

}
