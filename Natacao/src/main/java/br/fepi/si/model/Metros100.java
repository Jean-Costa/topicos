package br.fepi.si.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Metros100 extends Olimpiadas {
	
	private static final long serialVersionUID = 1L;
	
	public Metros100(String tipoDeProva, Date data, String pais, String tempoprova) {
		super(tipoDeProva, data, pais, tempoprova);
		// TODO Auto-generated constructor stub
	}

}
