package br.com.controlecef.control;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.controlecef.control.util.NavigationConstant;

@ManagedBean(name = "redirect")
@ApplicationScoped
public class RedirectControl {

	public String login() {
		return NavigationConstant.URL_LOGIN;
	}
	
	public String indexSeguranca(){
		return NavigationConstant.URL_SEGURANCA_INDEX;
	}
}
