package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.fiap.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	@Query("SELECT u from UsuarioModel u WHERE u.emailUser = ?1 AND u.senhaUser = ?2")
	UsuarioModel findUsuarioByEmailAndSenha(String emailUser, String senhaUser);
	
	@Query("SELECT u from UsuarioModel u WHERE u.cpfUser = ?1")
	UsuarioModel findUsuarioByCpf(String cpfUser);
	
	@Query("SELECT u from UsuarioModel u WHERE u.nomeUser = ?1")
	UsuarioModel findUsuarioByNome(String nomeUser);
	
}
