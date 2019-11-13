package br.com.badcompany.financiencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.badcompany.financiencia.model.DateSendProject;

@Repository
public interface DateProjectSendRepository extends JpaRepository<DateSendProject, Long> {
	DateSendProject findByProjectSubmitedId(Long id);
}
