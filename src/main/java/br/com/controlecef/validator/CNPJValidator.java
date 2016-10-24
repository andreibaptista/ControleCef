package br.com.controlecef.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cnpjValidator")
public class CNPJValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		if(!ValidadorUtil.isCNPJ(arg2.toString())){
			FacesMessage message = new FacesMessage("CNPJ Invalido");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			throw new ValidatorException(message);
		}
		
	}

	

}
