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

import com.ufnatos.copa2022.modelo.Jogos;
import com.ufnatos.copa2022.repository.JogosRepository;

@Controller
@RequestMapping("/jogos")
public class JogosController {

	@Autowired
	private JogosRepository jogosRepository;

	// METODO PARA CADSTRO DE JOGO - MODO ADMIN:
	@GetMapping("/novo")
	public String adicionarJogo(Model model) {
		model.addAttribute("jogos", new Jogos());
		return "/publica-criar-jogo";
	}

	// METODO PARA SALVAR JOGO - MODO ADMIN:
	@PostMapping("/salvar")
	public String salvarJogo(@Valid Jogos jogos, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/publica-criar-jogo";
		}

		// VERIFICA SE NÃO EXISTE UM JOFO COM O MESMO "idJogo" EXISTENTE NO BD:
		Jogos usr = jogosRepository.findByIdJogo(jogos.getIdJogo());
		if (usr != null) {
			model.addAttribute("jogoExiste", "Jogo já existe cadastrado");
			return "/publica-criar-jogo";
		}

		jogosRepository.save(jogos);
		attributes.addFlashAttribute("mensagem", "Jogo cadastrado com sucesso!");
		return "redirect:/jogos/novo";
	}

	// METODO PARA LISTAR JOGOS - MODO ADMIN:
	@RequestMapping("/admin/listar")
	public String listarJogos(Model model) {
		model.addAttribute("jogos", jogosRepository.findAll());
		return "/auth/admin/admin-listar-jogos";
	}

	// METODO PARA LISTAR JOGOS - MODO USER:
	@RequestMapping("/user/listar")
	public String listarJogosUser(Model model) {
		model.addAttribute("jogos", jogosRepository.findAll());
		return "/auth/user/user-listar-jogos";
	}

	// METODO PARA APAGAR USUARIO:
	@GetMapping("/admin/apagar/{idJogo}")
	public String deleteJogos(@PathVariable("idJogo") long idJogo, Model model) {
		Jogos jogos = jogosRepository.findById(idJogo)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + idJogo));
		jogosRepository.delete(jogos);
		return "redirect:/jogos/admin/listar";
	}

	// METODO PARA EDITAR JOGO - GET:
	@GetMapping("/editar/{idJogo}")
	public String editarJogos(@PathVariable("idJogo") long idJogo, Model model) {
		Optional<Jogos> jogosVelho = jogosRepository.findById(idJogo);
		if (!jogosVelho.isPresent()) {
			throw new IllegalArgumentException("Jogo inválido:" + idJogo);
		}
		Jogos jogos = jogosVelho.get();
		model.addAttribute("jogos", jogos);
		return "/auth/user/user-alterar-jogos";
	}

	// METODO PARA EDITAR JOGO - POST:
	@PostMapping("/editar/{idJogo}")
	public String editarJogos(@PathVariable("idJogo") long idJogo, @Valid Jogos jogos, BindingResult result) {
		if (result.hasErrors()) {
			jogos.setIdJogo(idJogo);
			return "/auth/user/user-alterar-jogos";
		}
		jogosRepository.save(jogos);
		return "redirect:/jogos/admin/listar";
	}

}
