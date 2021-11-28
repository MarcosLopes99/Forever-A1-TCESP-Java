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
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioBusinessTest {

	@InjectMocks
	public UsuarioBusiness usuarioBusiness;
	
	@Mock
	public UsuarioRepository usuarioRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = ResponseBusinessException.class)
	public void testVerifyNomeUsuarioWithTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Teste";
		
		// WHEN
		usuarioBusiness.verifyNomeUsuario(nome);
		
	}
	
	@Test
	public void testVerifyNomeUsuarioWithoutTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Marcos";
		
		// WHEN
		usuarioBusiness.verifyNomeUsuario(nome);
		
	}
	
	@Test
	public void testChangeFirstLetterToUpperCaseNome() {
		
		// GIVEN
		String nome = "mARCOS";
		String expected = "Marcos";
		
		// WHEN
		String actual = usuarioBusiness.changeFirstLetterToUpperCaseNome(nome);
		
		// THEN
		assertEquals("Erro ao transformar o nome para o formato correto", expected, actual);
		
	}
	
	@Test
	public void testChangeFirstLetterToUpperCaseSobrenome() {
		
		// GIVEN
		String sobrenome = "lOPES";
		String expected = "Lopes";
		
		// WHEN
		String actual = usuarioBusiness.changeFirstLetterToUpperCaseSobrenome(sobrenome);
		
		// THEN
		assertEquals("Erro ao transformar o sobrenome para o formato correto", expected, actual);
		
	}
	
	@Test
	public void testApplyBusiness() throws ResponseBusinessException {
		
		// GIVEN
		UsuarioModel usuario = new UsuarioModel(1, "mArCoS", "lOPEs", "marcos@lopes", 12345678, "marcos123", "12312312312");
		UsuarioModel expected = new UsuarioModel(1, "Marcos", "Lopes", "marcos@lopes", 12345678, "marcos123", "12312312312");
		
		// WHEN
		Mockito.when(usuarioRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(usuario));
		UsuarioModel actual = usuarioBusiness.applyBusiness(usuario);
		
		// THEN
		assertEquals(expected.getIdUser(), actual.getIdUser());
		assertEquals(expected.getNomeUser(), actual.getNomeUser());
		assertEquals(expected.getSobrenomeUser(), actual.getSobrenomeUser());
		assertEquals(expected.getEmailUser(), actual.getEmailUser());
		assertEquals(expected.getTelefoneUser(), actual.getTelefoneUser());
		assertEquals(expected.getSenhaUser(), actual.getSenhaUser());
		assertEquals(expected.getCpfUser(), actual.getCpfUser());
		
	}
	
}
