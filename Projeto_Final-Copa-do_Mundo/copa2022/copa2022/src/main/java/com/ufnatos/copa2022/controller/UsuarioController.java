package com.ufnatos.copa2022.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufnatos.copa2022.modelo.Papel;
import com.ufnatos.copa2022.modelo.Usuario;
import com.ufnatos.copa2022.repository.PapelRepository;
import com.ufnatos.copa2022.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired //(INJEÇÃO DE DEPENDNECIA:)
	private BCryptPasswordEncoder criptografia;
	
	
	// MÉTODO QUE VERIFICA QUAL O PAPEL O USUARIO POSSUI:	
	private boolean temAutorizacao(Usuario usuario, String papel) {
		for (Papel pp : usuario.getPapeis()) {
			if (pp.getPapel().equals(papel)) {
				return true;
			}
	    }
		return false;
	}
	
	@GetMapping("/index")
	public String index(@CurrentSecurityContext(expression="authentication.name") 
	//QND O USUARIO É LOGADO, O SPRING SECURITY MANTEM A INFO ARMAZENADA
						String login) {
		
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		String redirectURL = "";
		
		//SE O USUARIO FOR DO TIPO ADMIN:
		if (temAutorizacao(usuario, "ADMIN")) {
            redirectURL = "/auth/admin/admin-index";
            
        //SE O USUARIO FOR DO TIPO USER:
        } else if (temAutorizacao(usuario, "USER")) {
            redirectURL = "/auth/user/user-index";
        
        }		
        return redirectURL;
	}
	
	//METODO DE REGISTRO DE NOVO USUÁRIO:
	@GetMapping("/novo")
	public String adicionarUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/publica-criar-usuario";
	}
	
	//METODO PARA SALVAR USUARIO CADASTRADO:
	@PostMapping("/salvar")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult result,  //VALIDAÇÃO DAS INFORMAÇÕES CADASTRADAS PELO USUÁRIO
				Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/publica-criar-usuario";
		}	
		//VERIFICAÇÃO DE USUÁRIO EXISTENTE COM MESMO LOGIN, CADASTRADO NO BD:
		Usuario usr = usuarioRepository.findByLogin(usuario.getLogin());
		if (usr != null) {
			model.addAttribute("loginExiste", "Login já existe cadastrado"); 
			//SE A CHAVE "loginExiste" FOR ACIONADA, INFORMA A MSG PROGRAMADA "Login já existe cadastrado"
			return "/publica-criar-usuario";
		}
		//- - - - - - - - - -
		
		//ASSOCIA O PAPEL DE "USER" AO NOVO USUARIO CADASTRADO:
		Papel papel = papelRepository.findByPapel("USER");
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);				
		usuario.setPapeis(papeis);  
				
		//ENCRIPTOGRAFANDO A SENHA CADASTRADA PELO NOVO USUARIO PARA ENVIAR AO BD:
		String senhaCriptografia = criptografia.encode(usuario.getPassword());
		usuario.setPassword(senhaCriptografia);//DEVOLVENDO A SENHA ENCRIPTOGRAFADA
		
		usuarioRepository.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return "redirect:/usuario/novo";
	}
	
	
	//METODO DE LISTAGEM DE USUÁRIOS - LOGADO COMO ADMINISTRADOR:
	@RequestMapping("/admin/listar")
	public String listarUsuario(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());		
		return "/auth/admin/admin-listar-usuario";		
	}
		
	
	//MÉTODO PARA APAGAR USUÁRIO - LOGADO COMO ASMINISTRADOR:
	@GetMapping("/admin/apagar/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
		usuarioRepository.delete(usuario);
	    return "redirect:/usuario/admin/listar";
	}
	
	
	//MÉTODO PARA EDITAR USUÁRIO - GET:
	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> usuarioVelho = usuarioRepository.findById(id);
		if (!usuarioVelho.isPresent()) {
            throw new IllegalArgumentException("Usuário inválido:" + id);
        } 
		Usuario usuario = usuarioVelho.get();
	    model.addAttribute("usuario", usuario);
	    return "/auth/user/user-alterar-usuario";
	}
	
	//MÉTODO PARA EDITAR USUÁRIO - POST:
	@PostMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, 
			@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
	    	usuario.setId(id);
	        return "/auth/user/user-alterar-usuario";
	    }
	    usuarioRepository.save(usuario);
	    return "redirect:/usuario/admin/listar";
	}
	
	//MÉTODO PARA EDITAR PAPEL DO USUÁRIO - GET:
	@GetMapping("/editarPapel/{id}")
	public String selecionarPapel(@PathVariable("id") long id, Model model) {
		Optional<Usuario> usuarioVelho = usuarioRepository.findById(id);
		if (!usuarioVelho.isPresent()) {
            throw new IllegalArgumentException("Usuário inválido:" + id);
        } 
		Usuario usuario = usuarioVelho.get();
	    model.addAttribute("usuario", usuario);
	    
	    model.addAttribute("listaPapeis", papelRepository.findAll());
	    
	    return "/auth/admin/admin-editar-papel-usuario";
	}
	
	//MÉTODO PARA EDITAR PAPEL DO USUÁRIO - POST:
	@PostMapping("/editarPapel/{id}")
	public String atribuirPapel(@PathVariable("id") long idUsuario, 
								@RequestParam(value = "pps", required=false) int[] pps, 
								Usuario usuario, 
								RedirectAttributes attributes) {
		if (pps == null) {
			usuario.setId(idUsuario);
			attributes.addFlashAttribute("mensagem", "Pelo menos um papel deve ser informado");
			return "redirect:/usuario/editarPapel/"+idUsuario;
		} else {
			//OBTÉM A LISTA DE PAPÉIS SELECIONADA PELO USUÁRIO DO BD:
			List<Papel> papeis = new ArrayList<Papel>();			 
			for (int i = 0; i < pps.length; i++) {
				long idPapel = pps[i];
				Optional<Papel> papelOptional = papelRepository.findById(idPapel);
				if (papelOptional.isPresent()) {
					Papel papel = papelOptional.get();
					papeis.add(papel);
		        }
			}
			Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
			if (usuarioOptional.isPresent()) {
				Usuario usr = usuarioOptional.get();
				usr.setPapeis(papeis); // RELACIONA A CLASSE PAPÉIS A USUÁRIO
				usr.setAtivo(usuario.isAtivo()); //SETA O STATUS DO USUÁRIO
				usuarioRepository.save(usr);
	        }			
		}		
	    return "redirect:/usuario/admin/listar";
	}
	
	

}
