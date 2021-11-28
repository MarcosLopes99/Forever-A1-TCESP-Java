package br.com.fiap.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "municipios")
public class MunicipioModel {

	private long idMunicipio;
	private String nomeMunicipio;
	private Date ultimaChecagemMunicipio;
	private String statusChecagemMunicipio;
	private UsuarioModel userResponsavel;
	
	public MunicipioModel() {
	}

	public MunicipioModel(long idMunicipio, String nomeMunicipio, String statusChecagemMunicipio) {
		this.idMunicipio = idMunicipio;
		this.nomeMunicipio = nomeMunicipio;
		this.statusChecagemMunicipio = statusChecagemMunicipio;
	}

	@Id
	@Column(name = "id_municipio")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "municipio_identity")
	@SequenceGenerator(name = "municipio_seq", sequenceName = "municipio_identity", allocationSize = 1)
	@ApiModelProperty(value = "ID do Municipio")
	public long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	@Column(name = "nome_municipio")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	@ApiModelProperty(value = "Nome do Municipio")
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	@Column(name = "ultima_checagem_municipio")
	@ApiModelProperty(value = "Ultima vez que o Municipio foi checado")
	public Date getUltimaChecagemMunicipio() {
		return ultimaChecagemMunicipio;
	}

	public void setUltimaChecagemMunicipio(Date ultimaChecagemMunicipio) {
		this.ultimaChecagemMunicipio = ultimaChecagemMunicipio;
	}

	@Column(name = "status_checagem_municipio")
	@NotNull(message = "Status de checagem obrigatório")
	@ApiModelProperty(value = "Status de checagem do Municipio")
	public String getStatusChecagemMunicipio() {
		return statusChecagemMunicipio;
	}

	public void setStatusChecagemMunicipio(String statusChecagemMunicipio) {
		this.statusChecagemMunicipio = statusChecagemMunicipio;
	}

	@ManyToOne()
	@JoinColumn(name = "id_user", nullable = true)
	@ApiModelProperty(value = "Usuario responsável pro checar o Municipio")
	public UsuarioModel getUserResponsavel() {
		return userResponsavel;
	}

	public void setUserResponsavel(UsuarioModel userResponsavel) {
		this.userResponsavel = userResponsavel;
	}
	
}
