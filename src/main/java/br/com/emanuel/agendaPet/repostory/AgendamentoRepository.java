package br.com.emanuel.agendaPet.repostory;

import br.com.emanuel.agendaPet.model.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
