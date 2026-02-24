package br.com.emanuel.agendaPet.controller;

import br.com.emanuel.agendaPet.model.entity.Pet;
import br.com.emanuel.agendaPet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService service;

    @PostMapping
    public ResponseEntity<Pet> cadastrar(@RequestBody Pet pet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(pet));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscar(@PathVariable Long id) {
        return service.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizar(@PathVariable Long id, @RequestBody Pet pet) {
        try {
            return ResponseEntity.ok(service.atualizarPorId(id, pet));
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
