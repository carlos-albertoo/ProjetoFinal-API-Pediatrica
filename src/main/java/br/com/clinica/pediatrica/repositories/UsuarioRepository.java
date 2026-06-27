package br.com.clinica.pediatrica.repositories;

import br.com.clinica.pediatrica.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método customizado que usaremos mais tarde para o Login (Spring Security)
    Optional<Usuario> findByEmail(String email);
}
