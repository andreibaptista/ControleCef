package br.com.controlecef.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.controlecef.control.util.NavigationConstant;
import br.com.controlecef.model.Empresa;
import br.com.controlecef.service.EmpresaService;

@ManagedBean(name = "EmpresaControl")
@ViewScoped
public class EmpresaControl extends AbstractControl<Empresa, Integer, EmpresaService> {
	
	
	
	private List<Empresa> empresaList;

	@EJB
	private EmpresaService empresaService;
	
	@PostConstruct
	public void init() {
		setService(empresaService);
		novo();
	}

	@Override
	public String principal() {
		return NavigationConstant.URL_FLAGRANTEADO_PRINCIPAL;
	}

	@Override
	public void novo() {
		setBean(new Empresa());
	}

	@Override
	public Empresa load() {
		if (getBean() != null) {
			return getService().findByPk(getBean().getIdEmpresa());
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
		
	
	public List<Empresa> getEmpresaList() {
		return empresaList;
	}

	public void setEmpresaList(List<Empresa> empresaList) {
		this.empresaList = empresaList;
	}
}
