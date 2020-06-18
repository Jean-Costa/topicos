package br.fepi.si.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.si.model.Piscina;

public class Piscinas implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public Piscinas(EntityManager em) {
		this.em = em;
	}

	public Piscina porRegistro(Long id) {
		return em.find(Piscina.class, id);
	}

	public void remover(Piscina piscina) {
		this.em.remove(piscina);
	}

	public void adicionar(Piscina piscina) {
		this.em.persist(piscina);
	}

	public void guardar(Piscina piscina) {
		System.out.println(piscina.getId() + " " + piscina.getVolume());
		this.em.merge(piscina);
	}

	public List<Piscina> obterPiscinas() {
		TypedQuery<Piscina> query = em.createQuery("FROM Piscina", Piscina.class);
		return query.getResultList();
	}

}