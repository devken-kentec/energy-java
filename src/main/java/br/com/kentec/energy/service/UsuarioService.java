package br.com.kentec.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.kentec.energy.domain.Cadastro;
import br.com.kentec.energy.repository.CadastroRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private CadastroRepository cr;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Cadastro  cadastro = cr.findByLogin(login).orElseThrow(()-> new UsernameNotFoundException("Login não encontrado")); 

		return User
				.builder()
				.username(cadastro.getLogin())
				.password(cadastro.getSenha())
				.roles(cadastro.getTipoUser())
				.build();
	}

}
