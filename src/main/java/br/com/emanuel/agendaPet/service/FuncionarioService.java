package br.com.emanuel.agendaPet.service;

import br.com.emanuel.agendaPet.model.entity.Funcionario;
import br.com.emanuel.agendaPet.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public Funcionario cadastrar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Optional<Funcionario> consultarPorId(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Funcionario atualizar(Long id, Funcionario dadosAtualizados) {
        return repository.findById(id).map(funcionario -> {
            dadosAtualizados.setId(id);
            return repository.save(dadosAtualizados);
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
