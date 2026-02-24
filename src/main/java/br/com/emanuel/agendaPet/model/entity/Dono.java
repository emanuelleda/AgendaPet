package br.com.emanuel.agendaPet.model.entity;

import br.com.emanuel.agendaPet.model.vo.CPF;
import br.com.emanuel.agendaPet.model.vo.Email;
import br.com.emanuel.agendaPet.model.vo.Nome;
import br.com.emanuel.agendaPet.model.vo.Telefone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "dono")
@Table(name = "donos")
public class Dono extends Pessoa {

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    protected Dono() {
    }

    public Dono(Nome nome, CPF cpf, Email email, Telefone telefone, Pet pet) {
        super(nome, cpf, email, telefone);
        if (pet != null) {
            pet.setDono(this);
            this.pets.add(pet);
        }
    }

    public void adicionarPet(Pet pet) {
        if (pet != null) {
            pet.setDono(this);
            this.pets.add(pet);
        }
    }
}
