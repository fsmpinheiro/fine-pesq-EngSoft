package br.com.badcompany.financiencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.badcompany.financiencia.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
