package br.com.kentec.energy.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="frequencia")
@SuppressWarnings("serial")
public class Frequencia implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true, length = 11)
	private Long id;
	
	@Column(name="dia_semana", nullable = true, length = 10)
	private String diaSemana;
	
	@Column(name="data_mes", nullable = true, length = 10)
	private String dataMes;
	
	@Column(name="hora_dia", nullable = true, length = 10)
	private String horaDia;
	
	@Column(name="status_frequencia", nullable = true, length = 10)
	private String statusFrequencia;
	
	@ManyToOne
	@JoinColumn(name = "cadastro_id", nullable = true)
	private Cadastro cadastro = new Cadastro();
	
	public  Frequencia() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getDataMes() {
		return dataMes;
	}

	public void setDataMes(String dataMes) {
		this.dataMes = dataMes;
	}

	public String getHoraDia() {
		return horaDia;
	}

	public void setHoraDia(String horaDia) {
		this.horaDia = horaDia;
	}

	public String getStatusFrequencia() {
		return statusFrequencia;
	}

	public void setStatusFrequencia(String statusFrequencia) {
		this.statusFrequencia = statusFrequencia;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
}
