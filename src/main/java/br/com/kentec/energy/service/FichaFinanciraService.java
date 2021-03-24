package br.com.kentec.energy.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.domain.FichaFinanceira;
import br.com.kentec.energy.domain.Parcelas;
import br.com.kentec.energy.dto.FichaFinanceiraDTO;
import br.com.kentec.energy.dto.ParcelaDTO;
import br.com.kentec.energy.repository.CadastroRepository;
import br.com.kentec.energy.repository.FichaFinanceiraRepository;
import br.com.kentec.energy.repository.ParcelaRepository;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class FichaFinanciraService {
	
	@Autowired
	private FichaFinanceiraRepository ffr;
	
	@Autowired
	private CadastroRepository cr;
	
	@Autowired
	private ParcelaRepository pr;
	
	public Iterable<FichaFinanceira> findAll(){
		return ffr.findAll();
	}
	
	public Page<FichaFinanceira> listarFichaFinanceira(Integer page, Integer size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return ffr.findAll(pageRequest);
	}
	
	public List<ParcelaDTO> findByFichaFinanceiraParcela(Long fichaFinanceira) {
		return pr.findByFichaFinanceiraParcela(fichaFinanceira).stream().map(ParcelaDTO::new).collect(Collectors.toList());
	}
	
	public List<ParcelaDTO> findByRelPeriodoStatusPagamentoAluno(Long alunoId, String dataInicial, String dataFinal, String statusParcela){
		return pr.findByRelPeriodoStatusPagamentoAluno(alunoId, dataInicial, dataFinal, statusParcela).stream().map(ParcelaDTO::new).collect(Collectors.toList());
	}
	
	public List<ParcelaDTO> findByRelPeriodoStatusPagamento(String dataInicial, String dataFinal, String statusParcela){
		return pr.findByRelPeriodoStatusPagamento(dataInicial, dataFinal, statusParcela).stream().map(ParcelaDTO::new).collect(Collectors.toList());
	}
	
	public List<ParcelaDTO> findByRelPeriodoStatusPagamentoTipo(String dataInicial, String dataFinal, String tipoPagamento){
		return pr.findByRelPeriodoStatusPagamentoTipo(dataInicial, dataFinal, tipoPagamento).stream().map(ParcelaDTO::new).collect(Collectors.toList());
	}
	
	public Optional<FichaFinanceiraDTO> findById(Long fichaFinanceiraId) {
		return ffr.findById(fichaFinanceiraId).map(FichaFinanceiraDTO::new);
	}
	
	public Optional<FichaFinanceiraDTO> findByAlunoId(Long alunoId) {
		return ffr.findByAlunoId(alunoId).map(FichaFinanceiraDTO::new);
	}
	
	public List<FichaFinanceiraDTO> findByFichaFinancira(){
		return ffr.findByFichaFinanceira().stream().map(FichaFinanceiraDTO::new).collect(Collectors.toList());
	}
	
	public void create(FichaFinanceiraDTO fichaFinanceira) {
		
		Optional<Cadastro> cad =  cr.findById(fichaFinanceira.getAlunoId());
		
		FichaFinanceira ff = new FichaFinanceira();
		
		ff.setCadastro(cad.get());
		ff.setDataGeracao(fichaFinanceira.getDataGeracao());
		ff.setDiaVencimento(fichaFinanceira.getDiaVencimento());
		ff.setValorMensal(fichaFinanceira.getValorMensal());
		ff.setStatusFichaFinanceira(fichaFinanceira.getStatusFichaFinanceira());
		
		ffr.save(ff);
	}
	
	public void update(FichaFinanceiraDTO fichaFinanceira) {
		
		Optional<FichaFinanceira> ff = ffr.findById(fichaFinanceira.getFichaFinanceiraId());
		
		if(ff.isPresent()) {
			ff.get().setDataGeracao(fichaFinanceira.getDataGeracao());
			ff.get().setDiaVencimento(fichaFinanceira.getDiaVencimento());
			ff.get().setValorMensal(fichaFinanceira.getValorMensal());
			ff.get().setStatusFichaFinanceira(fichaFinanceira.getStatusFichaFinanceira());
			
			ffr.save(ff.get());
		}
	}
	
	public void createParcela(ParcelaDTO parcela) {
		Optional<FichaFinanceira> ff = ffr.findById(parcela.getFichaFinanceira());
		
		Parcelas p = new Parcelas();
		
		p.setDataPagamento(parcela.getDataPagamento());
		p.setDesconto(parcela.getDesconto());
		p.setJuro(parcela.getJuro());
		p.setValor(parcela.getValor());
		p.setValorTotal(parcela.getValorTotal());
		p.setTipoPagamento(parcela.getTipoPagamento());
		p.setStatusParcela(parcela.getStatusParcela());
		p.setObservacao(parcela.getObservacao());
		p.setFichaFinanceira(ff.get());
		
		pr.save(p);
	}
	
	public void updateParcela(ParcelaDTO parcela) {
		Optional<Parcelas> p = pr.findById(parcela.getId());
		
		if(p.isPresent()) {
			p.get().setDataPagamento(parcela.getDataPagamento());
			p.get().setDesconto(parcela.getDesconto());
			p.get().setJuro(parcela.getJuro());
			p.get().setValor(parcela.getValor());
			p.get().setValorTotal(parcela.getValorTotal());
			p.get().setTipoPagamento(parcela.getTipoPagamento());
			p.get().setStatusParcela(parcela.getStatusParcela());
			p.get().setObservacao(parcela.getObservacao());
			
			pr.save(p.get());
		}
	}	
	
	public void delete(Long id) {
		Optional<Parcelas> p = pr.findById(id);
		
		if(p.isPresent()) {
			pr.deleteById(id);
		}
	}
	
	public String ParcelaListReports() {
		
		List<ParcelaDTO> parc = pr.findAll().stream().map(ParcelaDTO::new).collect(Collectors.toList());
		
		String nome = parc.get(0).getNome();
		String cpf = parc.get(0).getCpf();
		
		try {
			String reportPath = "C:\\reports";
			String destPath = "C:\\relatorios";
			
			JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\mensalidade.jrxml");
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(parc);
			
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("Criado por:", "KENTEC - Soluções em Informática");
			parameters.put("aluno", nome);
			parameters.put("cpf", cpf);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
			
			String nomeArquivo = "\\Parcelas-Aluno-"+nome.substring(0,10)+"-"+LocalDateTime.now().toString().replace(":", " ")+".pdf";
			JasperExportManager.exportReportToPdfFile(jasperPrint, destPath + nomeArquivo);
			System.out.println("Gerado");
			
			return "Report successfully generated @path= "+destPath;
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
