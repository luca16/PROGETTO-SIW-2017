package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.model.RuoloUtente;
import it.uniroma3.spring.model.Utente;

import it.uniroma3.spring.service.RuoloUtenteService;
import it.uniroma3.spring.service.UtenteService;



@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private RuoloUtenteService ruoloUtenteService;

	 @RequestMapping(value = "/registrazione", method = RequestMethod.GET)
	    public String registrazioneform(Utente utente) {
	        return "registrazioneForm";
	    }

	 
	    @RequestMapping(value = "/registrazione", method = RequestMethod.POST)
	    public String createNewUser(@Valid @ModelAttribute Utente utente, BindingResult bindingResult,Model model) {
	       
	    	String username = utente.getUsername();
	       Utente userAlredyExist = utenteService.findUserByUsername(username);

	        if (userAlredyExist != null)
	            bindingResult.rejectValue("username", "label.registrazione", "C'è già un utente con questo username");

	        if (bindingResult.hasErrors()) {
	            	return "registrazioneForm";
	            	
	        } else {
	        	model.addAttribute(utente);
	        	utenteService.saveUser(utente);
	           RuoloUtente ruolo= new RuoloUtente("USER");
	           model.addAttribute(ruolo);
	            ruoloUtenteService.saveRole(utente, ruolo);

	        }
	        return "/resultRegistrazione";
	    }
}
