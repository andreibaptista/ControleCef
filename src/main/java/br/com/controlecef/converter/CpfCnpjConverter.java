package br.com.controlecef.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.controlecef.control.util.StringUtil;

@FacesConverter("cpfCnpjConverter")
public class CpfCnpjConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {

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
