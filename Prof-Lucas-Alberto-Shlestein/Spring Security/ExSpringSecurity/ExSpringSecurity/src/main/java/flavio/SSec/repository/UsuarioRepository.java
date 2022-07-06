package flavio.SSec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flavio.SSec.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByLogin(String login);
}
