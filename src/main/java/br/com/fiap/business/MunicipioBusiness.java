package br.com.fiap.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.MunicipioModel;
import br.com.fiap.repository.MunicipioRepository;

@Component
public class MunicipioBusiness {

	@Value("${rest.exception.business.contains-teste}")
	private String containsTeste;

	@Autowired
	public MunicipioRepository municipioRepository;

	public MunicipioModel applyBusiness(MunicipioModel municipio) throws ResponseBusinessException {

		// #1
		verifyNomeMunicipio(municipio.getNomeMunicipio());
		
		// #2
		String statusChecagemMunicipio = changeStatusToUpperCase(municipio.getStatusChecagemMunicipio());
		municipio.setStatusChecagemMunicipio(statusChecagemMunicipio);
		
		return municipio;

	}

	// #1
	protected void verifyNomeMunicipio(String nome) throws ResponseBusinessException {

		String nomeMunicipio = nome.toUpperCase();

		if (nomeMunicipio.contains("TESTE")) {
			throw new ResponseBusinessException(containsTeste);
		}
	}

	// #2
	protected String changeStatusToUpperCase(String statusChecagemMunicipio) {
		return statusChecagemMunicipio.toUpperCase();
	}

}
