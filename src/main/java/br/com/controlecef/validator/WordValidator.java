package br.com.controlecef.validator;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("wordValidator")
public class WordValidator implements Validator {

	public static final String VALIDATOR_MESSAGE = "message.validator.word";
	public static final String PATTERN = "(.*[a-zA-Z]+.*)*";

	private Pattern pattern;
	private Matcher matcher;

	public WordValidator() {
		pattern = Pattern.compile(PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			ResourceBundle rb = ResourceBundle.getBundle("messages", context
					.getViewRoot().getLocale());
			String messageText = rb.getString(VALIDATOR_MESSAGE);
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messageText, messageText));

		}
	}
}
