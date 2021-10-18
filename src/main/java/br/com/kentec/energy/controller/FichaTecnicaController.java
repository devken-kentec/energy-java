package br.com.kentec.energy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.energy.domain.FichaTecnica;
import br.com.kentec.energy.dto.FichaTecnicaDTO;
import br.com.kentec.energy.service.FichaTecnicaService;

@RestController
@RequestMapping("/energy/api/fichaTecnica")
public class FichaTecnicaController {

	@Autowired
	private FichaTecnicaService fts;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<FichaTecnica>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(fts.findById(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<Iterable<FichaTecnica>> findAll(){
		return ResponseEntity.ok(fts.findAll());
	}
	
	@GetMapping("/fichaAluno/{id}")
	public Optional<FichaTecnicaDTO> findByFichaTecnicaAluno(@PathVariable("id") Long id){
		return fts.findByFichaTecnicaAluno(id);
	}
	
	@GetMapping("/fichaTecnicaPage")
	public Page<FichaTecnica> fichaTecnicaPaginada(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return fts.listarFichaTecnica(page, size);
	}
	
	@GetMapping("/filtrar")
	public ResponseEntity<Iterable<FichaTecnica>> findByNome(
				@RequestParam(value ="nome", required = false, defaultValue="") String nome){
		return ResponseEntity.ok(fts.findByNome(nome));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody FichaTecnicaDTO fichaTecnicaDTO) {
		fts.create(fichaTecnicaDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody FichaTecnicaDTO fichaTecnicaDTO) {
		fts.update(fichaTecnicaDTO);
	}
}
