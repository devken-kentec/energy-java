package br.com.kentec.energy.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name="exercicio_img")
@SuppressWarnings("serial")
public class ExercicioImg implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="posicao", nullable = true, length = 2)
	private Integer posicao;
	
	@Column(name="comentario", nullable = true, length = 100)
	private String comentario;
	
	@Column(name="imagem", nullable = true)
	@Lob
	public byte[] imagem;
	
	@ManyToOne
	@JoinColumn(name = "id_exercicio", nullable = false)
	private Exercicio exercicio = new Exercicio();

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

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	@Override
	public String toString() {
		return "ExercicioImg [id=" + id + ", posicao=" + posicao + ", comentario=" + comentario + ", imagem="
				+ Arrays.toString(imagem) + ", exercicio=" + exercicio + "]";
	}
	
	
}
