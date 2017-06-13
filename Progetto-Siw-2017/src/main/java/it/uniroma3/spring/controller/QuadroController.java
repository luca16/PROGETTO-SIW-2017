
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
	
	@GetMapping("/quadro")
	public String showForm(Quadro quadro,Model model){
		model.addAttribute("autori", autoreService.findAll());
		return "quadroForm";
	}

	
	@PostMapping("/quadro")
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
	
	@GetMapping("/dettagliQuadro")
	public String infoQuadro(Quadro quadro,Model model){
		
		return "informazioniQuadro";
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
	
	
}
