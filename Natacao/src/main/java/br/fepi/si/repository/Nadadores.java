package br.fepi.si.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.si.model.Nadador;

public class Nadadores implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public Nadadores(EntityManager em) {
		this.em = em;
	}

	public Nadador porRegistro(Long id) {
		return em.find(Nadador.class, id);
	}

	public void remover(Nadador nadador) {
		this.em.remove(nadador);
	}

	public void adicionar(Nadador nadador) {
		this.em.persist(nadador);
	}

	public void guardar(Nadador nadador) {
		System.out.println(nadador.getId() + " " + nadador.getNome());
		this.em.merge(nadador);
	}

	public List<Nadador> obterNadadores() {
		TypedQuery<Nadador> query = em.createQuery("FROM Nadador", Nadador.class);
		return query.getResultList();
	}

}