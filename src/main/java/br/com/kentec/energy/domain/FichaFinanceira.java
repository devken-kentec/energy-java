package br.com.kentec.energy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ficha_financeira")
@SuppressWarnings("serial")
public class FichaFinanceira implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="data_geracao", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataGeracao;
	
	@Column(name="dia_vencimento", nullable = true, length = 11)
	private Integer diaVencimento;
	
	@Column(name="valor_mensal", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorMensal;
	
	@Column(name="status_ff", nullable = true, length = 10)
	private String statusFichaFinanceira;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno", nullable = true)
	private Cadastro cadastro = new Cadastro();
	
	public FichaFinanceira() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(String dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public BigDecimal getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(BigDecimal valorMensal) {
		this.valorMensal = valorMensal;
	}

	public String getStatusFichaFinanceira() {
		return statusFichaFinanceira;
	}

	public void setStatusFichaFinanceira(String statusFichaFinanceira) {
		this.statusFichaFinanceira = statusFichaFinanceira;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
}
