function habilitaConsultaLimites() {
	var cpfCnpj = document.getElementById("form-consulta-dados:txt-cpfCnpj");
	var tipoConsulta = document.getElementById("form-consulta-dados:select-pesquisarPor");
	var btnPesquisar = document.getElementById("form-consulta-dados:btn-pesquisar");
	var pesquisaRealizada = document.getElementById("form-consulta-dados:pesquisaAcionada");
	
	if (pesquisaRealizada != null && pesquisaRealizada.value == "true") {
		btnPesquisar.disabled = "disabled";
	} else {
		if (tipoConsulta != null && btnPesquisar != null ) {
			if (tipoConsulta.value == "A" && cpfCnpj != null) {
				if (cpfCnpj.value.length <= 0) {
					btnPesquisar.disabled = "disabled";
				} else {
					btnPesquisar.disabled = "";
				}
			} else if (tipoConsulta.value == "G"){
				btnPesquisar.disabled = "";
			}
		}
	}
	
}

// Funcao responsavel na validacao do botao "OK"
// da popup de justificativas nos detalhes de limite
function habilitaConfirmacaoJustificativa() {
	
	var obs = document.getElementById("form-dados-justificativa:inputObsMotivoAlteracao");
	var btnConfirmar = document.getElementById("form-dados-justificativa:btn-confirmar");
	var oidMotivo = document.getElementById("form-dados-justificativa:selectOidMotivoAlteracao");
	
	// oid do motivo selecionado, conforme carregado pela tabela
	// mtv_alt_status_limite
	// oid = 5 (Outros) obrigatorio obs maior do que 2 carecters
	// oid = 4 (Ocorrencia de Restritivos) obrigatorio obs maior do que 2
	// carecters
	if (oidMotivo != null) {
		
		if (oidMotivo.value == "" || oidMotivo.value == null) {
			btnConfirmar.disabled = "disabled";
		} else if ((oidMotivo.value == "5" && obs != null && obs.value.length > 2) 
				|| (oidMotivo.value == "4" && obs != null && obs.value.length > 2)) {
			btnConfirmar.disabled = "";
		} else if ((oidMotivo.value == "5" && obs != null && obs.value.length < 3) 
			     ||(oidMotivo.value == "4" && obs != null && obs.value.length < 3)) {
			btnConfirmar.disabled = "disabled";
		} else {
			btnConfirmar.disabled = "";
		}
		
	}
	
}

function desabilitaBtnPesquisar() {
	
	var btnPesquisar = document.getElementById("form-consulta-dados:btn-pesquisar");
	var tipoConsulta = document.getElementById("form-consulta-dados:select-pesquisarPor");
	
	if (btnPesquisar != null && tipoConsulta != null) {
		btnPesquisar.disabled = "disable";
		tipoConsulta.disabled = "disable";
	} else {
		btnPesquisar.disabled = "";
		tipoConsulta.disabled = "";
	}
	
}

function habilitaSelectTipoPesquisa() {
	
	var tipoConsulta = document.getElementById("form-consulta-dados:select-pesquisarPor");
	
	if (tipoConsulta != null) {
		tipoConsulta.disabled = "";
	} else {
		tipoConsulta.disabled = "disable";
	}
	
}

function radioButton(radio) {
	var id = radio.name.substring(radio.name.lastIndexOf(':'));
	var el = radio.form.elements;
	for ( var i = 0; i < el.length; i++) {
		if (el[i].name.substring(el[i].name.lastIndexOf(':')) == id) {
			el[i].checked = false;
		}
	}
	radio.checked = true;
}

function descricaoSituacaoPontoForteFraco(situacao) {
	var descricao = "";
	if (situacao != null && !situacao.isEmpty()) {
		descricao = "H".equalsIgnoreCase(situacao) ? "Habilitado"
				: "Desabilitado";
	}

	return descricao;
}

function limpaCampo(campo) {
	document.getElementById(campo).value = '';
}

/**
 * Metodo utilitario executado no onload de uma pagina, sendo necessario a
 * implementacao local do metodo inicializarComponentes, para sua utilizacao, ou
 * seja, especificar um metodo a ser executado durante onload.
 */
function inicializarComponentesGlobal() {
	if (window.inicializarComponentes) {
		inicializarComponentes();

	}
}

