package com.ufnatos.copa2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufnatos.copa2022.modelo.Usuario;

//TODOS OS METODOS DA JPAREPOSITORY, INCLUINDO O CRUD, SERÃO PASSADOS PARA O "UsuarioRepository"
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//METODO QUE FARÁ A BUSCA NO BD E VERIFICARÁ SE POSSUI LOGIN EXISTENTE NO BD:
	Usuario findByLogin(String login);
}
