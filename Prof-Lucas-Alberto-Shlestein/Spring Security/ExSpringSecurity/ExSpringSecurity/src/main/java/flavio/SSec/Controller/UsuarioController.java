package flavio.SSec.Controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import flavio.SSec.modelo.Papel;
import flavio.SSec.modelo.Usuario;
import flavio.SSec.repository.PapelRepository;
import flavio.SSec.repository.UsuarioRepository;

@Controller // Isso significa que essa classe estará preparada para receber requisições de
// paginas web
@RequestMapping("/usuario") // Aqui diz qual é o mapeamento da minha classe "UsuarioController", quando
//ela receber requisições de alguma outra página

public class UsuarioController {
	
	@Autowired // Quando vai utilizar a referencia "usuarioRepository" o srping va injetar
	// um objeto para nossa referencia. Nao precisa ficar dando new object
	// O Spring regencia a criação de objetos
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PapelRepository papelRepository;
	
	@GetMapping("/novo") // Se ele receber uma requisição /usuario/novo ele mandará para essa requisição
							// aqui
	public String adicionarUsuario(Model model) { // metodo "adicionarUsuario"
		model.addAttribute("usuario", new Usuario());
		return "/publica-criar-usuario"; // É nessa pagina que teremos o formulário para cadastrar o usuário
	}

	@PostMapping("/salvar")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult result,Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/publica-criar-usuario";
		}
		
		Usuario usr = usuarioRepository.findByLogin(usuario.getLogin());
		if (usr != null) {
			model.addAttribute("loginExiste", "Login já existe cadastrado");
			return "/publica-criar-usuario";
		}
		
		//Busca o papel básico de usuário
		Papel papel = papelRepository.findByPapel("USER");
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);				
		usuario.setPapeis(papeis); // associa o papel de USER ao usuário
		
		usuarioRepository.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return "redirect:/usuario/novo";

	}

	// METODO PARA LISTAR OS USUÁRIOS NO BD:
	// Esse método será acionado quando /usuario/admin/listar:
	@RequestMapping("/admin/listar")
	public String listarUsuario(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "/auth/admin/admin-listar-usuario";// Encaminhando para a nossa pagina criada
	}

	// METODO PARA DELETAR OS USUÁRIOS:

	@GetMapping("/admin/apagar/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
		usuarioRepository.delete(usuario);
		return "redirect:/usuario/admin/listar"; 
	}

	//MÉTODOS PARA ALTERAR USUARIOS (GET/POST)
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
	
	@PostMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			usuario.setId(id);
			return "/auth/user/user-alterar-usuario";
		}
		usuarioRepository.save(usuario);
		return "redirect:/usuario/admin/listar";
	}
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
	
	@PostMapping("/editarPapel/{id}")
	public String atribuirPapel(@PathVariable("id") long idUsuario, 
								@RequestParam(value = "pps", required=false) int[] pps,  //RequestParam vai pegar um parametro via requisição
								Usuario usuario, 
								RedirectAttributes attributes) {
		if (pps == null) {
			usuario.setId(idUsuario);
			attributes.addFlashAttribute("mensagem", "Pelo menos um papel deve ser informado");
			return "redirect:/usuario/editarPapel/"+idUsuario;
		} else {
			//Obtém a lista de papéis selecionada pelo usuário do banco
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
				usr.setPapeis(papeis); // relaciona papéis ao usuário
				usr.setAtivo(usuario.isAtivo());
				usuarioRepository.save(usr);
	        }		
		}		
	    return "redirect:/usuario/admin/listar";
	}
	
}
