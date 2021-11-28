package br.com.fiap.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.UsuarioRepository;

@Component
public class UsuarioBusiness {

	@Value("${rest.exception.business.contains-teste}")
	private String containsTeste;

	@Autowired
	public UsuarioRepository usuarioRepository;

	public UsuarioModel applyBusiness(UsuarioModel usuario) throws ResponseBusinessException {

		// #1
		verifyNomeUsuario(usuario.getNomeUser());

		// #2
		String nome = changeFirstLetterToUpperCaseNome(usuario.getNomeUser());
		usuario.setNomeUser(nome);
		
		// #3
		String sobrenome = changeFirstLetterToUpperCaseSobrenome(usuario.getSobrenomeUser());
		usuario.setSobrenomeUser(sobrenome);
		
		return usuario;
	}

	// #1
	protected void verifyNomeUsuario(String nome) throws ResponseBusinessException {

		String nomeUsuario = nome.toUpperCase();

		if (nomeUsuario.contains("TESTE")) {
			throw new ResponseBusinessException(containsTeste);
		}
	}

	// #2
	protected String changeFirstLetterToUpperCaseNome(String nome) {
		String nomeUsuario = nome.toLowerCase();
		nomeUsuario = nomeUsuario.substring(0, 1).toUpperCase() + nomeUsuario.substring(1);
		return nomeUsuario;
	}

	// #3
	protected String changeFirstLetterToUpperCaseSobrenome(String sobrenome) {
		String sobrenomeUsuario = sobrenome.toLowerCase();
		sobrenomeUsuario = sobrenomeUsuario.substring(0, 1).toUpperCase() + sobrenomeUsuario.substring(1);
		return sobrenomeUsuario;
	}

}
