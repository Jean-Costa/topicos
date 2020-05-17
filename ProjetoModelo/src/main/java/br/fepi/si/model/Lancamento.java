package br.fepi.si.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable{
	
	private Long id;
	private String descricao;
	private BigDecimal valor;
	private Date dataVencimento;
	private Date dataPagamento;
	
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoLancamento tipo;
	
	public Lancamento() {
		
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;}
	public void setId(Long id) {
		this.id = id;}
	
	@Column(length = 7, nullable = false)
	public String getDescricao() {
		return descricao;}
	public void setDescricao(String descricao) {
		this.descricao = descricao;}
	
	@Column(length = 7, nullable = false)
	public BigDecimal getValor() {
		return valor;}
	public void setValor(BigDecimal valor) {
		this.valor = valor;}
	
	@Column(length = 7, nullable = false)
	public Date getDataVencimento() {
		return dataVencimento;}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;}
	
	@Column(length = 7, nullable = false)
	public Date getDataPagamento() {
		return dataPagamento;}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pessoa")
	public Pessoa getPessoa() {
		return pessoa;}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;}
	
	@Column(length = 7, nullable = false)
	public TipoLancamento getTipo() {
		return tipo;}
	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Lancamento other = (Lancamento) obj;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (tipo != other.tipo)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	

}
