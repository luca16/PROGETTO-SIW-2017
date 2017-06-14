
package it.uniroma3.spring.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;

@Controller
public class QuadroController {
	
	@Autowired
	private QuadroService quadroService;
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/nuovoQuadro")
	public String showForm(Quadro quadro,Model model){
		model.addAttribute("autori", autoreService.findAll());
		return "quadroForm";
	}

	
	@PostMapping("/nuovoQuadro")
	public String checkQaudroInfo(@Valid @ModelAttribute Quadro quadro,
			BindingResult bindingResult, Model model){
		
		if (bindingResult.hasErrors()) {
            return "quadroForm";
        }
        else {
        	model.addAttribute(quadro);
            quadroService.add(quadro); 
        }
        return "resultQuadro";
		
	}
	
	
	@GetMapping("/quadriPerAnno")
	public String getQuadriPerAnno(Model model){
		
		model.addAttribute("quadri", this.quadroService.findAll());
		return "quadriPerAnno";
	}
	
	@GetMapping("/quadriPerNome")
	public String getQuadriPerNome(Model model){
		
		model.addAttribute("quadri", this.quadroService.findAll());
		return "quadriPerNome";
	}
	
	@GetMapping("/eliminaQuadro")
	public String eliminaQuadro(Model model){
		model.addAttribute("quadri", quadroService.findAll());
		return "gestisciQuadri";
	}
	
	@GetMapping("/eliminaQ")
	public String elimina(Model model, @ModelAttribute("id") Long id){
		Quadro quadro = quadroService.findbyId(id);
		quadroService.delete(quadro);
		model.addAttribute("quadri", quadroService.findAll());
		return "gestisciQuadri";
	}
	
	@GetMapping("/infoQuadro")
	public String mostraInfo( Model model, @ModelAttribute("id") Long id){
		
		Quadro quadro = quadroService.findbyId(id);
		model.addAttribute(quadro);
		return "informazioniQuadro";
}
	
	
}
