package br.com.badcompany.financiencia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.badcompany.financiencia.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//
//		UserDetails user1 = User.withUsername("ac").password("{noop}123").roles("ACCESSOR").build();
//		UserDetails user2 = User.withUsername("re").password("{noop}123").roles("RESEARCHER").build();
//
//		Collection<UserDetails> users = Arrays.asList(user1, user2);
//
//		return new InMemoryUserDetailsManager(users);
//	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
			.csrf().disable()
			.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.GET, "/v1/index/free").permitAll()
			.antMatchers(HttpMethod.POST, "/v1/researcher/register").permitAll()
			.anyRequest().authenticated().and()
			
						// filtra requisições de login
						.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
				                UsernamePasswordAuthenticationFilter.class)
						
						// filtra outras requisições para verificar a presença do JWT no header
						.addFilterBefore(new JWTAuthenticationFilter(),
				                UsernamePasswordAuthenticationFilter.class);

	}
}
