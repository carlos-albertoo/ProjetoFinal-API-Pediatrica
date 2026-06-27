package br.com.clinica.pediatrica.repositories;

import br.com.clinica.pediatrica.models.entities.Pediatra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PediatraRepository extends JpaRepository<Pediatra, Long> {
}
