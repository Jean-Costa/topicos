package br.fepi.si.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

@Entity
@Table(name = "piscina")
public class Piscina implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private double volume;
	private double medida;
	private double temperatura;
	private int numRaias;

	private List<Nadador> competidor;

	public Piscina(double volume, double medida, double temperatura, int numRaias) {
		super();
		this.volume = volume;
		this.medida = medida;
		this.temperatura = temperatura;
		this.numRaias = numRaias;

		competidor = new ArrayList<>();
	}

	public Piscina() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@DecimalMin("30")
	@Column(name = "volume_piscina", precision = 10, scale = 2, nullable = false)
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@DecimalMin("30")
	@Column(name = "medida_piscina", precision = 10, scale = 2, nullable = false)
	public double getMedida() {
		return medida;
	}

	public void setMedida(double medida) {
		this.medida = medida;
	}

	@DecimalMin("23")
	@Column(name = "temperatura_piscina", precision = 10, scale = 2, nullable = false)
	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	@DecimalMin("8")
	@Column(name = "raias_piscina", precision = 10, scale = 2, nullable = false)
	public int getNumRaias() {
		return numRaias;
	}

	public void setNumRaias(int numRaias) {
		this.numRaias = numRaias;
	}

	@OneToMany
	@JoinColumn(name = "competidor")
	public List<Nadador> getCompetidor() {
		return competidor;
	}

	public void setCompetidor(Nadador comp) {
		this.competidor.add(comp);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competidor == null) ? 0 : competidor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(medida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numRaias;
		temp = Double.doubleToLongBits(temperatura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Piscina other = (Piscina) obj;
		if (competidor == null) {
			if (other.competidor != null)
				return false;
		} else if (!competidor.equals(other.competidor))
			return false;
		if (Double.doubleToLongBits(medida) != Double.doubleToLongBits(other.medida))
			return false;
		if (numRaias != other.numRaias)
			return false;
		if (Double.doubleToLongBits(temperatura) != Double.doubleToLongBits(other.temperatura))
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}

}
