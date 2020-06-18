package br.fepi.si.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "olimpiadas")
public class Olimpiadas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipoDeProva;
	private Date data;
	private String pais;
	private String tempoprova;

	private List<Classificacao> posicoes;

	public Olimpiadas(String tipoDeProva, Date data, String pais, String tempoprova) {
		super();
		this.tipoDeProva = tipoDeProva;
		this.data = data;
		this.pais = pais;
		this.tempoprova = tempoprova;

		posicoes = new ArrayList<>();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "tipo_prova")
	public String getTipoDeProva() {
		return tipoDeProva;
	}

	public void setTipoDeProva(String tipoDeProva) {
		this.tipoDeProva = tipoDeProva;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_prova", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@NotEmpty
	@Size(max = 20)
	@Column(name = "pais_olimpiadas", length = 20, nullable = false)
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Column(name = "tempo_prova", length = 20)
	public String getTempoprova() {
		return tempoprova;
	}

	public void setTempoprova(String tempoprova) {
		this.tempoprova = tempoprova;
	}

	@OneToMany
	@JoinColumn(name = "olimpiadas")
	public List<Classificacao> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(Classificacao pos) {
		this.posicoes.add(pos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((posicoes == null) ? 0 : posicoes.hashCode());
		result = prime * result + ((tempoprova == null) ? 0 : tempoprova.hashCode());
		result = prime * result + ((tipoDeProva == null) ? 0 : tipoDeProva.hashCode());
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
		Olimpiadas other = (Olimpiadas) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (posicoes == null) {
			if (other.posicoes != null)
				return false;
		} else if (!posicoes.equals(other.posicoes))
			return false;
		if (tempoprova == null) {
			if (other.tempoprova != null)
				return false;
		} else if (!tempoprova.equals(other.tempoprova))
			return false;
		if (tipoDeProva == null) {
			if (other.tipoDeProva != null)
				return false;
		} else if (!tipoDeProva.equals(other.tipoDeProva))
			return false;
		return true;
	}

}
