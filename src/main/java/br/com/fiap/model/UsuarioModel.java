package br.com.fiap.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

	private long idUser;
	private String nomeUser;
	private String sobrenomeUser;
	@Column(unique = true)
	private String emailUser;
	private long telefoneUser;
	private String senhaUser;
	@Column(unique = true)
	private String cpfUser;
	private List<MunicipioModel> municipiosEncarregados;

	public UsuarioModel() {
	}

	public UsuarioModel(long idUser, String nomeUser, String sobrenomeUser, String emailUser, long telefoneUser,
			String senhaUser, String cpfUser) {
		this.idUser = idUser;
		this.nomeUser = nomeUser;
		this.sobrenomeUser = sobrenomeUser;
		this.emailUser = emailUser;
		this.telefoneUser = telefoneUser;
		this.senhaUser = senhaUser;
		this.cpfUser = cpfUser;
	}

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usuario_identity")
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_identity", allocationSize = 1)
	@ApiModelProperty(value = "ID do Usuario")
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	@Column(name = "nome_user")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 20, message = "NOME deve conter entre 2 e 20 caracteres")
	@ApiModelProperty(value = "Nome do Usuario")
	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	@Column(name = "sobrenome_user")
	@NotNull(message = "Sobrenome obrigatório")
	@Size(min = 2, max = 100, message = "SOBRENOME deve conter entre 2 e 100 caracteres")
	@ApiModelProperty(value = "Sobrenome do Usuario")
	public String getSobrenomeUser() {
		return sobrenomeUser;
	}

	public void setSobrenomeUser(String sobrenomeUser) {
		this.sobrenomeUser = sobrenomeUser;
	}

	@Column(name = "email_user")
	@NotNull(message = "E-mail obrigatório")
	@Size(min = 2, max = 50, message = "E-MAIL deve conter entre 2 e 50 caracteres")
	@ApiModelProperty(value = "E-mail do Usuario")
	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	@Column(name = "telefone_user")
	@NotNull(message = "Telefone obrigatório")
	@Range(min = 3, message = "TELEFONE deve conter 3 ou mais caracteres")
	@ApiModelProperty(value = "Telefone do Usuario")
	public long getTelefoneUser() {
		return telefoneUser;
	}

	public void setTelefoneUser(long telefoneUser) {
		this.telefoneUser = telefoneUser;
	}

	@Column(name = "senha_user")
	@NotNull(message = "Senha obrigatória")
	@Size(min = 2, max = 50, message = "SENHA deve conter entre 2 e 50 caracteres")
	@ApiModelProperty(value = "Senha do Usuario")
	public String getSenhaUser() {
		return senhaUser;
	}

	public void setSenhaUser(String senhaUser) {
		this.senhaUser = senhaUser;
	}

	@Column(name = "cpf_user")
	@NotNull(message = "CPF obrigatório")
	@Size(min = 11, max = 11, message = "CPF deve conter 11 caracteres")
	@ApiModelProperty(value = "CPF do Usuario")
	public String getCpfUser() {
		return cpfUser;
	}

	public void setCpfUser(String cpfUser) {
		this.cpfUser = cpfUser;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "userResponsavel")
	@ApiModelProperty(value = "Lista de Municipios que o Usuario é encarregado")
	public List<MunicipioModel> getMunicipiosEncarregados() {
		return municipiosEncarregados;
	}

	public void setMunicipiosEncarregados(List<MunicipioModel> municipiosEncarregados) {
		this.municipiosEncarregados = municipiosEncarregados;
	}

}
