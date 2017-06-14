package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class GalleriaController {
	
	@GetMapping("/visitaGalleria")
	public String showFormGalleria(){
		return "percorsiGalleria";
	}
	
	@GetMapping("gestisciElementi")
	public String showFormGestioneGalleria(){
		return "gestioneElementi";
	}
}
