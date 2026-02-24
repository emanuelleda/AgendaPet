package br.com.emanuel.agendaPet.model.entity;

import br.com.emanuel.agendaPet.model.vo.CPF;
import br.com.emanuel.agendaPet.model.vo.Email;
import br.com.emanuel.agendaPet.model.vo.Nome;
import br.com.emanuel.agendaPet.model.vo.Telefone;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;

@MappedSuperclass
public abstract class Pessoa {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    @Valid
    private Nome nome;

    @Embedded
    @Valid
    @AttributeOverride(name = "numero", column = @Column(name = "cpf_numero")) // Sobrescreve o nome da coluna
    private CPF cpf;

    @Getter
    @Embedded
    @Valid
    private Email email;

    @Getter
    @Embedded
    @Valid
    @AttributeOverride(name = "numero", column = @Column(name = "telefone_numero")) // Sobrescreve o nome da coluna
    private Telefone telefone;

    protected Pessoa(){}

    protected Pessoa(Nome nome, CPF cpf, Email email, Telefone telefone){
        this.nome=nome;
        this.cpf=cpf;
        this.email=email;
        this.telefone=telefone;
    }


    public String getContactoPrincipal() {
        return nome.toString() + " - " + email.toString();
    }
}
