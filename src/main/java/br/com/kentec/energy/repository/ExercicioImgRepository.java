package br.com.kentec.energy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.ExercicioImg;

@Repository
public interface ExercicioImgRepository extends JpaRepository<ExercicioImg, Long>{
	
	
	@Query("SELECT ei FROM ExercicioImg ei "
			+ "JOIN ei.exercicio e "
			+ "WHERE e.id = :exercicioId "
			+ "ORDER BY ei.posicao ASC ")
	public List<ExercicioImg> findByExercicioId(@Param("exercicioId") Long exercicioId);
}
