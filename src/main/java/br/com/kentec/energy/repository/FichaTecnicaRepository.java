package br.com.kentec.energy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.FichaTecnica;

@Repository
public interface FichaTecnicaRepository extends JpaRepository<FichaTecnica, Long>{
	
	@Query("SELECT f FROM FichaTecnica f "
			+ "JOIN f.cadastro c "
			+ "WHERE UPPER(c.nome) LIKE UPPER(:nome) ")
	public Iterable<FichaTecnica> findByNome(@Param("nome") String nome);
	
	@Query("SELECT f FROM FichaTecnica f "
			+ "JOIN f.cadastro c "
			+ "WHERE c.id = :id AND f.statusFichaTecnica = 'Ativo' ")
	public Optional<FichaTecnica> findByFichaTecnicaAluno(@Param("id") Long id);
}
