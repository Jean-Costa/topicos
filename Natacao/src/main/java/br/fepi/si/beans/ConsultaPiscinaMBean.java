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
import br.fepi.si.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaPiscinaMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	private List<Piscina> piscinas = new ArrayList<>();
	private Piscina piscinaSelecionada = new Piscina();

	public ConsultaPiscinaMBean() {
	}

	public void consultar() {
		EntityManager em = JpaUtil.getEntityManager();
		this.setPiscinas(new Piscinas(em).obterPiscinas());
		em.close();
	}

	public void excluir() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		CadastroPiscinas cadastroPiscinas = new CadastroPiscinas(new Piscinas(em));

		FacesContext context = FacesContext.getCurrentInstance();

		try {
			et.begin();
			cadastroPiscinas.excluir(piscinaSelecionada);
			context.addMessage(null,
					new FacesMessage("Piscina #" + piscinaSelecionada.getId() + " removido com sucesso."));
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

	public List<Piscina> getPiscinas() {
		return piscinas;
	}

	public void setPiscinas(List<Piscina> piscinas) {
		this.piscinas = piscinas;
	}

	public Piscina getPiscinaSelecionada() {
		return piscinaSelecionada;
	}

	public void setPiscinaSelecionada(Piscina piscinaSelecionada) {
		this.piscinaSelecionada = piscinaSelecionada;
	}
}
