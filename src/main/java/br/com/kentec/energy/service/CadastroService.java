package br.com.kentec.energy.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.dto.CadastroRelatorioDTO;
import br.com.kentec.energy.repository.CadastroRepository;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class CadastroService {
	
	Cadastro cadastroValido;
	
	@Autowired
	private CadastroRepository cr;
	
	
	public Iterable<Cadastro> findAll(){
		return cr.findAll();
	}
	
	public Optional<Cadastro> findById(Long id){
		return cr.findById(id);
	}
	
	public Cadastro findByLoginSenha(Long login, String senha) {
		
		Cadastro cadastro = cr.findByLoginSenha(login, senha);
		
		if(cadastro.getId().equals(login) && cadastro.getSenha().equals(senha)) {
			
			this.cadastroValido = cadastro;
		}
		
		return this.cadastroValido;
	}
	
	
	public Page<Cadastro> listarCadastro(Integer page, Integer size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return cr.findAll(pageRequest);
	}
	
	public void create(Cadastro cadastro) {
		cr.save(cadastro);
	}
	
	public void update(Cadastro cadastro) {
		Optional<Cadastro> c = cr.findById(cadastro.getId());
		
		if(c.isPresent()) {
			cr.save(cadastro);	
		}
	}
	
	public void updateSenha(Cadastro cadastro) {
		Optional<Cadastro> c = cr.findById(cadastro.getId());
		
		if(c.isPresent()) {
			c.get().setTipoUser(cadastro.getTipoUser());
			c.get().setStatusMatricula(cadastro.getStatusMatricula());
			c.get().setLogin(cadastro.getLogin());
			c.get().setSenha(cadastro.getSenha());
			
			cr.save(c.get());
		}
	}
	
	public void mudarStatusCadastro(Long id) {
		Optional<Cadastro> c = cr.findById(id);
		
		if(c.isPresent()) {
			c.get().setStatusMatricula("Inativo");
			cr.save(c.get());
		}
	}
	
	

	public String cadastroListReports() {
		
		List<CadastroRelatorioDTO> cad = cr.findAll().stream().map(CadastroRelatorioDTO::new).collect(Collectors.toList());
		
		try {
			
			String reportPath = "C:\\reports";
			String destPath = "C:\\relatorios";
			
			JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\cadDetail.jrxml");
			
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(cad);
			
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "KENTEC - Soluções em Informática");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, destPath + "\\cadastroList.pdf");

			System.out.println("Done");
			
			return "Report successfully generated @path= " + destPath;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String cadastroReports(Long id) {
		
		List<CadastroRelatorioDTO> cad = cr.findByIdc(id).stream().map(CadastroRelatorioDTO::new).collect(Collectors.toList());
		
		try {
			
			String reportPath = "C:\\reports";
			String destPath = "C:\\relatorios";
			
			JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\cadAluno.jrxml");
			
					
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(cad);
			
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "KENTEC - Soluções em Informática");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, destPath + "\\cadastro.pdf");

			System.out.println("Done");
			
			return "Report successfully generated @path= " + destPath;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	

}
