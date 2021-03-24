package br.com.kentec.energy.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.service.CadastroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("energy/api/cadastro")
public class CadastroController {
	
	@Autowired
	private CadastroService cs;
	
	@GetMapping("/listar")
	public ResponseEntity<Iterable<Cadastro>> findAll(){
		return ResponseEntity.ok(cs.findAll());
	}
	@GetMapping("/logar")
	public ResponseEntity<Cadastro> findByLoginSenha(@RequestParam("login") Long login, @RequestParam("senha") String senha )  {
		return ResponseEntity.ok(cs.findByLoginSenha(login, senha));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cadastro>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(cs.findById(id));
	}
	
	@GetMapping("/cadastroPage")
	public Page<Cadastro> cadastroPaginado(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return cs.listarCadastro(page, size);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Cadastro cadastro) {
		cs.create(cadastro);
	}
	
	@PutMapping("/senha")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSenha(@RequestBody Cadastro cadastro) {
		cs.updateSenha(cadastro);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Cadastro cadastro) {
		cs.update(cadastro);
	}
	
	@GetMapping("/status/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void mudarStatusCadastro(@PathVariable("id") Long id) {
		cs.mudarStatusCadastro(id);
	}
	
	@GetMapping("/relcadList")
	public String printCadastroList() {
		String msg = cs.cadastroListReports();
		System.out.println(msg);
		return msg;
	}
	
	@GetMapping("/relcad/{id}")
	public String printCadastro(@PathVariable("id") Long id) {
		String msg = cs.cadastroReports(id);
		System.out.println(msg);
		return msg;
	}
	
}

	
