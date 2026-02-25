package br.com.emanuel.agendaPet.repository;

import br.com.emanuel.agendaPet.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
