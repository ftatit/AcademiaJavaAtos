package flavio.SSec.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
/*Para que a nossa classe controller seja um controlador, ou seja, 
 * que ela possa receber requisições http e depois transfira para algum
 *  método mapeado para poder receber essa chama via browser
 */
public class HomeController {

	//Metodo para criação da pagina html:
	@RequestMapping("/") //Vai direcionar uma requisição httml para esse metodo
	public String index(Model model) { //metodo=index e vai retornar uma String.
		model.addAttribute("msnBemVindo", "Bem-Vindo à a Empresa JUsers");//uma chave para um determinado valor
		return "publica-index"; //é o nome da pagina html que iremos criar
	}
	
	@RequestMapping("/login") 
	public String login() {
		return "login";
	}
	
}
