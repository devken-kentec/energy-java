package br.com.kentec.energy.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.energy.domain.Exercicio;
import br.com.kentec.energy.domain.FichaTecnica;
import br.com.kentec.energy.domain.ListaExercicio;
import br.com.kentec.energy.dto.ListaExercicioDTO;
import br.com.kentec.energy.repository.ExercicioRepository;
import br.com.kentec.energy.repository.FichaTecnicaRepository;
import br.com.kentec.energy.repository.ListaExercicioRepository;

@Service
public class ListaExercicioService {
	
	@Autowired
	private ListaExercicioRepository ler;
	
	@Autowired
	private FichaTecnicaRepository ftr;
	
	@Autowired
	private ExercicioRepository er;

	public Iterable<ListaExercicio> findAll() {
		return ler.findAll();
	}
	
	public List<ListaExercicioDTO> findByExercicioFichaTecnica(Long fichaTecnicaId){
		return ler.findByExercicioFichaTecnica(fichaTecnicaId).stream().map(ListaExercicioDTO::new).collect(Collectors.toList());
	}
	
	public List<ListaExercicioDTO> findByExercicioDiaAluno(String dia, Long fichaTecnicaId){
		return ler.findByExercicioDiaAluno(dia, fichaTecnicaId).stream().map(ListaExercicioDTO::new).collect(Collectors.toList());
	}
	
	public List<ListaExercicioDTO> findByExercicioDia(String dia, Long alunoId){
		return ler.findByExercicioDia(dia, alunoId).stream().map(ListaExercicioDTO::new).collect(Collectors.toList());
	}
	
	public void create(ListaExercicioDTO listaExercicio) {
		
		FichaTecnica ft = ftr.findById(listaExercicio.getFichaTecnicaId()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ficha Tecnica não encontrado!"));
		
		Exercicio ex =  er.findById(listaExercicio.getExercicioId()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exercicio não encontrado!"));
		
		ListaExercicio le = new ListaExercicio();
		
			le.setDiaTreino(listaExercicio.getDiaTreino());
			le.setExercicio(ex);
			le.setFichaTecnica(ft);
			le.setStatusLista(listaExercicio.getStatusLista());
			
			ler.save(le);
	}
	
	public void delete(Long id) {
		Optional<ListaExercicio> lt = ler.findById(id);
		
		if(lt.isPresent()) {
			ler.deleteById(id);
		}
	}
}
