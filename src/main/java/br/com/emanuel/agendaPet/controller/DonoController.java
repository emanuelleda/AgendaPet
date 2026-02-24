package br.com.emanuel.agendaPet.controller;

import br.com.emanuel.agendaPet.model.entity.Dono;
import br.com.emanuel.agendaPet.service.DonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donos")
@RequiredArgsConstructor
public class DonoController {

    private final DonoService service;

    @PostMapping
    public ResponseEntity<Dono> cadastrar(@RequestBody Dono dono) {
        // O Service vai cuidar de salvar o Dono e o Pet (Cascade)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dono));
    }

    @GetMapping
    public ResponseEntity<List<Dono>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dono> buscarPorId(@PathVariable Long id) {
        return service.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}