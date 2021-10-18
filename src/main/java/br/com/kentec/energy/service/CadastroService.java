package br.com.kentec.energy.service;

//import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.kentec.energy.domain.Cadastro;
//import br.com.kentec.energy.dto.CadastroRelatorioDTO;
import br.com.kentec.energy.repository.CadastroRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class CadastroService {
	
	private Cadastro cadastroValido;
	
	@Autowired
	private CadastroRepository cr;
	
	public Long startServer() {
		return cr.count();
	}
	
	public Iterable<Cadastro> findAll(){
		return cr.findAll();
	}
	
	public Iterable<Cadastro> findByNome(String nome){
		return cr.findByNome("%" + nome + "%");
	}
	
	public Optional<Cadastro> findById(Long id){
		return cr.findById(id);
	}
	
	public Optional<Cadastro> findByLogin(String login){
		return cr.findByLogin(login);
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
	
	//Alterar para encoder
	public void create(Cadastro cadastro) {
		
		Optional<Cadastro> cad = cr.findByLogin(cadastro.getLogin());
		
		if(cad.isPresent()) {
			cr.exists(null);
		} else {
			cadastro.setSenha(passwordEncoder(cadastro.getSenha()));
			cr.save(cadastro);
		}
	}
	
	public void update(Cadastro cadastro) {
		
		Optional<Cadastro> c = cr.findById(cadastro.getId());
		
		if(c.isPresent()) {
			c.get().setSenha(passwordEncoder(cadastro.getSenha()));
			cr.save(cadastro);
		}
	}
	
	public void updateSenha(Cadastro cadastro) {
		Optional<Cadastro> c = cr.findById(cadastro.getId());
		
		if(c.isPresent()) {
			c.get().setTipoUser(cadastro.getTipoUser());
			c.get().setStatusMatricula(cadastro.getStatusMatricula());
			c.get().setLogin(cadastro.getLogin());
			c.get().setSenha(passwordEncoder(cadastro.getSenha()));
			
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
	
	public String passwordEncoder(String senha) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(senha); 
	}
	

/*	public String cadastroListReports() {
		
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
	}*/
	
/*	public String cadastroReports(Long id) {
		
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
		
	}*/
	
	public byte[] adicionarFoto(Part arquivo, Long id) {
		
		Optional<Cadastro> cad = cr.findById(id);
		
		return cad.map(c -> {
			try {
				InputStream is = arquivo.getInputStream();
				byte[] bytes = new byte[(int) arquivo.getSize()];
				IOUtils.readFully(is, bytes);
				c.setFoto(bytes);
				cr.save(c);
				is.close();
				return bytes;
			} catch (IOException e) {
				return null;
			}
		}).orElse(null);
	}
	
	
	public String buscarCep(String cep) {
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            json = jsonSb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        return json;
    }

}
