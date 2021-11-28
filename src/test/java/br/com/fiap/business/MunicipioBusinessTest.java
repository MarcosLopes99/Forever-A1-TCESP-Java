package br.com.fiap.business;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.MunicipioModel;
import br.com.fiap.repository.MunicipioRepository;

@SpringBootTest
public class MunicipioBusinessTest {
	
	@InjectMocks
	public MunicipioBusiness municipioBusiness;
	
	@Mock
	public MunicipioRepository municipioRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = ResponseBusinessException.class)
	public void testeVerifyNomeMunicipioWithTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Municipio Teste";
		
		
		// WHEN
		municipioBusiness.verifyNomeMunicipio(nome);
		
	}
	
	@Test
	public void testeVerifyNomeMunicipioWithoutTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Municipio Normal";
		
		
		// WHEN
		municipioBusiness.verifyNomeMunicipio(nome);
		
	}
	
	@Test
	public void testChangeStatusToUpperCase() {
		
		// GIVEN
		
		String status = "checado";
		String expected = "CHECADO";
		
		// WHEN
		String actual = municipioBusiness.changeStatusToUpperCase(status);
		
		// THEN
		assertEquals("Erro ao transformar o Status em maiusculo", expected, actual);
		
	}
	
	@Test
	public void testApplyBusiness() throws ResponseBusinessException {
		
		// GIVEN
		MunicipioModel municipio = new MunicipioModel(1, "Municipio Novo", "chECaDO");
		MunicipioModel expected = new MunicipioModel(1, "Municipio Novo", "CHECADO");
		
		// WHEN
		Mockito.when(municipioRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(municipio));
		MunicipioModel actual = municipioBusiness.applyBusiness(municipio);
		
		// THEN
		assertEquals(expected.getIdMunicipio(), actual.getIdMunicipio());
		assertEquals(expected.getNomeMunicipio(), actual.getNomeMunicipio());
		assertEquals(expected.getStatusChecagemMunicipio(), actual.getStatusChecagemMunicipio());
		
	}

}
