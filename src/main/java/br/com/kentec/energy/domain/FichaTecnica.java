package br.com.kentec.energy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ficha_tecnica")
@SuppressWarnings("serial")
public class FichaTecnica implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="data_avaliacao", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataAvaliacao;
	
	@Column(name="peso", nullable = true, precision = 7, scale = 2)
	private BigDecimal peso;
	
	@Column(name="hora_entrada", nullable = true, length = 15)
	private String horaEntrada;
	
	@Column(name="hora_saida", nullable = true, length = 15)
	private String horaSaida;
	
	@Column(name="seg", nullable = true, length = 5)
	private String segunda;
	
	@Column(name="ter", nullable = true, length = 5)
	private String terca;
	
	@Column(name="qua", nullable = true, length = 5)
	private String quarta;
	
	@Column(name="qui", nullable = true, length = 5)
	private String quinta;
	
	@Column(name="sex", nullable = true, length = 5)
	private String sexta;
	
	@Column(name="sab", nullable = true, length = 5)
	private String sabado;
	
	@Column(name="descricao", nullable = true, length = 400)
	private String descricao;
	
	@Column(name="status_ft", nullable = true, length = 15)
	private String statusFichaTecnica;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno", nullable = true)
	private Cadastro cadastro = new Cadastro();
	
	public FichaTecnica() {
		
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

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
}
