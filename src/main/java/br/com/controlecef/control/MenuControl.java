package br.com.controlecef.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.controlecef.model.Funcionalidades;
import br.com.controlecef.model.Usuario;

@ManagedBean(name = "menuControl")
@SessionScoped
public class MenuControl implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Funcionalidades> menuLateral;

	private List<Funcionalidades> menuAdministrativo;
	
	private List<Funcionalidades> listFuncionalidadesPai;

	private List<Funcionalidades> listFuncionalidadesFilho;

	public MenuControl() {
		menuLateral = new ArrayList<Funcionalidades>();
		menuAdministrativo = new ArrayList<Funcionalidades>();
	}

	@PostConstruct
	public void loadMenuControl() {		
		
		Funcionalidades f1 = new Funcionalidades();
		f1.setCdFun(1);
		f1.setNmFun("Contratos");
		f1.setDsUrl("/seg/guia/guia-principal.xhtml");
		
		menuLateral.add(f1);
		
		Funcionalidades f2 = new Funcionalidades();
		f2.setCdFun(2);
		f2.setNmFun("Empresa");
		f2.setDsUrl("/seg/guia/empresa-principal.xhtml");
		
		menuLateral.add(f2);
				
		Funcionalidades f4 = new Funcionalidades();
		f4.setCdFun(1);
		f4.setNmFun("Usuarios");
		f4.setDsUrl("/seg/usuario/usuario-principal.xhtml");
		
		menuAdministrativo.add(f4);
	}

	public List<Funcionalidades> getMenuLateral() {
		return menuLateral;
	}

	public List<Funcionalidades> getMenuAdministrativo() {
		return menuAdministrativo;
	}

	public List<Funcionalidades> getListFuncionalidadesPai() {
		return listFuncionalidadesPai;
	}

	public void setListFuncionalidadesPai(
			List<Funcionalidades> listFuncionalidadesPai) {
		this.listFuncionalidadesPai = listFuncionalidadesPai;
	}

	public List<Funcionalidades> getListFuncionalidadesFilho() {
		return listFuncionalidadesFilho;
	}

	public void setListFuncionalidadesFilho(
			List<Funcionalidades> listFuncionalidadesFilho) {
		this.listFuncionalidadesFilho = listFuncionalidadesFilho;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	private Usuario getCurrentUser() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Usuario) session.getAttribute("currentUser");
	}

}
