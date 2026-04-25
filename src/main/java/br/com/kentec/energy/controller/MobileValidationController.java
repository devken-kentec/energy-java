package br.com.kentec.energy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.dto.UserMobileDTO;
import br.com.kentec.energy.service.CadastroService;

@RestController
@RequestMapping("/energy/api/mobile")
public class MobileValidationController {
	
	@Autowired
	private CadastroService cs;
	
	@PostMapping("/logar")
	public Optional<Cadastro> loginMobile(@RequestBody UserMobileDTO user){
		System.out.println("Teste API mobile True " + user);
		return cs.findByLoginMoblie(user);
	}
	
}
