package br.com.emanuel.agendaPet.service;

import br.com.emanuel.agendaPet.model.entity.Dono;

import br.com.emanuel.agendaPet.repository.DonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonoService {

    private final DonoRepository repository;


    @Transactional
    public Dono cadastrar(Dono dono) {
        if (dono.getPets() != null && !dono.getPets().isEmpty()) {
            dono.getPets().forEach(pet -> pet.setDono(dono));
        }
        return repository.save(dono);
    }

    public List<Dono> listarTodos() {
        return repository.findAll();
    }

    public Optional<Dono> consultarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
