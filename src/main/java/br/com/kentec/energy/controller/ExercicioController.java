package br.com.kentec.energy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.energy.domain.Exercicio;
import br.com.kentec.energy.service.ExercicioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("energy/api/exercicio")
public class ExercicioController {
	
	@Autowired
	private ExercicioService es;
	
	@GetMapping("/listar")
	public ResponseEntity<Iterable<Exercicio>> findAll(){
		return ResponseEntity.ok(es.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Exercicio>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(es.findById(id));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Exercicio exercicio) {
		es.create(exercicio);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Exercicio exercicio) {
		es.update(exercicio);
	}
	
	@GetMapping("/status/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void mudarStatusCadastro(@PathVariable("id") Long id) {
		es.mudarStatusExercicio(id);
	}
}
