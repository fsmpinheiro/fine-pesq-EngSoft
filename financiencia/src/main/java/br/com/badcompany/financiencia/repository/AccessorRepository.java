package br.com.badcompany.financiencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.badcompany.financiencia.model.Accessor;

public interface AccessorRepository extends JpaRepository<Accessor, Long> {
	
	Accessor findByUsername(String username);
}
