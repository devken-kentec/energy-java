package br.com.kentec.energy.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="parcelas")
@SuppressWarnings("serial")
public class Parcelas implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true, length = 11)
	private Long id;
	
	@Column(name="data_pagamento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataPagamento;
	
	@Column(name="valor", nullable = true, precision = 10, scale = 2)
	private BigDecimal valor;
	
	@Column(name="juro", nullable = true, precision = 10, scale = 2)
	private BigDecimal juro;
	
	@Column(name="desconto", nullable = true, precision = 10, scale = 2)
	private BigDecimal desconto;
	
	@Column(name="valor_total", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorTotal;
	
	@Column(name="tipo_pagamento", nullable = true, length = 15)
	private String tipoPagamento;
	
	@Column(name="status_parcela", nullable = true, length = 15)
	private String statusParcela;
	
	@Column(name="observacao", nullable = true, length = 64)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "ficha_financeira_id", nullable = true)
	private FichaFinanceira fichaFinanceira = new FichaFinanceira(); 
	
	public Parcelas() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getJuro() {
		return juro;
	}

	public void setJuro(BigDecimal juro) {
		this.juro = juro;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getStatusParcela() {
		return statusParcela;
	}

	public void setStatusParcela(String statusParcela) {
		this.statusParcela = statusParcela;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public FichaFinanceira getFichaFinanceira() {
		return fichaFinanceira;
	}

	public void setFichaFinanceira(FichaFinanceira fichaFinanceira) {
		this.fichaFinanceira = fichaFinanceira;
	}
	
}
