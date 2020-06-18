package br.fepi.si.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.fepi.si.model.Nadador;
import br.fepi.si.model.Piscina;
import br.fepi.si.repository.Nadadores;
import br.fepi.si.util.JpaUtil;

@FacesConverter(forClass = Piscina.class)
public class PiscinaConverter implements Converter {

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
			Piscina piscina = (Piscina) value;

			return piscina.getId() == null ? null : piscina.getId().toString();
		}
		return null;
	}

}