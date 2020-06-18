package br.fepi.si.service;

import java.io.Serializable;

import br.fepi.si.model.Nadador;
import br.fepi.si.repository.Nadadores;

public class CadastroNadadores implements Serializable {

	private static final long serialVersionUID = 1L;

	private Nadadores nadadores;

	public CadastroNadadores(Nadadores nadadores) {
		this.nadadores = nadadores;
	}

	public void salvar(Nadador nadador) throws NegocioException {
		if (nadador.getId() == null)
			throw new NegocioException("O Nadador precisa de um ID.");
		this.nadadores.guardar(nadador);
	}

	public void excluir(Nadador nadador) throws NegocioException {
		nadador = this.nadadores.porRegistro(nadador.getId());

		this.nadadores.remover(nadador);
	}
}