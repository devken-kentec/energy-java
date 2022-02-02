package br.com.kentec.energy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.energy.utils.Utilitarios;

@RestController
@RequestMapping("/energy/api/cadastro")
public class IndexController {
	
	@Autowired
	private Utilitarios util;
	
	@GetMapping()
	public String get() {
		return "API Teste Energy";
	}
	
	@GetMapping("/mail")
	public void enviarEmail() {
		util.sendMail();
	}
}