package br.com.emanuel.agendaPet.model.entity;

import br.com.emanuel.agendaPet.model.enums.Servicos;
import br.com.emanuel.agendaPet.model.enums.StatusAgendamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

@Entity(name = "agendamento")
@Table(name = "agendamentos")
public class Agendamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "funcionario_id")
    private Long id;

    @ManyToOne
    @NotNull
    private Funcionario funcionario;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Future(message = "O agendamento deve ser em uma data futura;")
    private LocalDateTime horaAgendamento;

    @Enumerated(EnumType.STRING)
    private Servicos servico;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusAgendamento statusAgendamento;

    public Agendamento(){

    }

    public Agendamento(Funcionario funcionario, Pet pet, LocalDateTime horaAgendamento, Servicos servico) {
        this.funcionario = funcionario;
        this.pet = pet;
        this.horaAgendamento = horaAgendamento;
        this.servico = servico;
        this.statusAgendamento = StatusAgendamento.AGENDADO; // Inicia sempre como agendado
    }

}
