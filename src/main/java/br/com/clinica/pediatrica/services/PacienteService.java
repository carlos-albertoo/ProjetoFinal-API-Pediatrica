package br.com.clinica.pediatrica.services;

import br.com.clinica.pediatrica.models.dtos.DadosCadastroPacienteDTO;
import br.com.clinica.pediatrica.models.entities.Paciente;
import br.com.clinica.pediatrica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public void cadastrar(DadosCadastroPacienteDTO dados) {
        var paciente = new Paciente(dados);
        repository.save(paciente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}
