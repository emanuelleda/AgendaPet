package br.com.emanuel.agendaPet.model.entity;

import br.com.emanuel.agendaPet.model.enums.Portes;
import br.com.emanuel.agendaPet.model.vo.Nome;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor // OBRIGATÓRIO para o Jackson
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dono_id",nullable = false)
    @NotNull(message = "O dono é obrigatório.")
    private Dono dono;

    @Embedded
    @Valid
    @NotNull
    private Nome nome;

    @Min(0)
    @Max(30)
    private Short idade;

    private String raca;

    @Enumerated(EnumType.STRING)
    private Portes porte;

    public Pet(Nome nome, short idade, String raca, Portes porte, Dono dono){
        this.nome=nome;
        this.idade=idade;
        this.raca=raca;
        this.porte=porte;
        setDono(dono);
    }

    public short getIdade() {
        return idade;
    }

    public void setDono(Dono dono){
        if(!(dono ==null)){
            this.dono=dono;
        }
    }
}
