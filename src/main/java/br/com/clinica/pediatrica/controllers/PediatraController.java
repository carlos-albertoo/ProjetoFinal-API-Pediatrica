package br.com.clinica.pediatrica.controllers;

import br.com.clinica.pediatrica.models.dtos.DadosCadastroPediatraDTO;
import br.com.clinica.pediatrica.models.entities.Pediatra;
import br.com.clinica.pediatrica.repositories.PediatraRepository;
import br.com.clinica.pediatrica.services.PediatraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pediatras")
public class PediatraController {

    @Autowired
    private PediatraService service;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroPediatraDTO dados) {
        service.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
