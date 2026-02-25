package br.com.emanuel.agendaPet.repository;

import br.com.emanuel.agendaPet.model.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
