package flavio.SSec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flavio.SSec.modelo.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
	Papel findByPapel(String papel);
}
