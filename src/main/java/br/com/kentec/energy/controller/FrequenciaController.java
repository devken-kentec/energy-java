package br.com.kentec.energy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.energy.domain.Frequencia;
import br.com.kentec.energy.dto.FrequenciaDTO;
import br.com.kentec.energy.service.FrequenciaService;

@RestController
@RequestMapping("/energy/api/frequencia")
public class FrequenciaController {
	
	@Autowired
	private FrequenciaService fs;
	
	@GetMapping("/frequenciaAluno/{alunoId}/{dataInicial}/{dataFinal}")
	private List<Frequencia> listarFrequenciaAluno(@PathVariable("alunoId") Long alunoId,
			                                       @PathVariable("dataInicial") String dataInicial,
			                                       @PathVariable("dataFinal") String dataFinal){
		return fs.listarFrequenciaAluno(alunoId, dataInicial, dataFinal);
	} 
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody FrequenciaDTO frequencia) {
		fs.create(frequencia);
	}
}
