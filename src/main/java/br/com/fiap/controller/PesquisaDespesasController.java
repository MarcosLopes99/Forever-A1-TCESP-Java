package br.com.fiap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.DespesaModel;
import br.com.fiap.model.PesquisaModel;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pesquisa-despesas")
public class PesquisaDespesasController {

	@Bean
	public RestTemplate getRestTemplate() {return new RestTemplate(); }
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping()
	@ApiOperation(value = "Exibe a página com form para pesquisa")
	public ModelAndView exibirForm(Model model) {
		
		model.addAttribute("pesquisaModel", new PesquisaModel());
		return new ModelAndView("pesquisa-despesas");
		
	}

	@GetMapping("/resultado")
	@ApiOperation(value = "Retorna o resultado da pesquisa em uma página com uma tabela")
	public ModelAndView fazerPesquisa(@Valid PesquisaModel pesquisaModel, BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("pesquisa-despesas");
		}
		
		ResponseEntity<List<DespesaModel>> despesasResponse =
		        restTemplate.exchange("https://transparencia.tce.sp.gov.br/api/json/despesas/" + pesquisaModel.getMunicipio() + "/" + pesquisaModel.getExercicio() + "/" + pesquisaModel.getMes(),
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<DespesaModel>>() {
		            });
		
		List<DespesaModel> despesas = despesasResponse.getBody();
		
		model.addAttribute("despesas", despesas);
		
		return new ModelAndView("pesquisa-resultado");
		
	}

}
