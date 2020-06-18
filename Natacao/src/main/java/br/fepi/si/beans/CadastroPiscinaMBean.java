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

import br.fepi.si.model.Piscina;
import br.fepi.si.repository.Piscinas;
import br.fepi.si.service.CadastroPiscinas;
import br.fepi.si.service.NegocioException;
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroPiscinaMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Piscina piscina= new Piscina();

	private List<Piscina> piscinas = new ArrayList<>();

	public void preparaCadastrados() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			this.setPiscinas(new Piscinas(em).obterPiscinas());
		} finally {
			em.close();
		}
	}

	public Piscina getPiscina() {
		return piscina;
	}

	public void setPiscina(Piscina piscina) {
		this.piscina = piscina;
	}

	public List<Piscina> getPiscinas() {
		return piscinas;
	}

	public void setPiscinas(List<Piscina> piscinas) {
		this.piscinas = piscinas;
	}

	public void salvar() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			et.begin();
			CadastroPiscinas cadastroPiscinas = new CadastroPiscinas(new Piscinas(em));
			cadastroPiscinas.salvar(this.piscina);
			this.piscina = new Piscina();
			context.addMessage(null, new FacesMessage("Piscina incluida com sucesso!"));
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

}
