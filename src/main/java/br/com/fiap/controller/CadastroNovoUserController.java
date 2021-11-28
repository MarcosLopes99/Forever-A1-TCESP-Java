package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.fiap.business.UsuarioBusiness;
import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
public class CadastroNovoUserController {

	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioBusiness usuarioBusiness;
	
	@GetMapping("/cadastro-novo-user")
	@ApiOperation(value = "Retorna a página de cadastro")
	public ModelAndView exibirCadastro(UsuarioModel usuarioModel) {
		return new ModelAndView("cadastro-novo-user");
	}
	
	@PostMapping("/cadastrar-usuario")
	@ApiOperation(value = "Cadastro o novo usuário utilizando os dados preenchidos")
	public RedirectView save(@Valid UsuarioModel usuarioModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("usuarios", usuarioRepository.findAll());
			return new RedirectView("/tcesp/cadastro-novo-user");
		}
		
		UsuarioModel usuario = usuarioBusiness.applyBusiness(usuarioModel);
		
		usuarioRepository.save(usuario);
		redirectAttributes.addFlashAttribute("mensagem", "Cadastrado adicionado com sucesso!");
		return new RedirectView("/tcesp");
	}
	
}
