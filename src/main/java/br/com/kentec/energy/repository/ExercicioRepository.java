package br.com.kentec.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{
	
}
