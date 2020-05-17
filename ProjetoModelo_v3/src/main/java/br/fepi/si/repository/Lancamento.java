package br.fepi.si.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Lancamento implements Serializable{

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	
	public Lancamento(EntityManager em) {
		this.em = em;
	}
	
	public List<Lancamento> todos(){
		TypedQuery<Lancamento> query = 
				em.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();		
	}

}
