package br.com.kentec.energy.controller;

import java.util.Optional;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.energy.domain.Exercicio;
import br.com.kentec.energy.dto.ExercicioImgDTO;
import br.com.kentec.energy.service.ExercicioImgService;
import br.com.kentec.energy.service.ExercicioService;

@RestController
@RequestMapping("/energy/api/exercicio")
public class ExercicioController {
	
	@Autowired
	private ExercicioService es;
	
	@Autowired
	private ExercicioImgService eis;
	
	@GetMapping("/listar")
	public ResponseEntity<Iterable<Exercicio>> findAll(){
		return ResponseEntity.ok(es.findAll());
	}
	
	@GetMapping("/filtrar")
	public ResponseEntity<Iterable<Exercicio>> findByNome(
						@RequestParam(value ="nome", required = false, defaultValue="") String nome){
		return ResponseEntity.ok(es.findByNome(nome));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Exercicio>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(es.findById(id));
	}
	
	@GetMapping("/exercicioPage")
	public Page<Exercicio> exercicioPaginado(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return es.listarExercicio(page, size);
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
	
	@GetMapping("/listarexerimg/{exercicioId}")
	public ResponseEntity<Iterable<ExercicioImgDTO>> findAllExerImg(@PathVariable("exercicioId") Long exercicioId){
		return ResponseEntity.ok(eis.findAllExercicioImg(exercicioId));
	}
	
	@PostMapping("/exerimg")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ExercicioImgDTO exercicioImgDTO) {
		eis.create(exercicioImgDTO);
	}
	
	@PutMapping("/arquivo/{id}")
	public void adicionarFoto(@RequestParam("arquivo") Part arquivo, @PathVariable("id") Long id) {
		eis.adicionarFoto(arquivo, id);
	}
	
	@DeleteMapping("/removeimg/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeImg(@PathVariable("id") Long id) {
		eis.removeImg(id);
	}
}
