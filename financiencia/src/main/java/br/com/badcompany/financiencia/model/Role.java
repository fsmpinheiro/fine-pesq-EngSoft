package br.com.badcompany.financiencia.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import br.com.badcompany.financiencia.model.entities.Accessor;
import br.com.badcompany.financiencia.model.entities.Researcher;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;

	@ManyToMany(mappedBy = "roles")
	private Set<Researcher> researchers;

	@ManyToMany(mappedBy = "roles")
	private Set<Accessor> accessors;

	public Role(String name) {
		this.name = name;
	}

	public Role() {

	}

	@Override
	public String getAuthority() {
		return this.name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(Set<Researcher> researchers) {
		this.researchers = researchers;
	}

	public Set<Accessor> getAccessors() {
		return accessors;
	}

	public void setAccessors(Set<Accessor> accessors) {
		this.accessors = accessors;
	}
}
