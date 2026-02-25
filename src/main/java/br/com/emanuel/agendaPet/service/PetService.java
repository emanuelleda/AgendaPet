package br.com.emanuel.agendaPet.service;
import br.com.emanuel.agendaPet.model.entity.Pet;
import br.com.emanuel.agendaPet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository repository;

    public Pet cadastrar(Pet pet){
        return repository.save(pet);
    }

    public Optional<Pet> consultarPorId(Long id){
        return repository.findById(id);
    }

    public Pet atualizarPorId(Long id, Pet petAtualizado) {
        return repository.findById(id)
                .map(petExistente -> {
                    return repository.save(petAtualizado);
                }).orElseThrow(() -> new RuntimeException("Pet não encontrado com o id: " + id));
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
