package br.fepi.si.service;

import java.io.Serializable;

import br.fepi.si.model.Piscina;
import br.fepi.si.repository.Piscinas;

public class CadastroPiscinas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Piscinas piscinas;

	public CadastroPiscinas(Piscinas piscinas) {
		this.piscinas = piscinas;
	}

	public void salvar(Piscina piscina) throws NegocioException {
		if (piscina.getId() == null)
			throw new NegocioException("A piscina precisa de um ID.");
		this.piscinas.guardar(piscina);
	}

	public void excluir(Piscina piscina) throws NegocioException {
		piscina = this.piscinas.porRegistro(piscina.getId());

		this.piscinas.remover(piscina);
	}
}