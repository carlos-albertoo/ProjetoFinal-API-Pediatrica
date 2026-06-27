package br.com.clinica.pediatrica.models.dtos;

public record ResumoDTO(
        long totalConsultas,
        long consultasAgendadas,
        long pediatrasDiferentes
) {}
