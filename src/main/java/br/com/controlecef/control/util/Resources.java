package br.com.controlecef.control.util;

import java.util.ResourceBundle;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class Resources {

	@Inject
	private FacesContext facesContext;

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		if (ctx == null)
			throw new ContextNotActiveException("FacesContext is not active");
		return ctx;
	}

	public boolean isActive() {
		return (facesContext != null) && (facesContext.getCurrentPhaseId() != null);
	}

	@Produces
	@Messages
	public ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle("/messages", facesContext.getViewRoot().getLocale());
	}
}
