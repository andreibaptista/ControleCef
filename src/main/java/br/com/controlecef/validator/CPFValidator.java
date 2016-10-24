package br.com.controlecef.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cpfValidator")
public class CPFValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		if(!ValidadorUtil.isCPF(arg2.toString())){
			FacesMessage message = new FacesMessage("CPF Inv�lido");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			throw new ValidatorException(message);
		}
		
	}

	

}
