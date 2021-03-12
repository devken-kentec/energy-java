package br.com.kentec.energy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.Frequencia;

@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, Long>{

	@Query("SELECT f FROM Frequencia f "
			+ "JOIN f.cadastro c "
			+ "WHERE f.dataMes = :dataMes AND c.id = :cadastroId ")
	public Optional<Frequencia> findByDataCadastro(
			@Param("dataMes") String dataMes,
			@Param("cadastroId") Long cadastroId); 
	
	@Query("SELECT f FROM Frequencia f "
			+ "JOIN f.cadastro c "
			+ "WHERE c.id = :alunoId AND f.dataMes between :dataInicial AND :dataFinal ")
	public List<Frequencia> listarFrequenciaAluno(@Param("alunoId") Long alunoId,
												  @Param("dataInicial") String dataInicial,
												  @Param("dataFinal") String dataFinal);
}
