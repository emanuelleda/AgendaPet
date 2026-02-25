package br.com.emanuel.agendaPet.repository;

import br.com.emanuel.agendaPet.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
