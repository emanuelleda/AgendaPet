package br.com.emanuel.agendaPet.repository;

import br.com.emanuel.agendaPet.model.entity.Dono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonoRepository extends JpaRepository<Dono,Long> {
}
