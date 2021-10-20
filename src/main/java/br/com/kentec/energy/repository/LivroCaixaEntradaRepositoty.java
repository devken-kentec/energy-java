package br.com.kentec.energy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.LivroCaixaEntrada;

@Repository
public interface LivroCaixaEntradaRepositoty extends JpaRepository<LivroCaixaEntrada, Long> {
	
	@Query("SELECT l FROM LivroCaixaEntrada l "
			+ "WHERE l.dataPagamento BETWEEN :dataInicial AND :dataFinal "
			+ "AND UPPER(l.tipoPagamento) LIKE UPPER(:tipoPagamento) ")
	public List<LivroCaixaEntrada> buscarPorDia(
									@Param("dataInicial") LocalDate dataInicial,
									@Param("dataFinal")  LocalDate dataFinal,
									@Param("tipoPagamento") String tipoPagamento);
}
