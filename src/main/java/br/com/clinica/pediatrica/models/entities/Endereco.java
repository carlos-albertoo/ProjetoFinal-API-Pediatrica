package br.com.clinica.pediatrica.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;

    // Relacionamento OneToOne com o Usuário
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
