package br.com.kentec.energy.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="lista_exercicio")
@SuppressWarnings("serial")
public class ListaExercicio implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true, length = 11)
	private Long id;
	
	@Column(name="dia_treino", nullable = true, length = 15)
	private String diaTreino;
	
	@ManyToOne
	@JoinColumn(name = "id_ficha_tecnica", nullable = true)
	private FichaTecnica fichaTecnica = new FichaTecnica();
	
	@ManyToOne
	@JoinColumn(name = "id_exercicio", nullable = true)
	private Exercicio exercicio = new Exercicio();
	
	@Column(name="status_list", nullable = true, length = 10)
	private String statusLista;
	
	public ListaExercicio() {
		
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

	public FichaTecnica getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(FichaTecnica fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public String getStatusLista() {
		return statusLista;
	}

	public void setStatusLista(String statusLista) {
		this.statusLista = statusLista;
	}

}
