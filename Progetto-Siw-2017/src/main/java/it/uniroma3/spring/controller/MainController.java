package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// controller to access the login page

@Controller //Da utilizzare a livello di classe per identificarla come controller
public class MainController {

  // Login form
  @RequestMapping("/login") //Da utilizzare per evidenziare il metodo e l’url da mappare
  public String login() {
    return "login";
  }

  // Login form with error
  @RequestMapping(value="/login-error.html")
  public String loginError(Model model) {
    model.addAttribute("loginError", true);
    return "login";
  }

}