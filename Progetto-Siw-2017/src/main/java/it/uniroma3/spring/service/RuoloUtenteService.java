package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.RuoloUtente;
import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.repository.RuoloUtenteRepository;


@Service
public class RuoloUtenteService  {
    @Autowired
    private RuoloUtenteRepository ruoloRepository;

   
    public void saveRole(Utente u,RuoloUtente r) {
        r.setUsername(u.getUsername());
        ruoloRepository.save(r);
    }
}
