package br.com.kentec.energy.domain;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cadastro")
@SuppressWarnings("serial")
public class Cadastro implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="nome", nullable = true, length = 50)
	private String nome;
	
	@Column(name="cpf", nullable = true, length = 20)
	private String cpf;
	
	@Column(name="data_nasc", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataNascimento;
	
	@Column(name="fone", nullable = true, length = 20)
	private String fone;
	
	@Column(name="fone_cel", nullable = true, length = 20)
	private String foneCel;
	
	@Column(name="fone_cel2", nullable = true, length = 20)
	private String foneCel2;
	
	@Column(name="endereco", nullable = true, length = 100)
	private String endereco;
	
	@Column(name="sexo", nullable = true, length = 15)
	private String sexo;
	
	@Column(name="email", nullable = true, length = 60)
	private String email;
	
	@Column(name="login", nullable = true, length = 20)
	private String login;
	
	@Column(name="tipo_user", nullable = true, length = 50)
	private String tipoUser;
	
	@Column(name="senha", nullable = true, length = 20)
	private String senha;
	
	@Column(name="status_mat", nullable = true, length = 15)
	private String statusMatricula;
	
	@Column
	@Lob
	public byte[] foto;
	
	public Cadastro() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getFoneCel() {
		return foneCel;
	}

	public void setFoneCel(String foneCel) {
		this.foneCel = foneCel;
	}

	public String getFoneCel2() {
		return foneCel2;
	}

	public void setFoneCel2(String foneCel2) {
		this.foneCel2 = foneCel2;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}
