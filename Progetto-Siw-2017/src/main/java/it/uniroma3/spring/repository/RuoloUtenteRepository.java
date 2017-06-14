package it.uniroma3.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.spring.model.RuoloUtente;

import java.util.List;

@Repository
public interface RuoloUtenteRepository extends JpaRepository<RuoloUtente, Integer> {
    List<String> findRoleByUsername(Long username);
}
