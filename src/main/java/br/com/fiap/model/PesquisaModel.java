package br.com.fiap.model;

import javax.validation.constraints.NotEmpty;

public class PesquisaModel {
	
	@NotEmpty
	private String municipio;
	@NotEmpty
	private String exercicio;
	@NotEmpty
	private String mes;
	
	public PesquisaModel() {
		
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getExercicio() {
		return exercicio;
	}
	
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
}
