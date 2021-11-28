package br.com.fiap.controller;

import javax.servlet.http.HttpSession;
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

import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@GetMapping("/")
	@ApiOperation(value = "Retorna a página de login")
	public ModelAndView exibirLogin(UsuarioModel usuarioModel) {
		return new ModelAndView("login");
	}
	
	@PostMapping("/efetuarLogin")
    @ApiOperation(value = "Tenta efetuar o login com os dados que foram preenchidos")
    public RedirectView efetuarLogin(@Valid UsuarioModel usuarioModel, BindingResult bindingResult, RedirectAttributes ra, HttpSession session, Model model) {
        
        usuarioModel = this.usuarioRepository.findUsuarioByEmailAndSenha(usuarioModel.getEmailUser(), usuarioModel.getSenhaUser());
        
        if(bindingResult.hasErrors()) {
            ra.addFlashAttribute("mensagem", "Preencha os campos adequadamente!");
            return new RedirectView("/tcesp");
        }
        
        if (usuarioModel != null){
            session.setAttribute("usuarioLogado", usuarioModel);
            return new RedirectView("/tcesp/home");
        } else {
            ra.addFlashAttribute("mensagem", "E-mail e/ou Senha inválidos!");
            return new RedirectView("/tcesp");
        }
        
    }
	
}
