package br.com.kentec.energy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.energy.dto.ListaExercicioDTO;
import br.com.kentec.energy.service.ListaExercicioService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("energy/api/listaExercicio")
public class ListaExercicioController {	
	
	@Autowired
	private ListaExercicioService les;
	
	@GetMapping("/listar/{fichaTecnicaId}")
	public ResponseEntity<List<ListaExercicioDTO>> findByExercicioFichaTecnica(@PathVariable("fichaTecnicaId") Long fichaTecnicaId){
		return ResponseEntity.ok(les.findByExercicioFichaTecnica(fichaTecnicaId));
	}
	
	@GetMapping("/listar/{dia}/{fichaTecnicaId}")
	public ResponseEntity<List<ListaExercicioDTO>> findByExercicioDiaAluno(@PathVariable("dia") String dia, @PathVariable("fichaTecnicaId") Long fichaTecnicaId){
		return ResponseEntity.ok(les.findByExercicioDiaAluno(dia, fichaTecnicaId));
	}
	
	@GetMapping("/consulta/{dia}/{alunoId}")
	public ResponseEntity<List<ListaExercicioDTO>> findByExercicioDia(@PathVariable("dia") String dia, @PathVariable("alunoId") Long alunoId){
		return ResponseEntity.ok(les.findByExercicioDia(dia, alunoId));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ListaExercicioDTO listaExercicio) {
		les.create(listaExercicio);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable("id") Long id) {
		les.delete(id);
	}
}
