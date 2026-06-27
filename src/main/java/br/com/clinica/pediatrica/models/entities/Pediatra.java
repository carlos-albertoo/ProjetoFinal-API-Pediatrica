package br.com.clinica.pediatrica.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pediatras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pediatra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String crm;

    private String especialidade; // Ex: Geral, Neurologia, etc.
}
