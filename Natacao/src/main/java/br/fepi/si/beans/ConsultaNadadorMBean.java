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

import br.fepi.si.model.Nadador;
import br.fepi.si.repository.Nadadores;
import br.fepi.si.service.CadastroNadadores;
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaNadadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	private List<Nadador> nadadores = new ArrayList<>();
	private Nadador nadadorSelecionado = new Nadador();

	public ConsultaNadadorMBean() {
	}

	public void consultar() {
		EntityManager em = JpaUtil.getEntityManager();
		this.setNadadores(new Nadadores(em).obterNadadores());
		em.close();
	}

	public void excluir() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		CadastroNadadores cadastroPessoas = new CadastroNadadores(new Nadadores(em));

		FacesContext context = FacesContext.getCurrentInstance();

		try {
			et.begin();
			cadastroPessoas.excluir(nadadorSelecionado);
			context.addMessage(null,
					new FacesMessage("Nadador #" + nadadorSelecionado.getId() + " removido com sucesso."));
			et.commit();
			this.consultar();
		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
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

	public Nadador getNadadorSelecionado() {
		return nadadorSelecionado;
	}

	public void setNadadorSelecionado(Nadador nadadorSelecionado) {
		this.nadadorSelecionado = nadadorSelecionado;
	}
}
