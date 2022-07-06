package flavio.SSec.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity //Entidade
public class Papel {
	
	@Id //Esse atributo se comporta como uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //chave primaria va isendo gerada automaticamente
	private Long id;
	
	private String papel;
	
	//Lista de usuarios:
	//Muitos papeis para muitos usuarios:
	@ManyToMany(mappedBy = "papeis", fetch = FetchType.EAGER) //Tras todos os usuarios cadastrados nessa lista.
	private List<Usuario> usuarios;
	
	//Papel terá 2 construtores:
	public Papel() {}

	public Papel(String papel) {
		super();
		this.papel = papel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
}
