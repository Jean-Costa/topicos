package br.fepi.si.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "classificacao")
public class Classificacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private int numColocacao;

	private Olimpiadas prova;

	public Classificacao() {
		super();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@DecimalMin("1")
	@Column(name = "numero_colocacao", precision = 10, scale = 2, nullable = false)
	public int getNumColocacao() {
		return numColocacao;
	}

	public void setNumColocacao(int numColocacao) {
		this.numColocacao = numColocacao;
	}

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	public Olimpiadas getProva() {
		return prova;
	}

	public void setProva(Olimpiadas prova) {
		this.prova = prova;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numColocacao;
		result = prime * result + ((prova == null) ? 0 : prova.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classificacao other = (Classificacao) obj;
		if (numColocacao != other.numColocacao)
			return false;
		if (prova == null) {
			if (other.prova != null)
				return false;
		} else if (!prova.equals(other.prova))
			return false;
		return true;
	}

}
