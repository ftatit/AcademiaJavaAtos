package flavio.SSec.modelo;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.JoinColumn;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity //Mapea a nossa classe ocmo uma tabela no BD
public class Usuario { //Foi definido que essa classe será uma entidade 
	
	@Id //Informa que o valor id será uma chave primária no nosso banco.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Gera automaticamente a cada objeto gerado no BD
	private Long id;  //será a chave primaria gerada automaticamente no BD
	
	@NotNull //esse campo nao podeser nulo
	@Size(min = 3, max = 50,  message = "O nome deve ter entre 3 - 50 cartactéres")
	private String nome;
			
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "A senha deve ser informada")
	@Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres")
	private String password;
	
	@NotEmpty(message = "O login deve ser informado")
	@Size(min = 4, message = "O login deve ter no mínimo 4 caracteres")
	private String login;
	
	
	private boolean ativo; //vai dizer se o usuario esta ativo ou nao no sistema
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_papel", //nomeando uma terceira tabela que fará o relacionamento dessas classes
			   joinColumns = @JoinColumn(name = "usuario_id"),
			   inverseJoinColumns = @JoinColumn(name = "papel_id")) //chave estrangeira do papel
	private List<Papel> papeis;
	
	
	//METODOS GETTERS AND SETTERS:
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	
	
	
}