function marcarTodosChecks(obj) {

	jQuery(":checkbox").each(function() {

		selecionado = jQuery(this);

		if (obj.name != selecionado.attr('name')) {
			selecionado.attr("checked", jQuery(obj).attr('checked'));
		}
	});
}

function showFormConsultaLimites(tipo, idIndividual, idGeal) {
	if ("G" == tipo) {
		jQuery(idGeal).css('display', 'block !important');
		jQuery(idIndividual).css('display', 'none');
	} else if ("A" == tipo) {
		alert($(idIndividual));
		$(idIndividual).css('display', 'block !important');
		$(idGeal).css('display', 'none');
	}
}

function desabilitaBotao(a, b, c) {
	if (isMarcado()) {
		document.getElementById(a).disabled = false;
		document.getElementById(b).disabled = false;
		document.getElementById(c).disabled = false;
	} else {
		document.getElementById(a).disabled = true;
		document.getElementById(b).disabled = true;
		document.getElementById(c).disabled = true;
	}
}

function isMarcado() {
	marcado = false;
	jQuery(":checkbox").each(function() {

		selecionado = jQuery(this);
		if (selecionado.attr("checked")) {
			marcado = true;
		}
	});
	return marcado;
}

function marcarGrupoLimite(obj, classe) {
	jQuery(classe).attr("checked", jQuery(obj).attr('checked'));
}

function mascara(e, src, mask) {
	if (window.event) {
		_TXT = e.keyCode;
	} else if (e.which) {
		_TXT = e.which;
	}
	if (_TXT > 47 && _TXT < 58) {
		var i = src.value.length;
		var saida = mask.substring(0, 1);
		var texto = mask.substring(i);
		if (texto.substring(0, 1) != saida) {
			src.value += texto.substring(0, 1);
		}
		return true;
	} else {
		if (_TXT != 8) {
			return false;
		} else {
			return true;
		}
	}
}

function mascaraTipoPesquisa(e, src, tipoPesquisa) {
	var mask;
	if (tipoPesquisa == "999.999.999-99") {
		mask = "###.###.###-##";
	} else if (tipoPesquisa == "99.999.999/9999-99") {
		mask = "##.###.###/####-##";
	} else if (tipoPesquisa == "99999-9") {
		mask = "#####-#";
	} else {
		mask = "##############";
	}
	if (window.event) {
		_TXT = e.keyCode;
	} else if (e.which) {
		_TXT = e.which;
	}
	if (_TXT > 47 && _TXT < 58) {
		var i = src.value.length;
		var saida = mask.substring(0, 1);
		var texto = mask.substring(i);
		if (texto.substring(0, 1) != saida) {
			src.value += texto.substring(0, 1);
		}
		return true;
	} else {
		if (_TXT != 8) {
			return false;
		} else {
			return true;
		}
	}
}

function preencherMascara(param, tipoPesquisa) {
	
	// recebe o valor do campo (cpf, cnpj, conta)
	var valor = param.value;
	
	// valida se a pesquisa for para cpf e o tamnho da string menor que
	// (999.999.999-99)
	// total de 14 caracteres
	if (valor.length > 0) {
		if (tipoPesquisa == 'CPF' && valor.length < 14) {
			
			// chama funcao responsavel em completar com zeros a esquerda o
			// valor
			valor = completarMascara(11, valor);
			
			// formata a mascara para apresentar na tela
			valor = valor.substring(0,3) + '.' + valor.substring(3,6) + '.' + valor.substring(6,9) + '-' + valor.substring(9,11);
		
		// valida se a pesquisa for para cpf e o tamnho da string menor que
		// (99.999.999/9999-99)
		// total de 18 caracteres
		} else if (tipoPesquisa ==  'CNPJ' && valor.length < 18) {
			valor = completarMascara(14, valor);
			valor = valor.substring(0,2) + '.' + valor.substring(2,5) + '.' + valor.substring(5,8) + '/' + valor.substring(8,12) + '-' + valor.substring(12,14);
		
		// valida se a pesquisa for para conta e o tamnho da string menor que
		// (99999-9) total
		// de 6 caracteres
		} else if (tipoPesquisa == 'CONTA' && valor.length < 7) {
			valor = completarMascara(6, valor);
			valor = valor.substring(0,5) + '-' + valor.substring(5,6);
		}
	}
	
	param.value = valor;
	
}

