package br.com.kentec.energy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.Parcelas;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcelas, Long> {
	
	@Query("SELECT p FROM Parcelas p "
			+ " JOIN p.fichaFinanceira ff "
			+ " WHERE ff.id = :fichaFinanceira ")
	public List<Parcelas> findByFichaFinanceiraParcela(
			@Param("fichaFinanceira") Long fichaFinanceira);
	
	@Query(nativeQuery=true, value="SELECT * FROM parcelas AS p " 
			+ "JOIN ficha_financeira AS ff "
			+ "ON p.ficha_financeira_id = ff.id " 
			+ "JOIN cadastro AS cad " 
			+ "ON ff.id_aluno = cad.id "
			+ "WHERE cad.id = :alunoId AND "
			+ "p.data_pagamento BETWEEN (:dataInicial) AND (:dataFinal) "
			+ "AND p.status_parcela = :statusParcela " )
	public List<Parcelas> findByRelPeriodoStatusPagamentoAluno(@Param("alunoId") Long alunoId,
														  @Param("dataInicial") String dataInicial,
														  @Param("dataFinal") String dataFinal,
														  @Param("statusParcela") String statusParcela);
	
	@Query(nativeQuery=true, value="SELECT * FROM parcelas AS p " 
			+ "JOIN ficha_financeira AS ff "
			+ "ON p.ficha_financeira_id = ff.id " 
			+ "JOIN cadastro AS cad " 
			+ "ON ff.id_aluno = cad.id "
			+ "WHERE p.data_pagamento BETWEEN (:dataInicial) AND (:dataFinal) "
			+ "AND p.status_parcela = :statusParcela " )
	public List<Parcelas> findByRelPeriodoStatusPagamento(@Param("dataInicial") String dataInicial,
														  @Param("dataFinal") String dataFinal,
														  @Param("statusParcela") String statusParcela);
	
	@Query(nativeQuery=true, value="SELECT * FROM parcelas AS p " 
			+ "JOIN ficha_financeira AS ff "
			+ "ON p.ficha_financeira_id = ff.id " 
			+ "JOIN cadastro AS cad " 
			+ "ON ff.id_aluno = cad.id "
			+ "WHERE p.data_pagamento BETWEEN (:dataInicial) AND (:dataFinal) "
			+ "AND p.tipo_pagamento = :tipoPagamento "
			+ "AND p.status_parcela = 'Pago' " )
	public List<Parcelas> findByRelPeriodoStatusPagamentoTipo(@Param("dataInicial") String dataInicial,
														  @Param("dataFinal") String dataFinal,
														  @Param("tipoPagamento") String tipoPagamento);
}
