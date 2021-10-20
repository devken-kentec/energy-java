package br.com.kentec.energy.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.energy.domain.LivroCaixaEntrada;
import br.com.kentec.energy.service.LivroCaixaEntradaService;

@RestController
@RequestMapping("/energy/api/livroCaixaEntrada")
public class LivroCaixaEntradaController {
	
	@Autowired
	private LivroCaixaEntradaService lces;
	
	@GetMapping()
	private ResponseEntity<List<LivroCaixaEntrada>> findAll(){
		return ResponseEntity.ok(lces.buscarLivro());
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<LivroCaixaEntrada>> buscarPorDia(
												@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial, 
												@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
												@RequestParam(value ="tipoPagamento", required = false, defaultValue="") String tipoPagamento)  {
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate localDateI = LocalDate.parse(dataInicial, formatter);
		  LocalDate localDateF = LocalDate.parse(dataFinal, formatter);
		return ResponseEntity.ok(lces.buscarPorDia(localDateI, localDateF, tipoPagamento));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody LivroCaixaEntrada livroCaixaEntrada) {
		lces.create(livroCaixaEntrada);
	}
	
}
