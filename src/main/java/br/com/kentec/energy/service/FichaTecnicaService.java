package br.com.kentec.energy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.domain.FichaTecnica;
import br.com.kentec.energy.dto.FichaTecnicaDTO;
import br.com.kentec.energy.repository.CadastroRepository;
import br.com.kentec.energy.repository.FichaTecnicaRepository;

@Service
public class FichaTecnicaService {
	
	@Autowired
	private FichaTecnicaRepository ftr;
	
	@Autowired
	private CadastroRepository cr;
	
	public Optional<FichaTecnica> findById(Long id){
		return ftr.findById(id);
	}
	
	public Iterable<FichaTecnica> findAll(){
		return ftr.findAll();
	}
	
	public Iterable<FichaTecnica> findByNome(String nome){
		return ftr.findByNome("%" + nome + "%");
	}
	
	public Optional<FichaTecnicaDTO> findByFichaTecnicaAluno(Long id){
		return ftr.findByFichaTecnicaAluno(id).map(FichaTecnicaDTO::new);
	}
	
	public void create(FichaTecnicaDTO fichaTecnicaDTO) {
			
		Cadastro cad = cr.findById(fichaTecnicaDTO.getAlunoId()).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cadastro não encontrado!"));
		
		FichaTecnica fichaTecnica = new FichaTecnica();
		
		fichaTecnica.setDataAvaliacao(fichaTecnicaDTO.getDataAvaliacao());
		fichaTecnica.setPeso(fichaTecnicaDTO.getPeso());
		fichaTecnica.setHoraEntrada(fichaTecnicaDTO.getHoraEntrada());
		fichaTecnica.setHoraSaida(fichaTecnicaDTO.getHoraSaida());
		fichaTecnica.setSegunda(fichaTecnicaDTO.getSegunda());
		fichaTecnica.setTerca(fichaTecnicaDTO.getTerca());
		fichaTecnica.setQuarta(fichaTecnicaDTO.getQuarta());
		fichaTecnica.setQuinta(fichaTecnicaDTO.getQuinta());
		fichaTecnica.setSexta(fichaTecnicaDTO.getSexta());
		fichaTecnica.setSabado(fichaTecnicaDTO.getSabado());
		fichaTecnica.setDescricao(fichaTecnicaDTO.getDescricao());
		fichaTecnica.setStatusFichaTecnica(fichaTecnicaDTO.getStatusFichaTecnica());
		fichaTecnica.setCadastro(cad);
		
		ftr.save(fichaTecnica);
	}

	public void update(FichaTecnicaDTO fichaTecnicaDTO) {
		FichaTecnica fichaTecnica = ftr.findById(fichaTecnicaDTO.getId()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ficha Tecnica não encontrada!"));
		
		fichaTecnica.setDataAvaliacao(fichaTecnicaDTO.getDataAvaliacao());
		fichaTecnica.setPeso(fichaTecnicaDTO.getPeso());
		fichaTecnica.setHoraEntrada(fichaTecnicaDTO.getHoraEntrada());
		fichaTecnica.setHoraSaida(fichaTecnicaDTO.getHoraSaida());
		fichaTecnica.setSegunda(fichaTecnicaDTO.getSegunda());
		fichaTecnica.setTerca(fichaTecnicaDTO.getTerca());
		fichaTecnica.setQuarta(fichaTecnicaDTO.getQuarta());
		fichaTecnica.setQuinta(fichaTecnicaDTO.getQuinta());
		fichaTecnica.setSexta(fichaTecnicaDTO.getSexta());
		fichaTecnica.setSabado(fichaTecnicaDTO.getSabado());
		fichaTecnica.setDescricao(fichaTecnicaDTO.getDescricao());
		fichaTecnica.setStatusFichaTecnica(fichaTecnicaDTO.getStatusFichaTecnica());
		
		ftr.save(fichaTecnica);
	}
}
