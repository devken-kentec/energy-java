package br.com.kentec.energy.dto;

import br.com.kentec.energy.domain.Frequencia;

public class FrequenciaDTO {
	
	private Long id;	
	private String diaSemana;
	private String dataMes;
	private String horaDia;
	private String statusFrequencia;
	private Long AlunoId;
	private String nome;
	
	public FrequenciaDTO() {
		
	}
	
	public FrequenciaDTO(Frequencia freq) {
		this.id = freq.getId();
		this.diaSemana = freq.getDiaSemana();
		this.dataMes = freq.getDataMes();
		this.horaDia = freq.getHoraDia();
		this.statusFrequencia = freq.getStatusFrequencia();
		this.AlunoId = freq.getCadastro().getId();
		this.nome = freq.getCadastro().getNome();
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

	public Long getAlunoId() {
		return AlunoId;
	}

	public void setAlunoId(Long alunoId) {
		AlunoId = alunoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "FrequenciaDTO [id=" + id + ", diaSemana=" + diaSemana + ", dataMes=" + dataMes + ", horaDia=" + horaDia
				+ ", statusFrequencia=" + statusFrequencia + ", AlunoId=" + AlunoId + ", nome=" + nome + "]";
	}
}
