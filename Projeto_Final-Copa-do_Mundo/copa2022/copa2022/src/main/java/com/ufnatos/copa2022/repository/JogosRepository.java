package com.ufnatos.copa2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufnatos.copa2022.modelo.Jogos;


public interface JogosRepository extends JpaRepository<Jogos, Long> {
	
		//METODO QUE FARÁ A BUSCA NO BD E VERIFICARÁ SE POSSUI UM "idJogo" EXISTENTE NO BD:		
		Jogos findByIdJogo(Long idJogo);
}


	