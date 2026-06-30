package br.com.clinica.pediatrica.controllers;

import br.com.clinica.pediatrica.models.dtos.ConsultaFormDTO;
import br.com.clinica.pediatrica.models.entities.Consulta;
import br.com.clinica.pediatrica.services.ConsultaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement; // <-- NOVO IMPORT
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key") // <-- OBRIGA O SWAGGER A ENVIAR O TOKEN
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<Consulta> agendar(@RequestBody @Valid ConsultaFormDTO dto) {
        Consulta consultaSalva = consultaService.agendar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaSalva);
    }

    @GetMapping("/resumo")
    public ResponseEntity<br.com.clinica.pediatrica.models.dtos.ResumoDTO> obterResumo() {
        return ResponseEntity.ok(consultaService.obterResumo());
    }
}
