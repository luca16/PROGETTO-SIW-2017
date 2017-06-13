package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.spring.model.Quadro;

public interface QuadroRepository extends CrudRepository<Quadro, Long>{

	List<Quadro> findByAnno(Integer anno);
}
