package it.uniroma3.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.spring.model.Autore;


public interface AutoreRepository  extends JpaRepository<Autore, Long>{
	
	
}
