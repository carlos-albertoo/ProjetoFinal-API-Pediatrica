package br.com.clinica.pediatrica.services;

import br.com.clinica.pediatrica.models.dtos.DadosCadastroPediatraDTO;
import br.com.clinica.pediatrica.models.entities.Pediatra;
import br.com.clinica.pediatrica.repositories.PediatraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PediatraService {

    @Autowired
    private PediatraRepository repository;

    public void cadastrar(DadosCadastroPediatraDTO dados) {
        var pediatra = new Pediatra(dados);
        repository.save(pediatra);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pediatra não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}
