package br.com.kentec.energy.dto;

import java.util.Arrays;

import br.com.kentec.energy.domain.ExercicioImg;

public class ExercicioImgDTO {
	
	private Long id;
	private Integer posicao;
	private String comentario;
	private byte[] imagem;
	private Long exercicioId;
	
	
	public ExercicioImgDTO() {
		
	}
	
	public ExercicioImgDTO(ExercicioImg exerImg) {
		this.id = exerImg.getId();
		this.posicao = exerImg.getPosicao();
		this.comentario = exerImg.getComentario();
		this.imagem = exerImg.getImagem();
		this.exercicioId = exerImg.getExercicio().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Long getExercicioId() {
		return exercicioId;
	}

	public void setExercicioId(Long exercicioId) {
		this.exercicioId = exercicioId;
	}

	@Override
	public String toString() {
		return "ExercicioImgDTO [id=" + id + ", posicao=" + posicao + ", comentario=" + comentario + ", imagem="
				+ Arrays.toString(imagem) + ", exercicioId=" + exercicioId + "]";
	}
	
}
