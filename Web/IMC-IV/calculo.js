var timer;
var nivel = { atual:0,destino:0};

var canvas=document.getElementById("tabela");
var context=canvas.getContext("2d");

function calcular(){
	var pessoa = new Object();
	pessoa=obterDados();
	var imc = calcularIMC(pessoa);
	atualizarInterface(imc, obterClassificacao(imc));
}
function obterDados(){
	var pessoa = new Object();
	pessoa.a=document.getElementById("altura").value;
	pessoa.p=document.getElementById("peso").value
	if (isNaN(pessoa.a)){
		alert("Valor da Altura inválida!");
	}if (isNaN(pessoa.p)){
		alert("Valor do Peso inválido!");
	}
	return pessoa;
}
function calcularIMC(pessoa){
	pessoa.imc=(pessoa.p/(pessoa.a*pessoa.a));
	return pessoa.imc.toFixed(2);
}
function obterClassificacao(imc){
	var classificacao;
	if(isNaN(imc)){
		alert("Valores Inválidos");
	}
	else if(imc<17){
		classificacao=0;
	}
	else if (imc<=18.5){
		classificacao=1;
	}
	else if (imc<=24.99){
		classificacao=2;
	}
	else if (imc<=29.99){
		classificacao=3;
	}
	else if (imc<=34.99){
		classificacao=4;
	}
	else if (imc<=39.99){
		classificacao=5;
	}
	else if (imc>40){
		classificacao=6;
	}
	return classificacao;
}

function clear(){
	context.clearRect(0, 0, canvas.width, canvas.height);
}

function atualizarInterface(imc, classificacao){
	document.getElementById("imcResult").innerHTML="Seu IMC é de "+imc+" Kg/m²";
	classifica(classificacao);
	//alert("imc: "+imc+" classificacao: "+classificacao+" level: "+lvl);
	startAnimation(classificacao);
}

function startAnimation(classificacao){
	nivel.atual=0;
	nivel.destino=classificacao;
	timer = setInterval(animation,500);
}

function animation(){
	//alert(lvl);
	clear();
	context.beginPath();
	context.arc(24,9,8, 0*Math.PI, 2*Math.PI);//cabeça
	context.moveTo(24,32);
	context.lineTo(16,48);//perna esquerda
	context.moveTo(25,32);//move para fazer a perna direita
	context.lineTo(32,48);//perna direita
	context.moveTo(24,17);
	context.lineTo(10,17);//braço esquerdo
	context.moveTo(25,17);
	context.lineTo(40,17);//braço direito

	context.moveTo(25,16);//move para a base da segunda parte do tronco
	context.quadraticCurveTo(25+(nivel.atual*6), 24, 25, 32);//tronco direito
	context.moveTo(24,16);
	context.quadraticCurveTo(24-(nivel.atual*6), 24, 24, 32);//tronco esquerdo

	context.stroke();
	nivel.atual=nivel.atual+1;
	if (nivel.atual>=nivel.destino){
		stopAnimation();
	}
	
}
function stopAnimation(){
	clearInterval(timer);
	nivel.atual=0;
}
function classifica(classificacao){
	if(isNaN(classificacao)){
			alert("Valores Inválidos");
		}
		else if(classificacao==0){
			document.getElementById("resultado").innerHTML="Muito Abaixo do Peso.";
		}
		else if (classificacao==1){
			document.getElementById("resultado").innerHTML="Abaixo do peso.";
		}
		else if (classificacao==2){
			document.getElementById("resultado").innerHTML="Peso Normal.";
		}
		else if (classificacao==3){
			document.getElementById("resultado").innerHTML="Acima do Peso.";
		}
		else if (classificacao==4){
			document.getElementById("resultado").innerHTML="Obesidade I.";
		}
		else if (classificacao==5){
			document.getElementById("resultado").innerHTML="Obesidade II.";
		}
		else if (classificacao==6){
			document.getElementById("resultado").innerHTML="Obesidade III.";
		}
}