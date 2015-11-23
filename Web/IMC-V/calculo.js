var timer;
var nivel = { atual:0,destino:0};

//var canvas=document.getElementById("tabela");
//var context=canvas.getContext("2d");
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
	//context.clearRect(0, 0, canvas.width, canvas.height);
	for(var i=0;i<7;i++){
		var rec=document.getElementById("r"+i);
		try{
			var pai=rec.parentNode;
			pai.removeChild(rec);
		}catch (err){
			drawSvg();
		}

		var rec=document.getElementById("marcador");
		try{
			var pai=rec.parentNode;
			pai.removeChild(rec);
		}catch (err){
			drawCircle(25);
		}
	}
}

function atualizarInterface(imc, classificacao){
	document.getElementById("imcResult").innerHTML="Seu IMC é de "+imc+" Kg/m²";
	classifica(classificacao);
	clear();
	drawSvg();
	drawCircle(imc);	
}

function drawSvg(){
	var pai = document.getElementById("svg");
	for(var i=0; i<7; i++){
		var filho =document.createElementNS("http://www.w3.org/2000/svg","rect");

		filho.setAttribute("id","r"+i);
		filho.setAttribute("y","0");
		if(i==0){
			filho.setAttribute("x", 0);
		}else if(i==1){
			filho.setAttribute("x", 68);
		}else if(i==2){
			filho.setAttribute("x", 74);
		}else if(i==3){
			filho.setAttribute("x", 100);
		}else if(i==4){
			filho.setAttribute("x", 120);
		}else if(i==5){
			filho.setAttribute("x", 140);
		}else{
			filho.setAttribute("x", 160);
		}

		if(i==0){
			filho.setAttribute("width", 74);
		}else if(i==1){
			filho.setAttribute("width", 20*4);
		}else if(i==2){
			filho.setAttribute("width", 100);
		}else if(i==3){
			filho.setAttribute("width", 120);
		}else if(i==4){
			filho.setAttribute("width", 140);
		}else if(i==5){
			filho.setAttribute("width", 160);
		}else{
			filho.setAttribute("width", 240);
		}

		filho.setAttribute("height","48");
		if(i==0){
			filho.setAttribute("fill","red");
		}else if(i==1){
			filho.setAttribute("fill","orange");
		}else if(i==2){
			filho.setAttribute("fill","yellow");
		}else if(i==3){
			filho.setAttribute("fill","green");
		}else if(i==4){
			filho.setAttribute("fill","blue");
		}else if(i==5){
			filho.setAttribute("fill","indigo");
		}else{
			filho.setAttribute("fill","violet");
		}
		pai.appendChild(filho);
	}
}

function drawCircle(imc){
	var marcador = document.createElementNS("http://www.w3.org/2000/svg","circle");
	var pai = document.getElementById("svg");

	var ponto = parseInt(imc)*4;

	marcador.setAttribute("id","marcador");
	marcador.setAttribute("cx", ponto);
	marcador.setAttribute("cy","24");
	marcador.setAttribute("r","7");
	marcador.setAttribute("fill","black");
	marcador.setAttribute("stroke","black");
	marcador.setAttribute("stroke-width","1");

	pai.appendChild(marcador);
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
/////////////////////////////////////////////////
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