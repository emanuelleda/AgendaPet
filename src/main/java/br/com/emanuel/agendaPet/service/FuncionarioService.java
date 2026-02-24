package br.com.emanuel.agendaPet.service;

import br.com.emanuel.agendaPet.model.entity.Funcionario;
import br.com.emanuel.agendaPet.repostory.FuncionarioRepository;
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

    public Funcionario atualizarPorId(Long id, Funcionario funcionarioAtualizado) {
        return repository.findById(id)
                .map(funcionarioExistente -> {
                    return repository.save(funcionarioAtualizado);
                }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o id: " + id));
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
