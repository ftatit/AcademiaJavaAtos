package com.ufnatos.copa2022.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufnatos.copa2022.modelo.Bolao;
import com.ufnatos.copa2022.repository.BolaoRepository;


@Controller
@RequestMapping("/Bolao")
public class BolaoController {

	@Autowired
	private BolaoRepository BolaoRepository;

	@GetMapping("/novo")
	public String adicionarBolao(Model model) {
		model.addAttribute("Bolao", new Bolao());
		return "/publica-criar-Bolao";
	}

	@PostMapping("/salvar")
	public String salvarJogo(@Valid Bolao Bolao, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/publica-criar-Bolao";
		}
		
		/*
		 * //Verificando se já possui um participante do bolão com o mesmo nome
		 * existente no BD: Bolao usr =
		 * BolaoRepository.findByNomeUsuario(Bolao.getNomeUsuario()); if (usr != null) {
		 * model.addAttribute("bolaoExiste",
		 * "Já existe um participante do bolão com esse nome cadastrado"); return
		 * "/publica-criar-Bolao"; } //- - - - - - - - - -
		 */		
		
		
		
		
		
		BolaoRepository.save(Bolao);
		attributes.addFlashAttribute("mensagem", "Jogo cadastrado com sucesso!");
		return "redirect:/Bolao/novo";
	}

	@RequestMapping("/admin/listar")
	public String listarBolao(Model model) {
		model.addAttribute("Bolao", BolaoRepository.findAll());
		return "/auth/admin/admin-listar-Bolao";
	}

	@RequestMapping("/user/listar")
	public String listarBolaoUser(Model model) {
		model.addAttribute("Bolao", BolaoRepository.findAll());
		return "/auth/user/user-listar-Bolao";
	}
	
	// Metodo para apagar usuario:
	@GetMapping("/admin/apagar/{nomeUsuario}")
	public String deleteBolao(@PathVariable("nomeUsuario") String nomeUsuario, Model model) {
		Bolao Bolao = BolaoRepository.findByNomeUsuario(nomeUsuario);
				
//				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + nomeUsuario));
		BolaoRepository.delete(Bolao);
	return "redirect:/bolao/admin/listar";
		
	}
	
	
	//Metodo para editar jogo:
		@GetMapping("/editar/{nomeUsuario}")
		public String editarBolao(@PathVariable("nomeUsuario") long nomeUsuario, Model model) {
			Optional<Bolao> BolaoVelho = BolaoRepository.findById(nomeUsuario);
		if (!BolaoVelho.isPresent()) {
	            throw new IllegalArgumentException("Jogo bolao inválido:" + nomeUsuario);
	        } 
			Bolao Bolao = BolaoVelho.get();
	    model.addAttribute("Bolao", Bolao);
	    return "/auth/user/user-alterar-Bolao";
	}
		
		@PostMapping("/editar/{nomeUsuario}")
		public String editarBolao(@PathVariable("nomeUsuario") String nomeUsuario, 
				@Valid Bolao Bolao, BindingResult result) {
			if (result.hasErrors()) {
		    	Bolao.setNomeUsuario(nomeUsuario);
		        return "/auth/user/user-alterar-Bolao";
		    }
		    BolaoRepository.save(Bolao);
		    return "redirect:/Bolao/admin/listar";
		}
	

}


