package br.com.controlecef.control;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.controlecef.control.util.MessagesUtil;
import br.com.controlecef.control.util.NavigationConstant;
import br.com.controlecef.model.Usuario;
import br.com.controlecef.service.AutenticacaoService;

@Named
@RequestScoped
public class LoginControl {

	public static final Integer modulo = 1;

	@Inject
	private MessagesUtil messagesUitl;

	private String nomeUsuario;

	private String senha;

	private Usuario currentUser;
	
	@EJB
	private AutenticacaoService autenticacaoService;

	public String login() {
		try {
			/*currentUser = autenticacaoService.autenticar(nomeUsuario, senha,
					modulo);*/
			
			//getSession().invalidate();

			HttpSession session = getSession();
			session.setAttribute("currentUser", new Usuario());
			
			return NavigationConstant.URL_SEGURANCA_INDEX;
		} catch (Exception e) {
			messagesUitl.addErrorMessage("message.longin.InvalidUsernameOrPasswordException");
		} finally {
			senha = null;
		}
		return null;
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return NavigationConstant.URL_LOGIN;
	}
	
	public HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	public boolean isLoggedIn() {
		return getCurrentUser() != null;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getCurrentUser() {
		return (Usuario) getSession().getAttribute("currentUser");
	}
}
