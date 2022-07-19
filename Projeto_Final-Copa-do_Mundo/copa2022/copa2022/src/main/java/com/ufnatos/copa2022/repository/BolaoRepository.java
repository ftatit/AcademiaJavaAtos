package com.ufnatos.copa2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufnatos.copa2022.modelo.Bolao;


public interface BolaoRepository extends JpaRepository<Bolao, Long> {

	
			//METODO QUE FARÁ A BUSCA NO BD E VERIFICARÁ SE POSSUI UM USUARIO COM MESMO NOME EXISTENTE NO BD:
			Bolao findByNomeUsuario(String nomeUsuario);
	
}
