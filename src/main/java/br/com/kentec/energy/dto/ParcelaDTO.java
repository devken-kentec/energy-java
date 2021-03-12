package br.com.kentec.energy.dto;

import java.math.BigDecimal;

import br.com.kentec.energy.domain.Parcelas;

public class ParcelaDTO {
	
	private Long id;
	private String dataPagamento;
	private BigDecimal valor;
	private BigDecimal juro;
	private BigDecimal desconto;
	private BigDecimal valorTotal;
	private String tipoPagamento;
	private String statusParcela;
	private String observacao;
	private Long fichaFinanceira;
	private Integer diaVencimento;
	private BigDecimal valorMensal;
	private String nome;
	private String cpf;
	private String login;
	private String statusFichaFinanceira;
	
	public ParcelaDTO() {
		
	}
	
	public ParcelaDTO(Parcelas p) {
		this.id = p.getId();
		this.dataPagamento = p.getDataPagamento();
		this.valor = p.getValor();
		this.juro = p.getJuro();
		this.desconto = p.getDesconto();
		this.valorTotal = p.getValorTotal();
		this.tipoPagamento = p.getTipoPagamento();
		this.statusParcela = p.getStatusParcela();
		this.observacao = p.getObservacao();
		this.fichaFinanceira = p.getFichaFinanceira().getId();
		this.diaVencimento = p.getFichaFinanceira().getDiaVencimento();
		this.valorMensal = p.getFichaFinanceira().getValorMensal();
		this.nome = p.getFichaFinanceira().getCadastro().getNome();
		this.cpf = p.getFichaFinanceira().getCadastro().getCpf();
		this.login = p.getFichaFinanceira().getCadastro().getLogin();
		this.statusFichaFinanceira = p.getFichaFinanceira().getStatusFichaFinanceira();
		
		
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

	public Long getFichaFinanceira() {
		return fichaFinanceira;
	}

	public void setFichaFinanceira(Long fichaFinanceira) {
		this.fichaFinanceira = fichaFinanceira;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getStatusFichaFinanceira() {
		return statusFichaFinanceira;
	}

	public void setStatusFichaFinanceira(String statusFichaFinanceira) {
		this.statusFichaFinanceira = statusFichaFinanceira;
	}
	
}
