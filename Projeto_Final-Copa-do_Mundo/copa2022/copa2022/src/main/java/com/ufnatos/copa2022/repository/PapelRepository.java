package com.ufnatos.copa2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufnatos.copa2022.modelo.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
	
	Papel findByPapel(String papel);

}
