function mascaraMutuario(o, f) {
	v_obj = o
	v_fun = f
	setTimeout('execmascara()', 1)
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value)
}

function cpfCnpj(v) {

	// Remove tudo o que não é dígito
	v = v.replace(/\D/g, "")

	if (v.length <= 13) { // CPF

		// Coloca um ponto entre o terceiro e o quarto dígitos
		v = v.replace(/(\d{3})(\d)/, "$1.$2")

		// Coloca um ponto entre o terceiro e o quarto dígitos
		// de novo (para o segundo bloco de números)
		v = v.replace(/(\d{3})(\d)/, "$1.$2")

		// Coloca um hífen entre o terceiro e o quarto dígitos
		v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2")

	} else { // CNPJ

		// Coloca ponto entre o segundo e o terceiro dígitos
		v = v.replace(/^(\d{2})(\d)/, "$1.$2")

		// Coloca ponto entre o quinto e o sexto dígitos
		v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3")

		// Coloca uma barra entre o oitavo e o nono dígitos
		v = v.replace(/\.(\d{3})(\d)/, ".$1/$2")

		// Coloca um hífen depois do bloco de quatro dígitos
		v = v.replace(/(\d{4})(\d)/, "$1-$2")

	}

	return v

}

function maskDate(date) {

	// Remove tudo o que não é dígito
	v = date.value.replace(/\D/g, "")
	if (v.length < 11) {

		// Coloca ponto entre o segundo e o terceiro dígitos
		v = v.replace(/^(\d{2})(\d)/, "$1/$2")

		// Coloca ponto entre o quinto e o sexto dígitos
		v = v.replace(/^(\d{2})\/(\d{2})(\d)/, "$1/$2/$3")

		date.value = v;
	} else {
		return false;
	}

}

function maskLinhaDigitavel(v) {

	// Remove tudo o que não é dígito
	v = v.replace(/\D/g, "")

		// Coloca ponto entre o quinto e o sexto digito
		v = v.replace(/^(\d{5})(\d)/, "$1.$2")

		// Coloca espaco entre o decimo e o decimo primeiro digito
		v = v.replace(/^(\d{5})\.(\d{5})(\d)/, "$1.$2 $3")

		// Coloca ponto entre o decimo quinto e o vigesimo digito
		v = v.replace(/^(\d{5})\.(\d{5})\s(\d{5})(\d)/, "$1.$2 $3.$4")

		// Coloca espaco entre o decimo quinto e o vigesimo digito
		v = v.replace(/^(\d{5})\.(\d{5})\s(\d{5})\.(\d{6})(\d)/, "$1.$2 $3.$4 $5")

		// Coloca espaco entre o decimo quinto e o vigesimo digito
		v = v.replace(/^(\d{5})\.(\d{5})\s(\d{5})\.(\d{6})\s(\d{5})(\d)/, "$1.$2 $3.$4 $5.$6")

		// Coloca espaco entre o decimo quinto e o vigesimo digito
		v = v.replace(/^(\d{5})\.(\d{5})\s(\d{5})\.(\d{6})\s(\d{5})\.(\d{6})(\d)/, "$1.$2 $3.$4 $5.$6 $7")

		// Coloca espaco entre o decimo quinto e o vigesimo digito
		v = v.replace(/^(\d{5})\.(\d{5})\s(\d{5})\.(\d{6})\s(\d{5})\.(\d{6})\s(\d{1})(\d)/, "$1.$2 $3.$4 $5.$6 $7 $8")

	return v

}

function changeFocus(src, len, tar){
	var v = src.value;
	if(v.length == len ){
		$("#"+tar).focus();
	}
}

function addPhoneMask() {
	$(".phone").focus(function() {
		$(this).mask("(99) 9999-9999?9");
	});
	$(".phone").focusout(function() {
		var phone, element;
		element = $(this);
		element.unmask();
		phone = element.val().replace(/\D/g, '');
		if (phone.length > 10) {
			element.mask("(99) 99999-999?9");
		} else {
			element.mask("(99) 9999-9999?9");
		}
	});
}