package br.com.kentec.energy.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.energy.domain.Exercicio;
import br.com.kentec.energy.domain.ExercicioImg;
import br.com.kentec.energy.dto.ExercicioImgDTO;
import br.com.kentec.energy.repository.ExercicioImgRepository;

@Service
public class ExercicioImgService {
	
	@Autowired
	private ExercicioService es;
	
	@Autowired
	private ExercicioImgRepository eir;
	
	
	public List<ExercicioImgDTO> findAllExercicioImg(Long exercicioId){
		return eir.findByExercicioId(exercicioId).stream().map(ExercicioImgDTO::new).collect(Collectors.toList());
	}
	
	public void create(ExercicioImgDTO exerImgDTO) {
			
		Optional<Exercicio> exer = es.findById(exerImgDTO.getExercicioId());
		
		if(exer.isPresent()) {
				ExercicioImg exerImg = new ExercicioImg();
				exerImg.setPosicao(exerImgDTO.getPosicao());
				exerImg.setComentario(exerImgDTO.getComentario());
				exerImg.setExercicio(exer.get());
				eir.save(exerImg);
				
		}
	}
	
	public byte[] adicionarFoto(Part arquivo, Long id) {
		
		Optional<ExercicioImg> exerImg = eir.findById(id);
		
		return exerImg.map(c -> {
			try {
				InputStream is = arquivo.getInputStream();
				byte[] bytes = new byte[(int) arquivo.getSize()];
				IOUtils.readFully(is, bytes);
				c.setImagem(bytes);
				eir.save(c);
				is.close();
				return bytes;
			} catch (IOException e) {
				return null;
			}
		}).orElse(null);
	}

	public void removeImg(Long id) {
		Optional<ExercicioImg> exerImg = eir.findById(id);
		
		if(exerImg.isPresent()) {
			eir.deleteById(id);
		}
	}
}
