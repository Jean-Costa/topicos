package br.fepi.si.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "nadador") 
public class Nadador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sexo;
	private String pais;
	private int idade;
	private int numMedalhas;
	
	private List<Estilo> estiloNatacao;
	private Classificacao competidor;
	
	public Nadador(String nome, String sexo, String pais, int idade, int numMedalhas) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.pais = pais;
		this.idade = idade;
		this.numMedalhas = numMedalhas;
		
		estiloNatacao = new ArrayList<>();
	}

	public Nadador() {
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

	@NotEmpty
	@Size (max = 50)
	@Column(name = "nome",length = 50, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "sexo",length = 9, nullable = false)
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "pais",length = 20, nullable = false)
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	@NotNull
	@DecimalMin ("18")
	@Column(name = "idade", precision = 10, scale = 2, nullable = false)
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@DecimalMin ("0")
	@Column(name = "medalhas", precision = 10, scale = 2)
	public int getNumMedalhas() {
		return numMedalhas;
	}
	public void setNumMedalhas(int numMedalhas) {
		this.numMedalhas = numMedalhas;
	}

	
	@OneToMany
    @JoinColumn(name = "estilo_id")
	public List<Estilo> getEstiloNatacao() {
		return estiloNatacao;
	}
	public void setEstiloNatacao(Estilo estN) {
		this.estiloNatacao.add(estN);
	}


	@ManyToOne
    @JoinColumn(name = "categoria_id")
	public Classificacao getCompetidor() {
		return competidor;
	}
	public void setCompetidor(Classificacao competidor) {
		this.competidor = competidor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competidor == null) ? 0 : competidor.hashCode());
		result = prime * result + ((estiloNatacao == null) ? 0 : estiloNatacao.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numMedalhas;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Nadador other = (Nadador) obj;
		if (competidor == null) {
			if (other.competidor != null)
				return false;
		} else if (!competidor.equals(other.competidor))
			return false;
		if (estiloNatacao == null) {
			if (other.estiloNatacao != null)
				return false;
		} else if (!estiloNatacao.equals(other.estiloNatacao))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numMedalhas != other.numMedalhas)
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	
	
	
}