function completarMascara(cont, valor) {
	var numeroMascara = null;
	
	// funcao reponsavel em deixar apenas valores numericos
	valor = soNumeros(valor);
	for ( var i = 0; i < cont; i++) {
		numeroMascara = valor.substring(i, i + 1);
		if (numeroMascara == null || numeroMascara == '') {
			valor = '0' + valor;
		}
	}
	// retorna o valor completado com zeros a esquerda
	return valor;
}

function habilitaBotaoPorSelecaoItem(idBotao) {

	if ($(":checkbox:checked:enabled").length > 0) {

		$(idBotao).removeAttr('disabled');

	} else {

		$(idBotao).attr('disabled', 'disabled');
	}
}

function desabilitaBntConfirmar() {
	var btnConfirmar = document.getElementById("form-manutencao-produtos-vinculados:btn-confirmar");
	var existeDados = document.getElementById("form-manutencao-produtos-vinculados:resultadoPesquisa");
	
	if (btnConfirmar != null && existeDados != null && existeDados.value == "true") {
		btnConfirmar.disabled = "";			
	} else if (btnConfirmar != null) {
		btnConfirmar.disabled = "disabled";			
	}
}

function showHideDiv2(idLinha, classe1, contexto) {
	// id da imagem
	var nodeChild = setFirstChildForBrowser(idLinha);
	// guarda a localizacao da imagem
	var imagem = null;
	
	if (nodeChild.id == 'mais') {
		// exibe elementos
		jQuery(classe1).show();
		imagem = contexto + '/resources/imagens/box-menos.png';
		// alteracao dos atributos da tag <img>
		nodeChild.setAttribute('id', 'menos');
		nodeChild.setAttribute('src', imagem);
	} else {
		// oculta elementos
		jQuery(classe1).hide();
		imagem = contexto + '/resources/imagens/box-mais.png';
		// alteracao dos atributos da tag <img>
		nodeChild.setAttribute('id', 'mais');
		nodeChild.setAttribute('src', imagem);
	}
	
}

function showHidePorSinal(sinal, elementos) {
	if (sinal) {
		// exibe os elementos
		jQuery(elementos).show();
	} else {
		// oculta os elementos
		jQuery(elementos).hide();
	}
}

// classe1 - Grupo Limite
// classe2 - Grupo Produto
function showHideDiv(classe1, classe2, contexto) {
	// retorna o elemento pelo id da imagem
	var imgMenos = document.getElementById('total-menos');
	var imgMais = document.getElementById('total-mais');
	// guarda a localizacao da imagem
	var imagem = null;
	
	// para imagem com sinal mais
	if (imgMais != null) {
		// exibe somente os grupos de limites
		showHidePorSinal(true, classe1);
		imagem = contexto + '/resources/imagens/box-menos.png';
		// alteracao dos atributos do elemento
		imgMais.setAttribute('id', 'total-menos');
		imgMais.setAttribute('src', imagem);
		// troca todos os sinais para os grupo de limites
		trocarSinalGrupoLimites(classe1, contexto);
	// para imagem com sinal menos
	} else {
		// oculta todos os grupos de produtos e grupos de limites
		showHidePorSinal(false, classe1);
		showHidePorSinal(false, classe2);
		imagem = contexto + '/resources/imagens/box-mais.png';
		// alteracao dos atributos do elemento
		imgMenos.setAttribute('id', 'total-mais');
		imgMenos.setAttribute('src', imagem);
	}
	
}

function trocarSinalGrupoLimites(classe1, contexto) {
	// varre todos os grupos de limties para alteracao dos sinais
	jQuery(classe1).each(function() {
		
		trocarSinal(jQuery(this), contexto);
		
	});
	
}

function trocarSinal(classe, contexto){
	
	var browser = navigator.appName;
	var linha = null;
	
	// contexto do elemento que guarda a imagem
	if (browser == 'Netscape') {
		linha = classe.context.cells[1];
	} else {
		linha = classe.context.childNodes.item(1);
	}
	
	// elemento que guarda a imagem
	var linhaImagem = setFirstChildForBrowser(linha);
	// localizacao da imagem
	var imagem = contexto + '/resources/imagens/box-mais.png';;

	if (linhaImagem != null) {
		// altera os atributos da imagem para o elemento pai <a>
		var tagImagem = setFirstChildForBrowser(linhaImagem);
		tagImagem.setAttribute('id', 'mais');
		tagImagem.setAttribute('src', imagem);
	}
	
}

