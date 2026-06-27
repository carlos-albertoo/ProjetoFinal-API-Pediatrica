package br.com.clinica.pediatrica.repositories;

import br.com.clinica.pediatrica.models.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // Verifica se o Pediatra já tem consulta nesse exato horário
    @Query("SELECT COUNT(c) > 0 FROM Consulta c WHERE c.pediatra.id = :pediatraId AND c.dataHora = :dataHora")
    boolean existsByPediatraIdAndDataHora(Long pediatraId, LocalDateTime dataHora);

    // Verifica se o Paciente já tem consulta nesse exato horário
    @Query("SELECT COUNT(c) > 0 FROM Consulta c WHERE c.paciente.id = :pacienteId AND c.dataHora = :dataHora")
    boolean existsByPacienteIdAndDataHora(Long pacienteId, LocalDateTime dataHora);
}
