package br.com.controlecef.converter;

import java.text.Normalizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("maskConverterRemove")
public class MaskConverterRemove implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {	
		
		arg2 = Normalizer.normalize(arg2, Normalizer.Form.NFD);
		return arg2.replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}	
}
