package br.com.kentec.energy.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="exercicio")
@SuppressWarnings("serial")
public class Exercicio implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true, length = 11)
	private Long id;
	
	@Column(name="nome", nullable = true, length = 30)
	private String nome;
	
	@Column(name="nivel", nullable = true, length = 15)
	private String nivel;
	
	@Column(name="tipo", nullable = true, length = 12)
	private String tipo;
	
	@Column(name="funcao", nullable = true, length = 120)
	private String funcao;
	
	@Column(name="descricao", nullable = true, length = 500)
	private String descricao;
	
	@Column(name="imagem", nullable = true, length = 50)
	private String imagem;
	
	@Column(name="modalidade", nullable = true, length = 50)
	private String modalidade;
	
	@Column(name="status", nullable = true, length = 10)
	private String statusExercicio;
	
	public Exercicio() {
		
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

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getStatusExercicio() {
		return statusExercicio;
	}

	public void setStatusExercicio(String statusExercicio) {
		this.statusExercicio = statusExercicio;
	}
	
}
