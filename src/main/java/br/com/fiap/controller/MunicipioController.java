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

import br.com.fiap.business.MunicipioBusiness;
import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.MunicipioModel;
import br.com.fiap.repository.MunicipioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

	@Autowired
	public MunicipioRepository municipioRepository;
	
	@Autowired
	public MunicipioBusiness municipioBusiness;
	
	@GetMapping()
	@ApiOperation(value = "Retorna uma lista de municipios")
	public ResponseEntity<List<MunicipioModel>> findAll(Model model) {

		List<MunicipioModel> municipios = municipioRepository.findAll();
		return ResponseEntity.ok(municipios);
	}
	
	@GetMapping("/{idMunicipio}")
	@ApiOperation(value = "Retorna um municipio pelo id")
	public ResponseEntity<MunicipioModel> findById(@PathVariable("idMunicipio") long idMunicipio) {
		
		MunicipioModel municipio = municipioRepository.findById(idMunicipio).get();
		return ResponseEntity.ok(municipio);
	}
	
	@PostMapping()
	@ApiOperation(value = "Salva um novo municipio")
	public ResponseEntity save(@RequestBody @Valid MunicipioModel municipioModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		MunicipioModel municipio = municipioBusiness.applyBusiness(municipioModel);
		
		municipioRepository.save(municipio);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idMunicipio}")
				.buildAndExpand(municipio.getIdMunicipio()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{idMunicipio}")
	@ApiOperation(value = "Atualiza um municipio a partir do id")
	public ResponseEntity update(@PathVariable("idMunicipio") long idMunicipio, @RequestBody @Valid MunicipioModel municipioModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		MunicipioModel municipio = municipioBusiness.applyBusiness(municipioModel);
		
		municipio.setIdMunicipio(idMunicipio);
		municipioRepository.save(municipio);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idMunicipio}")
	public ResponseEntity deleteById(@PathVariable("idMunicipio") long idMunicipio) {
		
		municipioRepository.deleteById(idMunicipio);
		return ResponseEntity.noContent().build();
	}
	
}
