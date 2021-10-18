package br.com.kentec.energy.controller;

import java.util.List;
import java.util.Optional;

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
import br.com.kentec.energy.domain.FichaFinanceira;
import br.com.kentec.energy.dto.FichaFinanceiraDTO;
import br.com.kentec.energy.dto.ParcelaDTO;
import br.com.kentec.energy.service.FichaFinanciraService;

@RestController
@RequestMapping("/energy/api/fichaFinanceira")
public class FichaFinanceiraController {
	
	@Autowired
	private FichaFinanciraService ffs;
	
	@GetMapping()
	private ResponseEntity<Iterable<FichaFinanceira>> findAll(){
		return ResponseEntity.ok(ffs.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<FichaFinanceiraDTO>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(ffs.findById(id));
	}
	
	@GetMapping("/diaVencimento/{alunoId}")
	public ResponseEntity<Optional<FichaFinanceiraDTO>> findByAlunoId(@PathVariable("alunoId") Long alunoId){
		return ResponseEntity.ok(ffs.findByAlunoId(alunoId));
	}
	
	@GetMapping("/fichaFinanceiraPage")
	public Page<FichaFinanceira> fichaFinanceiraPaginada(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return ffs.listarFichaFinanceira(page, size);
	}
	
	@GetMapping("parcela/{fichaFinanceira}")
	public ResponseEntity<List<ParcelaDTO>> findByFichaFinanceiraParcela(@PathVariable("fichaFinanceira") Long fichaFinanceira){
		return ResponseEntity.ok(ffs.findByFichaFinanceiraParcela(fichaFinanceira));
	}

	
	@GetMapping("/buscar/aluno")
	public ResponseEntity<List<ParcelaDTO>> findByRelPeriodoStatusPagamentoAluno(
			@RequestParam(value ="alunoId", required = false, defaultValue="") Long alunoId,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="statusParcela", required = false, defaultValue="") String statusParcela){
		
		return ResponseEntity.ok(ffs.findByRelPeriodoStatusPagamentoAluno(alunoId ,  dataInicial ,  dataFinal  ,  statusParcela ));
	}
	
	@GetMapping("/buscar/periodo")
	public ResponseEntity<List<ParcelaDTO>> findByRelPeriodoStatusPagamento(
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="statusParcela", required = false, defaultValue="") String statusParcela){
		
		return ResponseEntity.ok(ffs.findByRelPeriodoStatusPagamento(dataInicial ,  dataFinal  ,  statusParcela ));
	}
	
	@GetMapping("/buscar/tipo")
	public ResponseEntity<List<ParcelaDTO>> findByRelPeriodoStatusPagamentoTipo(
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="tipoPagamento", required = false, defaultValue="") String tipoPagamento){
		
		return ResponseEntity.ok(ffs.findByRelPeriodoStatusPagamentoTipo(dataInicial ,  dataFinal  ,  tipoPagamento ));
	}
	
	@GetMapping("/filtrar")
	public ResponseEntity<Iterable<FichaFinanceiraDTO>> findByNome(
						@RequestParam(value ="nome", required = false, defaultValue="") String nome){
		return ResponseEntity.ok(ffs.findByNome(nome));
	}
	
	@GetMapping("/listar")
	private ResponseEntity<List<FichaFinanceiraDTO>> findByFichaFinanceira(){
		return ResponseEntity.ok(ffs.findByFichaFinancira());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody FichaFinanceiraDTO fichaFinanceira) {
		ffs.create(fichaFinanceira);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody FichaFinanceiraDTO fichaFinanceira) {
		ffs.update(fichaFinanceira);
	}
	
	@PostMapping("/parcela")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ParcelaDTO parcela) {
		ffs.createParcela(parcela);
	}
	
	@PutMapping("/parcela")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody ParcelaDTO parcela) {
		ffs.updateParcela(parcela);
	}
	
	@DeleteMapping("/parcela/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		ffs.delete(id);
	}
	
/*	@GetMapping("/relparc/{id}")
	public String printParcela(@PathVariable("id") Long id) {
		String msg = ffs.ParcelaListReports();
		System.out.println(msg);
		return msg;
	}*/
}
