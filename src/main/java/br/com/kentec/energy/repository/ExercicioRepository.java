package br.com.kentec.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{
	
	@Query("SELECT e FROM Exercicio e WHERE UPPER(e.nome) LIKE UPPER(:nome) ")
	public Iterable<Exercicio> findByNome(@Param("nome") String nome);
}
