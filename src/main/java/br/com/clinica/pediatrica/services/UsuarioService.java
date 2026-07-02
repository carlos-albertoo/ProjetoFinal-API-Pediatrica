package br.com.clinica.pediatrica.services;

import br.com.clinica.pediatrica.models.dtos.DadosCadastroUsuarioDTO;
import br.com.clinica.pediatrica.models.entities.Usuario;
import br.com.clinica.pediatrica.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void cadastrar(DadosCadastroUsuarioDTO dados) {
        var usuarioExistente = repository.findByEmail(dados.email());
        if (usuarioExistente != null && !usuarioExistente.toString().equals("Optional.empty")) {
            throw new IllegalStateException("Email já cadastrado no sistema.");
        }

        // Regra de Negócio: Criptografa a senha antes de salvar
        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(dados.nome(), dados.email(), senhaCriptografada);

        repository.save(usuario);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}
