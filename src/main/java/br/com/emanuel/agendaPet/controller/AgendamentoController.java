package br.com.emanuel.agendaPet.controller;

import br.com.emanuel.agendaPet.model.entity.Agendamento;
import br.com.emanuel.agendaPet.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    @PostMapping
    public ResponseEntity<Agendamento> agendar(@RequestBody Agendamento agendamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agendar(agendamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscar(@PathVariable Long id) {
        return service.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        try {
            return ResponseEntity.ok(service.atualizarPorId(id, agendamento));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
