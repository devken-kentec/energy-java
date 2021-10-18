package br.com.kentec.energy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
		
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/energy/api/cadastro/count").permitAll()
				.antMatchers(
						"/energy/api/cadastro/**",
						"/energy/api/exercicio/**", 
						"/energy/api/fichaFinanceira/**",
						"/energy/api/fichaTecnica/**",
						"/energy/api/frequencia/**",
						"/energy/api/listaExercicio/**").authenticated()
				.anyRequest().denyAll();
	}
}
