package br.com.emanuel.agendaPet.service;

import br.com.emanuel.agendaPet.model.entity.Agendamento;
import br.com.emanuel.agendaPet.repostory.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

     private final AgendamentoRepository repository;

    public Agendamento agendar(Agendamento agendamento){
        return repository.save(agendamento);
    }

    public Optional<Agendamento> consultarPorId(Long id){
        return repository.findById(id);
    }

    public Agendamento atualizarPorId(Long id, Agendamento agendamentoAtualizado) {
        return repository.findById(id)
                .map(agendamentoExistente -> {
                    return repository.save(agendamentoAtualizado);
                }).orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o id: " + id));
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
