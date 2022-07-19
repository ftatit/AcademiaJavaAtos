package com.ufnatos.copa2022.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CuriosidadesController {

	//MÉTODO PARA REDIRECIONAMENTO A PÁGINA DE CURIOSIDADE (ESTADIOS):
	@RequestMapping("/curiosidades") 
	public String index(Model model) { 
		model.addAttribute("msnBemVindo", "   ");
		return "curiosidades"; 
	}
}
