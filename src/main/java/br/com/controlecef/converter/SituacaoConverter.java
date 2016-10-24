package br.com.controlecef.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("situacaoConverter")
public class SituacaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String situacao) {
		return situacao;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object situacao) {
		if(situacao==null){
			return "";
		}else{
			if(situacao.toString().equals("A")){
				situacao = "ATIVO";
			}else if(situacao.toString().equals("I")){
				situacao = "INATIVO";
			}else if(situacao.toString().equals("N")){
				situacao = "N�O";
			}else if(situacao.toString().equals("S")){
				situacao = "SIM";
			}
			return situacao.toString();
		}
			
	}
	
}
