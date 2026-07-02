package br.com.clinica.pediatrica.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DadosCadastroPacienteDTO(
        @NotBlank String nome,
        @NotNull LocalDate dataNascimento,
        @NotNull Long responsavelId
) {}
