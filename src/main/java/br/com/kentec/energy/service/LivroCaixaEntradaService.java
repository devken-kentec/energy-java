package br.com.kentec.energy.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.energy.domain.LivroCaixaEntrada;
import br.com.kentec.energy.repository.LivroCaixaEntradaRepositoty;

@Service
public class LivroCaixaEntradaService {
	
	
	@Autowired
	private LivroCaixaEntradaRepositoty lcer;
	
	public List<LivroCaixaEntrada> buscarLivro(){
		return lcer.findAll();
	}
	
	public List<LivroCaixaEntrada> buscarPorDia(LocalDate dataInicial, LocalDate dataFinal, String tipoPagamento){
		return lcer.buscarPorDia(dataInicial, dataFinal, "%"+tipoPagamento+"%");
	}
	
	public void create(LivroCaixaEntrada livroCaixaEntrada) {
		livroCaixaEntrada.setDataPagamento(LocalDate.now());
		lcer.save(livroCaixaEntrada);
	}

}
