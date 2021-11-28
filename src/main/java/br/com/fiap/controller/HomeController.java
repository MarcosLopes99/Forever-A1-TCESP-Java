package br.com.fiap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping()
	@ApiOperation(value = "Retorna a página de início")
	public ModelAndView homePage() {
	    return new ModelAndView("home");
	}
	
}
