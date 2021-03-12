package br.com.kentec.energy.dto;

import br.com.kentec.energy.domain.ListaExercicio;

public class ListaExercicioDTO {
	
	private Long id;
	private String nome;
	private String diaTreino;
	private Long exercicioId;
	private Long fichaTecnicaId;
	private String statusLista;
	private String nivel;
	private String tipo;
	private String modalidade;
	
	public ListaExercicioDTO() {
		
	}
	
	public ListaExercicioDTO(ListaExercicio lt) {
		this.id = lt.getId();
		this.diaTreino = lt.getDiaTreino();
		this.nome = lt.getExercicio().getNome();
		this.nivel = lt.getExercicio().getNivel();
		this.tipo = lt.getExercicio().getTipo();
		this.modalidade = lt.getExercicio().getModalidade();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiaTreino() {
		return diaTreino;
	}

	public void setDiaTreino(String diaTreino) {
		this.diaTreino = diaTreino;
	}

	public Long getExercicioId() {
		return exercicioId;
	}

	public void setExercicioId(Long exercicioId) {
		this.exercicioId = exercicioId;
	}

	public Long getFichaTecnicaId() {
		return fichaTecnicaId;
	}

	public void setFichaTecnicaId(Long fichaTecnicaId) {
		this.fichaTecnicaId = fichaTecnicaId;
	}

	public String getStatusLista() {
		return statusLista;
	}

	public void setStatusLista(String statusLista) {
		this.statusLista = statusLista;
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

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String toString() {
		return "ListaExercicioDTO [id=" + id + ", nome=" + nome + ", diaTreino=" + diaTreino + ", exercicioId="
				+ exercicioId + ", fichaTecnicaId=" + fichaTecnicaId + ", statusLista=" + statusLista + ", nivel="
				+ nivel + ", tipo=" + tipo + ", modalidade=" + modalidade + "]";
	}
	
	
}
