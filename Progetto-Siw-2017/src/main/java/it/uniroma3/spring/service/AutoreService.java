package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Autore;

import it.uniroma3.spring.repository.AutoreRepository;


@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;
	
	public Iterable<Autore> findAll(){
		return this.autoreRepository.findAll();
	}
	
	@Transactional
	public void add(final Autore autore){
		this.autoreRepository.save(autore);
		}
	
	public Autore findbyId(Long id) {
		return this.autoreRepository.findOne(id);
	}
}
