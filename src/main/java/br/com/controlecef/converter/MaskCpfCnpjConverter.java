package br.com.controlecef.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.controlecef.control.util.StringUtil;

@FacesConverter("maskCpfCnpjConverter")
public class MaskCpfCnpjConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		return arg2.replaceAll("[\\(\\)\\-/\\.\\,' ']", "");
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value == null) {
			return "";
		} else {
			if (value.toString().length() == 11) {
				value = StringUtil.cpfFormatter(value.toString());
			} else if (value.toString().length() > 11) {
				value = StringUtil.cnpjFormatter(value.toString());
			}
			return value.toString();
		}
	}	
}
