package com.ufnatos.copa2022.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarioController {

	////MÉTODO PARA REDIRECIONAMENTO A PÁGINA CALENDARIO:
	@RequestMapping("/calendario") 
	public String index(Model model) { 
		model.addAttribute("msnBemVindo", "   ");
		return "calendario"; 
	}

}
