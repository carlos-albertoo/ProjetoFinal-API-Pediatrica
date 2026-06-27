package br.com.clinica.pediatrica.models.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record ConsultaFormDTO(
        @NotNull(message = "A data e hora são obrigatórias.")
        @FutureOrPresent(message = "A consulta deve ser agendada para o presente ou futuro.")
        LocalDateTime dataHora,

        @NotBlank(message = "O motivo da consulta não pode estar em branco.")
        String motivo,

        @NotNull(message = "O ID do paciente é obrigatório.")
        Long pacienteId,

        @NotNull(message = "O ID do pediatra é obrigatório.")
        Long pediatraId
) {}
