package br.com.clinica.pediatrica.models.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;

    // Relacionamento ManyToOne (Muitos pacientes para um responsável)
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Usuario responsavel;


    public Paciente(br.com.clinica.pediatrica.models.dtos.DadosCadastroPacienteDTO dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();

        // Cria uma referência do usuário apenas com o ID para salvar a chave estrangeira
        Usuario responsavelRef = new Usuario();
        responsavelRef.setId(dados.responsavelId());
        this.responsavel = responsavelRef;
    }
}