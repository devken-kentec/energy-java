package br.com.kentec.energy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="livro_caixa_entrada")
@SuppressWarnings("serial")
public class LivroCaixaEntrada implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="nome", nullable = true, length = 100)
	private String nome;
	
	@Column(name="data_pagamento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataPagamento;
	
	@Column(name="tipo_pagamento", nullable = true, length = 20)
	private String tipoPagamento;
	
	@Column(name="valor_recebido", nullable = true, precision = 10, scale = 2)
	private BigDecimal valorRecebido;
	
	@Column(name="referente", nullable = true, length = 200)
	private String referente;
	
	public LivroCaixaEntrada() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public String getReferente() {
		return referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	@Override
	public String toString() {
		return "LivroCaixaEntrada [id=" + id + ", nome=" + nome + ", dataPagamento=" + dataPagamento
				+ ", tipoPagamento=" + tipoPagamento + ", valorRecebido=" + valorRecebido + ", referente=" + referente
				+ "]";
	}
}
