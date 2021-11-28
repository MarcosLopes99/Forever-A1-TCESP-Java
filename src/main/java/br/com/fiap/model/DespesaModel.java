package br.com.fiap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DespesaModel {

	private String orgao;
	private String mes;
	private String evento;
	private String nr_empenho;
	private String id_fornecedor;
	private String nm_fornecedor;
	private String dt_emissao_despesa;
	private String vl_despesa;
		
	public DespesaModel() {
		
	}
	
	public DespesaModel(String orgao, String mes, String evento, String nr_empenho, String id_fornecedor,
			String nm_fornecedor, String dt_emissao_despesa, String vl_despesa) {
		this.orgao = orgao;
		this.mes = mes;
		this.evento = evento;
		this.nr_empenho = nr_empenho;
		this.id_fornecedor = id_fornecedor;
		this.nm_fornecedor = nm_fornecedor;
		this.dt_emissao_despesa = dt_emissao_despesa;
		this.vl_despesa = vl_despesa;
	}

	public String getOrgao() {
		return orgao;
	}
	
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getEvento() {
		return evento;
	}
	
	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	public String getNr_empenho() {
		return nr_empenho;
	}
	
	public void setNr_empenho(String nr_empenho) {
		this.nr_empenho = nr_empenho;
	}
	
	public String getId_fornecedor() {
		return id_fornecedor;
	}
	
	public void setId_fornecedor(String id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	
	public String getNm_fornecedor() {
		return nm_fornecedor;
	}
	
	public void setNm_fornecedor(String nm_fornecedor) {
		this.nm_fornecedor = nm_fornecedor;
	}
	
	public String getDt_emissao_despesa() {
		return dt_emissao_despesa;
	}
	
	public void setDt_emissao_despesa(String dt_emissao_despesa) {
		this.dt_emissao_despesa = dt_emissao_despesa;
	}
	
	public String getVl_despesa() {
		return vl_despesa;
	}
	
	public void setVl_despesa(String vl_despesa) {
		this.vl_despesa = vl_despesa;
	}
	
	
}
