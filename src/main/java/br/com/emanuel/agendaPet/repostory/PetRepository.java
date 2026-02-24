package br.com.emanuel.agendaPet.repostory;

import br.com.emanuel.agendaPet.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
