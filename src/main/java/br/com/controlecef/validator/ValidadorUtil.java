package br.com.controlecef.validator;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorUtil {

	public static boolean isCNPJ(String CNPJ) {

		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
				CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
				CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
				CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
				CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
				(CNPJ.length() != 14))
			return(false);

		char dig13, dig14;
		int sm, i, r, num, peso;


		try {

			sm = 0;
			peso = 2;
			for (i=11; i>=0; i--) {
				num = (int)(CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else dig13 = (char)((11-r) + 48);


			sm = 0;
			peso = 2;
			for (i=12; i>=0; i--) {
				num = (int)(CNPJ.charAt(i)- 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else dig14 = (char)((11-r) + 48);


			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return(true);
			else return(false);
		} catch (InputMismatchException erro) {
			return(false);
		}
	}

	public static String imprimeCNPJ(String CNPJ) {

		return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
				CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
				CNPJ.substring(12, 14));
	}
	
	public static boolean isCPF(String strCpf) {
		int     d1, d2;
	    int     digito1, digito2, resto;
	    int     digitoCPF;
	    String  nDigResult;
		
		try{
		/*verifica sequencia de n�meros iguais*/
			Pattern p = Pattern.compile("(\\d)\\1{10}");
			Matcher m = p.matcher(strCpf);
			if (m.find()) return false;
			
			  

			    d1 = d2 = 0;
			    digito1 = digito2 = resto = 0;

			    for (int nCount = 1; nCount < strCpf.length() -1; nCount++)
			    {
			       digitoCPF = Integer.valueOf (strCpf.substring(nCount -1, nCount)).intValue();

			       d1 = d1 + ( 11 - nCount ) * digitoCPF;

			       d2 = d2 + ( 12 - nCount ) * digitoCPF;
			    };

			    resto = (d1 % 11);

			    if (resto < 2)
			       digito1 = 0;
			    else
			       digito1 = 11 - resto;

			    d2 += 2 * digito1;

			    resto = (d2 % 11);

			    if (resto < 2)
			       digito2 = 0;
			    else
			       digito2 = 11 - resto;

			    String nDigVerific = strCpf.substring (strCpf.length()-2, strCpf.length());

			    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

			    return nDigVerific.equals(nDigResult);
			 
		} catch (InputMismatchException erro) {
			return(false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
				CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}
	
	public static String imprimeDocumento(String documento){
		if (documento.length() > 11) {
			documento = imprimeCNPJ(documento);
		}else{
			documento = imprimeCPF(documento);
		}
		return documento;
	}
	
	public static boolean isCNPJCPF(String CNPJCPF) {
		if (CNPJCPF.length() > 11) {
			return isCNPJ(CNPJCPF);
		}else{
			return isCPF(CNPJCPF);
		}
	}
}





