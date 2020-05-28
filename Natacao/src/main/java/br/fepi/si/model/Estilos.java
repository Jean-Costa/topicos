package br.fepi.si.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estilos")
public class Estilos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estilos_natacao", nullable = false)
	private Estilo estilo;

	public Estilos() {
		super();
		
	}
	
	public String verificaEstiloNadador (Nadador competidor){
		return "";
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	
	

}
