package br.com.kentec.energy.dto;

import java.math.BigDecimal;
import br.com.kentec.energy.domain.FichaFinanceira;

public class FichaFinanceiraDTO {

		private Long alunoId;
		private String nome;
		private String cpf;
		private String login;
		private Long fichaFinanceiraId;
		private String dataGeracao;
		private Integer diaVencimento;
		private BigDecimal valorMensal;
		private String statusFichaFinanceira;
		
		public FichaFinanceiraDTO() {
			
		}
		
		public FichaFinanceiraDTO(FichaFinanceira fichaFinanceira) {
			this.alunoId = fichaFinanceira.getCadastro().getId();
			this.nome = fichaFinanceira.getCadastro().getNome();
			this.cpf = fichaFinanceira.getCadastro().getCpf();
			this.login = fichaFinanceira.getCadastro().getLogin();
			this.fichaFinanceiraId = fichaFinanceira.getId();
			this.dataGeracao = fichaFinanceira.getDataGeracao();
			this.diaVencimento = fichaFinanceira.getDiaVencimento();
			this.valorMensal = fichaFinanceira.getValorMensal();
			this.statusFichaFinanceira = fichaFinanceira.getStatusFichaFinanceira();
		}

		public Long getAlunoId() {
			return alunoId;
		}

		public void setAlunoId(Long alunoId) {
			this.alunoId = alunoId;
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

		public Long getFichaFinanceiraId() {
			return fichaFinanceiraId;
		}

		public void setFichaFinanceiraId(Long fichaFinanceiraId) {
			this.fichaFinanceiraId = fichaFinanceiraId;
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

		@Override
		public String toString() {
			return "FichaFinanceiraFormDTO [alunoId=" + alunoId + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login
					+ ", fichaFinanceiraId=" + fichaFinanceiraId + ", dataGeracao=" + dataGeracao + ", diaVencimento="
					+ diaVencimento + ", valorMensal=" + valorMensal + ", statusFichaFinanceira="
					+ statusFichaFinanceira + "]";
		}

	
}
