package br.com.controlecef.control.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessagesUtil {

	@Inject
	@Messages
	private ResourceBundle msg;

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public void addFacesMessage(String componnetId, Severity severity,String msgKey, String detailKey) {
		getFacesContext().addMessage(componnetId,new FacesMessage(severity, msg.getString(msgKey), msg.getString(detailKey)));
	}

	public void addInfoMessage(String componnentId, String msgKey,String detailKey) {
		addFacesMessage(componnentId, FacesMessage.SEVERITY_INFO, msgKey,detailKey);
	}

	public void addInfoMessage(String msgKey, String detailKey) {
		addInfoMessage(null, msgKey, detailKey);
	}

	public void addInfoMessage(String msgKey) {
		addInfoMessage(msgKey, msgKey);
	}

	public void addErrorMessage(String componnentId, String msgKey,	String detailKey) {
		addFacesMessage(componnentId, FacesMessage.SEVERITY_ERROR, msgKey,detailKey);
	}

	public void addErrorMessage(String msgKey, String detailKey) {
		addErrorMessage(null, msgKey, detailKey);
	}

	public void addErrorMessage(String msgKey) {
		addErrorMessage(msgKey, msgKey);
	}

	public void addWarnMessage(String componnentId, String msgKey,String detailKey) {
		addFacesMessage(componnentId, FacesMessage.SEVERITY_WARN, msgKey,detailKey);
	}

	public void addWarnMessage(String msgKey, String detailKey) {
		addWarnMessage(null, msgKey, detailKey);
	}

	public void addWarnMessage(String msgKey) {
		addWarnMessage(msgKey, msgKey);
	}

	public ResourceBundle getMsg() {
		return msg;
	}
}
