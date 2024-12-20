package br.com.badcompany.financiencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.badcompany.financiencia.model.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	Project findByInternalCode(String code);
}
