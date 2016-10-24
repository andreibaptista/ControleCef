package br.com.controlecef.control;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.controlecef.control.util.MessagesUtil;
import br.com.controlecef.service.StoredProceduresService;


@ManagedBean(name = "execucaoSPControl")
@RequestScoped
public class ExecucaoSPControl {		
	
	@Inject
	private MessagesUtil messagesUtil;
	
	@EJB
	private StoredProceduresService spService;
	
	private String info;
		
	
	public ExecucaoSPControl() {
		info = null;
	}
	
	
	public String executar_procedure(){
		try {
			info = null;
			
			if(spService.NOME_METODO()){
				messagesUtil.addInfoMessage("sucesso.executar.procedure");
				FacesMessage fm = new FacesMessage(" (NOME_PROCEDURE) ");
				fm.setSeverity(FacesMessage.SEVERITY_INFO);			
				FacesContext.getCurrentInstance().addMessage(null, fm);
			} else {
				messagesUtil.addErrorMessage("erro.executar.procedure");	
			}
		
		} catch(Exception e){
			e.printStackTrace();
			info = "Procedure:  nome_procedure";
			info += e.getCause().getCause().getCause().toString();
			messagesUtil.addErrorMessage("erro.executar.procedure");	
			FacesMessage fm = new FacesMessage(info);
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);			
			FacesContext.getCurrentInstance().addMessage(null, fm);
		}
		
		return null;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
		
}
