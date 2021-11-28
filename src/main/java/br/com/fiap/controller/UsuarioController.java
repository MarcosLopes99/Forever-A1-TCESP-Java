package br.com.fiap.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.business.UsuarioBusiness;
import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.MunicipioModel;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.MunicipioRepository;
import br.com.fiap.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public MunicipioRepository municipioRepository;
	
	@Autowired
	public UsuarioBusiness usuarioBusiness;
	
	@GetMapping()
	@ApiOperation(value = "Retorna uma lista de usuarios")
	public ResponseEntity<List<UsuarioModel>> findAll(Model model) {

		List<UsuarioModel> usuarios = usuarioRepository.findAll();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{idUser}")
	@ApiOperation(value = "Retorna um usuario a partir do id")
	public ResponseEntity<UsuarioModel> findById(@PathVariable("idUser") long idUser) {
		
		UsuarioModel usuario = usuarioRepository.findById(idUser).get();
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/{idUser}/municipios-verificados")
	@ApiOperation(value = "Retorna os municipios verificados por um usuario a partir do seu id")
	public ResponseEntity<List<MunicipioModel>> findMunicipiosChecadosPeloUser(@PathVariable("idUser") long idUser) {
		
		List<MunicipioModel> municipios = municipioRepository.findMunicipiosChecadosPeloUser(idUser);
		return ResponseEntity.ok(municipios);
	}
	
	@PostMapping()
	@ApiOperation(value = "Salva um novo usuario")
	public ResponseEntity save(@RequestBody @Valid UsuarioModel usuarioModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		UsuarioModel usuario = usuarioBusiness.applyBusiness(usuarioModel);
		
		usuarioRepository.save(usuario);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idUser}")
				.buildAndExpand(usuario.getIdUser()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{idUser}")
	@ApiOperation(value = "Atualiza um usuario a partir do id")
	public ResponseEntity update(@PathVariable("idUser") long idUser, @RequestBody @Valid UsuarioModel usuarioModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		UsuarioModel usuario = usuarioBusiness.applyBusiness(usuarioModel);
		
		usuario.setIdUser(idUser);
		usuarioRepository.save(usuario);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idUser}")
	@ApiOperation(value = "Exclui um usuario a partir do id")
	public ResponseEntity deleteById(@PathVariable("idUser") long idUser) {
		
		usuarioRepository.deleteById(idUser);
		return ResponseEntity.noContent().build();
	}
	
}
