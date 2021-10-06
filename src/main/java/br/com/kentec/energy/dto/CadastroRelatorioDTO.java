package br.com.kentec.energy.dto;

import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.utils.Utilitarios;

public class CadastroRelatorioDTO {

	private Utilitarios util = new Utilitarios();
	
	public Long id;
	public String nome;
	public String cpf;
	public String dataNascimento;
	public String statusMatricula;
	
	public CadastroRelatorioDTO(Cadastro cadastro){
		this.id = cadastro.getId();
		this.nome = cadastro.getNome();
		this.cpf = util.formatarCpfString(cadastro.getCpf());
		this.dataNascimento = util.formataDataString(cadastro.getDataNascimento()) ;
		this.statusMatricula = cadastro.getStatusMatricula();
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

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}
	
	

}
