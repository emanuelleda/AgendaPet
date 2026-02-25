package br.com.emanuel.agendaPet.controller;

import br.com.emanuel.agendaPet.model.entity.Funcionario;
import br.com.emanuel.agendaPet.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Para não ter problemas com o Front-end depois
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
        return service.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(service.atualizar(id, funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
