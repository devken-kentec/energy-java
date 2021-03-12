package br.com.kentec.energy.dto;

import java.math.BigDecimal;

import br.com.kentec.energy.domain.FichaTecnica;

public class FichaTecnicaDTO {
	
	private Long id;
	private String dataAvaliacao;
	private BigDecimal peso;
	private String horaEntrada;
	private String horaSaida;
	private String segunda;
	private String terca;
	private String quarta;
	private String quinta;
	private String sexta;
	private String sabado;
	private String descricao;
	private String statusFichaTecnica;
	private Long AlunoId;
	private String aluno;
	
	public FichaTecnicaDTO() {
		
	}
	
	public FichaTecnicaDTO(FichaTecnica fichaTecnica) {
		this.id = fichaTecnica.getId();
		this.AlunoId = fichaTecnica.getCadastro().getId();
		this.aluno = fichaTecnica.getCadastro().getNome();
		this.dataAvaliacao = fichaTecnica.getDataAvaliacao();
		this.statusFichaTecnica = fichaTecnica.getStatusFichaTecnica();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(String dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getSegunda() {
		return segunda;
	}

	public void setSegunda(String segunda) {
		this.segunda = segunda;
	}

	public String getTerca() {
		return terca;
	}

	public void setTerca(String terca) {
		this.terca = terca;
	}

	public String getQuarta() {
		return quarta;
	}

	public void setQuarta(String quarta) {
		this.quarta = quarta;
	}

	public String getQuinta() {
		return quinta;
	}

	public void setQuinta(String quinta) {
		this.quinta = quinta;
	}

	public String getSexta() {
		return sexta;
	}

	public void setSexta(String sexta) {
		this.sexta = sexta;
	}

	public String getSabado() {
		return sabado;
	}

	public void setSabado(String sabado) {
		this.sabado = sabado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatusFichaTecnica() {
		return statusFichaTecnica;
	}

	public void setStatusFichaTecnica(String statusFichaTecnica) {
		this.statusFichaTecnica = statusFichaTecnica;
	}

	public Long getAlunoId() {
		return AlunoId;
	}

	public void setAlunoId(Long alunoId) {
		AlunoId = alunoId;
	}
	
	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "FichaTecnicaDTO [id=" + id + ", dataAvaliacao=" + dataAvaliacao + ", peso=" + peso + ", horaEntrada="
				+ horaEntrada + ", horaSaida=" + horaSaida + ", segunda=" + segunda + ", terca=" + terca + ", quarta="
				+ quarta + ", quinta=" + quinta + ", sexta=" + sexta + ", sabado=" + sabado + ", descricao=" + descricao
				+ ", statusFichaTecnica=" + statusFichaTecnica + ", AlunoId=" + AlunoId + "]";
	}
	
	
}
