package br.com.clinica.pediatrica.controllers;

import br.com.clinica.pediatrica.models.dtos.DadosCadastroPacienteDTO;
import br.com.clinica.pediatrica.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroPacienteDTO dados) {
        service.cadastrar(dados); // O Service assume a responsabilidade
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
