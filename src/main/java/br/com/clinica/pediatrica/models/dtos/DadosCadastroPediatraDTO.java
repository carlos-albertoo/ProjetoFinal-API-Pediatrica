package br.com.clinica.pediatrica.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPediatraDTO(
        @NotBlank String nome,
        @NotBlank String crm,
        @NotBlank String especialidade
) {}
