package br.com.controlecef.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("maskConverterPhone")
public class MaskConverterPhone implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return arg2.replaceAll("[\\(\\)\\-/\\.\\,' ']", "");
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String val = (String) arg2;
		StringBuffer tel = new StringBuffer();
		if (val != null) {
			val = val.trim();
			if (!"".equals(val)) {
				tel.append("(");
				tel.append(val.substring(0, 2));
				tel.append(") ");
				if (val.length() == 10) {
					tel.append(val.substring(2, 6));
					tel.append("-");
					tel.append(val.substring(6, 10));
				} else if (val.length() == 11) {
					tel.append(val.substring(2, 7));
					tel.append("-");
					tel.append(val.substring(7, 11));
				} else {
					return arg2.toString();
				}
				return tel.toString();
			}
		}
		return arg2.toString();
	}
}
