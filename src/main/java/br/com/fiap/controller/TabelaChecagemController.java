package br.com.fiap.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.fiap.model.MunicipioModel;
import br.com.fiap.repository.MunicipioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tabela-checagem")
public class TabelaChecagemController {

	@Autowired
	public MunicipioRepository municipioRepository;
	
	@GetMapping()
	@ApiOperation(value = "Retorna a página com uma tabela com todos os municipios cadastrados")
	public ModelAndView findAll(Model model) {

		model.addAttribute("municipios", municipioRepository.findAll());
		return new ModelAndView("tabela-checagem");
	}
	
	@GetMapping("/form")
	@ApiOperation(value = "Retorna os dados do município para edita-los")
	public ModelAndView open(@RequestParam String page, 
					   @RequestParam(required = false) Long idMunicipio,
					   @ModelAttribute("municipioModel") MunicipioModel municipioModel, 
					   Model model) {
		
		if("tabela-editar".equals(page)) {
			model.addAttribute("municipioModel", municipioRepository.findById(idMunicipio).get());
		}
		
		model.addAttribute("municipios", municipioRepository.findAll());
		
		return new ModelAndView(page);
	}
	
	@PutMapping("/{idMunicipio}")
	@ApiOperation(value = "Altera os dados do município")
	public RedirectView update(@PathVariable("idMunicipio") long idMunicipio, @Valid MunicipioModel municipioModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		municipioModel.setIdMunicipio(idMunicipio);
		municipioModel.setUltimaChecagemMunicipio(new Date());
		MunicipioModel municipio = municipioRepository.findById(idMunicipio).get();
		municipioModel.setUserResponsavel(municipio.getUserResponsavel());
		municipioRepository.save(municipioModel);
		redirectAttributes.addFlashAttribute("messages", "Munícipio alterado com sucesso!");
		
		return new RedirectView("/tcesp/tabela-checagem");
	}	
	
}
