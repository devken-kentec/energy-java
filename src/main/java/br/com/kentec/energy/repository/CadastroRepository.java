package br.com.kentec.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.kentec.energy.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	
	@Query("SELECT c FROM Cadastro c WHERE c.id = :login AND c.senha = :senha AND c.statusMatricula = 'Ativo' ")
	public Cadastro findByLoginSenha(@Param("login") Long login, @Param("senha") String senha);
	
	@Query("SELECT c FROM Cadastro c WHERE UPPER(c.nome) LIKE UPPER(:nome) ")
	public Iterable<Cadastro> findByNome(@Param("nome") String nome);
}
