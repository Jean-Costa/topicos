package br.fepi.si.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.fepi.si.model.Nadador;
import br.fepi.si.repository.Nadadores;
import br.fepi.si.util.JpaUtil;

@FacesConverter(forClass = Nadador.class)
public class NadadorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Nadador retorno = null;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			if (value != null && !"".equals(value)) {
				Nadadores nadadores = new Nadadores(em);
				retorno = nadadores.porRegistro(new Long(value));
			}
			return retorno;
		} finally {
			em.close();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Nadador nadador = (Nadador) value;
			
			return nadador.getId() == null ? null : nadador.getId().toString();
		}
		return null;
	}

}