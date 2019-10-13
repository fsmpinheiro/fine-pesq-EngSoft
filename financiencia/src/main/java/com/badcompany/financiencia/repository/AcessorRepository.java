package com.badcompany.financiencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.badcompany.financiencia.model.Acessor;

@Repository
public interface AcessorRepository  extends JpaRepository<Acessor, Long>{
}
