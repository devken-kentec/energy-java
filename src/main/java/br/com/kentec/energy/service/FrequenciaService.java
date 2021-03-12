package br.com.kentec.energy.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.domain.Frequencia;
import br.com.kentec.energy.dto.FrequenciaDTO;
import br.com.kentec.energy.repository.CadastroRepository;
import br.com.kentec.energy.repository.FrequenciaRepository;

@Service
public class FrequenciaService {
	
	@Autowired
	private FrequenciaRepository fr;
	
	@Autowired
	private CadastroRepository cr;
	
	public void create(FrequenciaDTO frequencia) {
		
		Optional<Cadastro> c = cr.findById(frequencia.getAlunoId());
		
		if(c.isPresent()) {
			Optional<Frequencia> ff = fr.findByDataCadastro(LocalDate.now().toString(), frequencia.getAlunoId());
			
			Frequencia f = new Frequencia();
			
			if(ff.isPresent()) {
				f.setDiaSemana(frequencia.getDiaSemana());
				f.setDataMes(LocalDate.now().toString());
				f.setHoraDia(frequencia.getHoraDia());
				f.setStatusFrequencia("Saida");
				f.setCadastro(c.get());
				
				fr.save(f);
			} else if(ff.isEmpty()) {
				f.setDiaSemana(frequencia.getDiaSemana());
				f.setDataMes(LocalDate.now().toString());
				f.setHoraDia(frequencia.getHoraDia());
				f.setStatusFrequencia("Entrada");
				f.setCadastro(c.get());
				
				fr.save(f);
			}
		}
	}

	public List<Frequencia> listarFrequenciaAluno(Long alunoId, String dataInicial, String dataFinal) {
		return fr.listarFrequenciaAluno(alunoId, dataInicial, dataFinal);
	}
}