function setFirstChildForBrowser(node) {
	
	var browser = navigator.appName;
	
	if (browser == 'Netscape') {
		return node.firstElementChild;
	} else {
		return node.firstChild;
	}
	
}

function setarMascara(idMascara, idCampo) {
	var $jQueryLocal = jQuery.noConflict();
	var selector = "#" + idCampo;
	try {
		selector = eval(selector);
	} catch (e) {
	}
	var tipoMascara = setarTipoMascara(idMascara);
	resetarMascara(idCampo);
	if (tipoMascara != "texto") {
		$jQueryLocal(selector).mask("99/99/9999");
		$jQueryLocal(selector).attr("value", "31/12/1985");
	}
}

function limpaCampo(campo) {
	document.getElementById(campo).value = '';
}

function setarTipoMascara(tipo) {
	var retorno = "texto";
	if (tipo == "CPF") {
		retorno = "cpf";
	} else if (tipo == "CNPJ") {
		retorno = "cnpj";
	} else if (tipo == "CONTA") {
		retorno = "conta";
	}
	return retorno;
}

function resetarMascara(campo) {
	var $jQueryLocal = jQuery.noConflict();
	var selector = "#" + campo;
	try {
		selector = eval(selector);
	} catch (e) {
	}
	$jQueryLocal(selector).unbind('.mask').removeData('mask');
}

function mascaraExpress(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 1);
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function leech(v) {
	v = v.replace(/o/gi, "0");
	v = v.replace(/i/gi, "1");
	v = v.replace(/z/gi, "2");
	v = v.replace(/e/gi, "3");
	v = v.replace(/a/gi, "4");
	v = v.replace(/s/gi, "5");
	v = v.replace(/t/gi, "7");
	return v;
}

function soNumeros(v) {
	return v.replace(/\D/g, "");
}

function telefone(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/^(\d\d)(\d)/g, "($1) $2"); // Coloca parênteses em volta
	// dos dois primeiros dígitos
	v = v.replace(/(\d{4})(\d)/, "$1-$2"); // Coloca hífen entre o quarto e o
	// quinto dígitos
	return v;
}

function cpf(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/(\d{3})(\d)/, "$1.$2"); // Coloca um ponto entre o terceiro
	// e o quarto dígitos
	v = v.replace(/(\d{3})(\d)/, "$1.$2"); // Coloca um ponto entre o terceiro
	// e o quarto dígitos
	// de novo (para o segundo bloco de números)
	v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2"); // Coloca um hífen entre o
	// terceiro e o quarto
	// dígitos
	return v;
}

function cep(v) {
	v = v.replace(/D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/^(\d{5})(\d)/, "$1-$2"); // Esse é tão fácil que não merece
	// explicações
	return v;
}

function cnpj(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/^(\d{2})(\d)/, "$1.$2"); // Coloca ponto entre o segundo e o
	// terceiro dígitos
	v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3"); // Coloca ponto entre o
	// quinto e o sexto
	// dígitos
	v = v.replace(/\.(\d{3})(\d)/, ".$1/$2"); // Coloca uma barra entre o
	// oitavo e o nono dígitos
	v = v.replace(/(\d{4})(\d)/, "$1-$2"); // Coloca um hífen depois do bloco
	// de quatro dígitos
	return v;
}

function valor(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/^([0-9]{3}\.?){3}-[0-9]{2}$/, "$1,$2");
	// v = v.replace(/(\d{3})(\d)/g, "$1,$2");
	// v = v.replace(/(\d{3}) (\d{3}) (\d{3}) (\d{3})(\d{2})$/,
	// "$1.$2.$3.$4,$5"); // Coloca
	// ponto
	// antes
	// dos
	// 2
	// últimos
	// digitos
	return v;
}

function moeda(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/(\d{2})$/, ",$1"); // Coloca a virgula
	v = v.replace(/(\d+)(\d{3},\d{2})$/g, "$1.$2"); // Coloca o primeiro ponto
	var qtdLoop = (v.length - 3) / 3;
	var count = 0;
	while (qtdLoop > count) {
		count++;
		v = v.replace(/(\d+)(\d{3}.*)/, "$1.$2"); // Coloca o resto dos pontos
	}
	v = v.replace(/^(0)(\d)/g, "$2"); // Coloca hífen entre o quarto e o
	// quinto dígitos
	return v;

}
