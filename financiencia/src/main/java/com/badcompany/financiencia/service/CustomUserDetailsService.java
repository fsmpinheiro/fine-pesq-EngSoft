package com.badcompany.financiencia.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.badcompany.financiencia.model.Role;
import com.badcompany.financiencia.model.Usuario;
import com.badcompany.financiencia.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UsuarioRepository uRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = Optional.ofNullable(uRepo.findByLogin(username))
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		
		 Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : u.getRoles()) {
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNome()));
	        }
		return new org.springframework.security.core.userdetails.User(
	            u.getLogin(),
	            u.getSenha(),
	            true,
	            true,
	            true,
	            true,
	            grantedAuthorities);
	}

}
