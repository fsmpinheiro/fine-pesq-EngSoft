package br.com.badcompany.financiencia.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.badcompany.financiencia.model.Researcher;

@Repository
public interface ResearcherRepository extends JpaRepository<Researcher, Long> {
	Researcher findByUsername(String username);
}
