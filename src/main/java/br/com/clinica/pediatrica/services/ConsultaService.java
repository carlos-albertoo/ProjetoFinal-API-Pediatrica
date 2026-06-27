package br.com.clinica.pediatrica.services;

import br.com.clinica.pediatrica.models.dtos.ConsultaFormDTO;
import br.com.clinica.pediatrica.models.entities.Consulta;
import br.com.clinica.pediatrica.repositories.ConsultaRepository;
import br.com.clinica.pediatrica.repositories.PacienteRepository;
import br.com.clinica.pediatrica.repositories.PediatraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final PediatraRepository pediatraRepository;

    // Construtor para injeção de dependências (O Spring cuida disso automaticamente)
    public ConsultaService(ConsultaRepository consultaRepository,
                           PacienteRepository pacienteRepository,
                           PediatraRepository pediatraRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.pediatraRepository = pediatraRepository;
    }

    @Transactional
    public Consulta agendar(ConsultaFormDTO dto) {
        // Regra 1: Valida duplicidade para o Pediatra (Evita choque de horários)
        if (consultaRepository.existsByPediatraIdAndDataHora(dto.pediatraId(), dto.dataHora())) {
            throw new RuntimeException("Conflito: Este pediatra já possui uma consulta neste exato horário.");
        }

        // Regra 2: Valida duplicidade para o Paciente
        if (consultaRepository.existsByPacienteIdAndDataHora(dto.pacienteId(), dto.dataHora())) {
            throw new RuntimeException("Conflito: Este paciente já possui uma consulta neste exato horário.");
        }

        // Cria a nova entidade Consulta e preenche com os dados do DTO
        Consulta novaConsulta = new Consulta();
        novaConsulta.setDataHora(dto.dataHora());
        novaConsulta.setMotivo(dto.motivo());
        novaConsulta.setStatus("AGENDADA");

        // Busca as entidades relacionadas no banco de dados e vincula à consulta
        novaConsulta.setPaciente(pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com o ID informado.")));

        novaConsulta.setPediatra(pediatraRepository.findById(dto.pediatraId())
                .orElseThrow(() -> new RuntimeException("Pediatra não encontrado com o ID informado.")));

        // Salva no banco de dados através do Repository
        return consultaRepository.save(novaConsulta);
    }

    public br.com.clinica.pediatrica.models.dtos.ResumoDTO obterResumo() {
        // Busca todos do banco
        var todasConsultas = consultaRepository.findAll();

        // 1. Total de consultas
        long total = todasConsultas.size();

        // 2. Quantidade de consultas agendadas (In-memory filter)
        long agendadas = todasConsultas.stream()
                .filter(c -> "AGENDADA".equals(c.getStatus()))
                .count();

        // 3. Quantidade de pediatras distintos (In-memory stream)
        long pediatrasDiferentes = todasConsultas.stream()
                .map(c -> c.getPediatra().getId())
                .distinct()
                .count();

        return new br.com.clinica.pediatrica.models.dtos.ResumoDTO(total, agendadas, pediatrasDiferentes);
    }
}
