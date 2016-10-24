package br.com.controlecef.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.controlecef.control.util.NavigationConstant;
import br.com.controlecef.model.Usuario;
import br.com.controlecef.service.UsuarioService;

@ManagedBean(name = "usuarioControl")
@ViewScoped
public class UsuarioControl extends AbstractControl<Usuario, Integer, UsuarioService> {
	
	
	
	private List<Usuario> usuarioList;

	@EJB
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		setService(usuarioService);
		novo();
	}

	@Override
	public String principal() {
		return NavigationConstant.URL_FLAGRANTEADO_PRINCIPAL;
	}

	@Override
	public void novo() {
		setBean(new Usuario());
	}

	@Override
	public Usuario load() {
		if (getBean() != null) {
			return getService().findByPk(getBean().getCodigoUsuario());
		}
		return null;
	}
	
	@Override
	public void salvar(){
		super.salvar();
		/*fecha o dialog de cadastro/edi��o: dialogForm � o id do dialog*/
		RequestContext.getCurrentInstance().execute("dialogForm.hide()");
		/*atualiza/refresh o form onde se encontra o datatable para mostrar o novo item cadastrado na nova lista: formPesq � o id form*/
		RequestContext.getCurrentInstance().update("formPesq");		
	}

	@Override
	public void remover() {		
		super.remover();	
	}
		
	
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
}
