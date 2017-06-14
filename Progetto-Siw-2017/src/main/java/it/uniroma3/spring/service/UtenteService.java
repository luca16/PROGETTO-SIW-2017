package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.repository.UtenteRepository;


@Service
public class UtenteService  {
    
	@Autowired
    private UtenteRepository utenteRepository;


    
    public Utente findUserByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

   
    public void saveUser(Utente utente) {
        String password = utente.getPassword();

        utente.setPassword(password);
        utente.setEnabled(true);

        utenteRepository.save(utente);
    }
}
