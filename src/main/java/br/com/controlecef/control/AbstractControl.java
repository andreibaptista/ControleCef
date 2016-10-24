package br.com.controlecef.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

import br.com.controlecef.control.util.MessagesUtil;
import br.com.controlecef.model.Usuario;
import br.com.controlecef.service.GenericService;

public abstract class AbstractControl<E, ID extends Serializable, S extends GenericService<E, ID>> {

	@Inject
	private MessagesUtil messagesUtil;

	private E bean;

	private S service;

	public abstract String principal();

	public abstract void novo();

	public void alterar() {
		bean = load();
	}

	protected abstract E load();

	public void salvar() {
		try {
			getService().save(getBean());
			novo();
			messagesUtil.addInfoMessage("message."
					+ bean.getClass().getSimpleName().toLowerCase()
					+ ".save.success");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	public void remover() {
		try {
			getService().remove(getBean());
			novo();
			messagesUtil.addInfoMessage("message."
					+ bean.getClass().getSimpleName().toLowerCase()
					+ ".remove.success");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	
	/*public void ativar() {
		try {
			getService().activate(getBean());
			messagesUtil.addInfoMessage("message."
					+ bean.getClass().getSimpleName().toLowerCase()
					+ ".activate.success");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
*/
	/*public void desativar() {
		try {
			getService().disactivate(getBean());
			messagesUtil.addInfoMessage("message."
					+ bean.getClass().getSimpleName().toLowerCase()
					+ ".disactivate.success");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}*/

	public Usuario getCurrentUser() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return (Usuario) session.getAttribute("currentUser");
	}

	public List<E> getResultList() {
		return service.findAll();
	}

	public E getBean() {
		return bean;
	}

	public void setBean(E bean) {
		this.bean = bean;
	}

	public S getService() {
		return service;
	}

	public void setService(S service) {
		this.service = service;
	}

	public MessagesUtil getMessagesUtil() {
		return messagesUtil;
	}

	public void setMessagesUtil(MessagesUtil messagesUtil) {
		this.messagesUtil = messagesUtil;
	}
}
