package br.com.clinica.pediatrica.controllers;

import br.com.clinica.pediatrica.models.dtos.DadosCadastroUsuarioDTO;
import br.com.clinica.pediatrica.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroUsuarioDTO dados) {
        service.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Retorna 201 Created
    }
}