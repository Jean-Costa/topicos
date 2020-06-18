package br.fepi.si.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.si.model.Estilo;
import br.fepi.si.model.Nadador;
import br.fepi.si.repository.Nadadores;
import br.fepi.si.service.CadastroNadadores;
import br.fepi.si.service.NegocioException;
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroNadadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Nadador nadador = new Nadador();

	private List<Nadador> nadadores = new ArrayList<>();

	public void preparaCadastrados() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			this.setNadadores(new Nadadores(em).obterNadadores());
		} finally {
			em.close();
		}
	}

	public void salvar() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			et.begin();
			CadastroNadadores cadastroNadadores = new CadastroNadadores(new Nadadores(em));
			cadastroNadadores.salvar(this.nadador);
			this.nadador = new Nadador();
			context.addMessage(null, new FacesMessage("Nadador incluido com sucesso!"));
			et.commit();
		} catch (NegocioException e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		} finally {
			em.close();
		}
	}

	public List<Nadador> getNadadores() {
		return nadadores;
	}

	public void setNadadores(List<Nadador> nadadores) {
		this.nadadores = nadadores;
	}

	public Nadador getNadador() {
		return nadador;
	}

	public void setNadador(Nadador nadador) {
		this.nadador = nadador;
	}
	
	public Estilo[] getTiposNado() {
		return Estilo.values();
	}
}
