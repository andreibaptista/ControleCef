package br.com.controlecef.control.util;

public class StringUtil {
	
	/**
	 * Formata um objeto String para uma String no formato 99.999.999/9999-99
	 * @param cnpj
	 * @return
	 */
	public static String cnpjFormatter(String CNPJ) {
		return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "."
				+ CNPJ.substring(5, 8) + "/" + CNPJ.substring(8, 12) + "-" + CNPJ
					.substring(12, 14));
	}
	
	
	/**
	 * Formata um objeto String para uma String no formato 999.999.999-99
	 * @param cpf
	 * @return
	 */
	public static String cpfFormatter(String CPF){
		return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
				CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}
	
	
}
