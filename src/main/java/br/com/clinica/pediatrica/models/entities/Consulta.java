package br.com.clinica.pediatrica.models.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;
    private String motivo;

    // Status do agendamento (ex: AGENDADA, REALIZADA, CANCELADA)
    private String status;

    // Relacionamento ManyToOne (Várias consultas para um paciente)
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // Relacionamento ManyToOne (Várias consultas para um pediatra)
    @ManyToOne
    @JoinColumn(name = "pediatra_id")
    private Pediatra pediatra;
}
