package br.com.badcompany.financiencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.badcompany.financiencia.model.DateProjectEval;

@Repository
public interface DateProjectEvalRepository extends JpaRepository<DateProjectEval, Long>{
	DateProjectEval findByProjectId(Long id);
}
