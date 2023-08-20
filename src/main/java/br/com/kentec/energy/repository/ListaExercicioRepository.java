 package br.com.kentec.energy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.energy.domain.ListaExercicio;

@Repository
public interface ListaExercicioRepository extends JpaRepository<ListaExercicio, Long> {
	
	@Query("SELECT le FROM ListaExercicio le "
			+ "JOIN le.fichaTecnica ft "
			+ "WHERE ft.id = :fichaTecnicaId")
	public List<ListaExercicio> findByExercicioFichaTecnica(@Param("fichaTecnicaId") Long fichaTecnicaId);
	
	@Query("SELECT le FROM ListaExercicio le "
			+ "JOIN le.fichaTecnica ft "
			+ "WHERE UPPER(le.diaTreino) = UPPER(:dia) AND ft.id = :fichaTecnicaId AND ft.statusFichaTecnica = 'Ativo' ")
	public List<ListaExercicio> findByExercicioDiaAluno(
					@Param("dia") String dia,
					@Param("fichaTecnicaId") Long fichaTecnicaId);
	
	@Query("SELECT le FROM ListaExercicio le "
			+ "JOIN le.fichaTecnica ft "
			+ "JOIN ft.cadastro c "
			+ "WHERE UPPER(le.diaTreino) = UPPER(:dia) AND c.id = :alunoId AND ft.statusFichaTecnica = 'Ativo' ")
	public List<ListaExercicio> findByExercicioDia(
					@Param("dia") String dia,
					@Param("alunoId") Long alunoId);

}
