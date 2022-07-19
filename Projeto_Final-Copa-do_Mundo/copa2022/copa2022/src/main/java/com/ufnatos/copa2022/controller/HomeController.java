package com.ufnatos.copa2022.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//PARA QUE A CLASSE CONTROLLER, SEJA UM CONTROLADOR:
@Controller 
public class HomeController {
	
		//MÉTODO PARA REDIRECIONAMENTO A PÁGINA DE "copa-index":
		@RequestMapping("/") 
		public String index(Model model) { 
			model.addAttribute("msnBemVindo", "    ");
			return "copa-index"; 
		}

		//MÉTODO PARA REDIRECIONAMENTO A PÁGINA DE LOGIN:
		@RequestMapping("/login") 
		public String login() { 
			
			return "login"; 
		}
}
