package br.com.badcompany.financiencia.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.badcompany.financiencia.model.AbstractDomainPerson;
import br.com.badcompany.financiencia.model.Role;
import br.com.badcompany.financiencia.model.entities.Accessor;
import br.com.badcompany.financiencia.model.entities.Researcher;
import br.com.badcompany.financiencia.repository.AccessorRepository;
import br.com.badcompany.financiencia.repository.ResearcherRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ResearcherRepository rRepo;
	@Autowired
	private AccessorRepository aRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Accessor a = aRepo.findByUsername(username);
		if (a != null) {
			return new org.springframework.security.core.userdetails.User(a.getUsername(), a.getPassword(), true, true,
					true, true, customGetAuthorities(a));
		}
		Researcher r = rRepo.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(r.getUsername(), r.getPassword(), true, true,
				true, true, customGetAuthorities(r));
	}

	private Set<GrantedAuthority> customGetAuthorities(AbstractDomainPerson p) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : p.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return grantedAuthorities;
	}
}
