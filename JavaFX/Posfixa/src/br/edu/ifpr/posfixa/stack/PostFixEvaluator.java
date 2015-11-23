/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpr.posfixa.stack;
import br.edu.ifpr.posfixa.exceptions.PostfixInvalidException;
import java.util.StringTokenizer;
//import javax.swing.JOptionPane;

public class PostFixEvaluator {
	private String expression;
	double d=0;
	String tmp;
        public String result;
        
        //isntancia nova pilha
		Stack pilha = new Stack(15);
	
	public PostFixEvaluator(){}
        
	////METODO PARA CALCULAR

    /**
     *
     * @return
     */
    	public Object avalia(){
            //instancia o tokenizer usando a expressao como parametro;
		StringTokenizer entradaTokens = new StringTokenizer(getExpression());
		//fim
		while (entradaTokens.hasMoreTokens()){
			tmp=entradaTokens.nextToken();
			
			if(isNumeric(tmp)){
				pilha.push(Double.parseDouble(tmp));
			}
			else{
                            switch (tmp) {
                                case "+":
                                    {
                                        double n1 = (double)pilha.pop();
                                        double n2 = (double)pilha.pop();
                                        pilha.push(n1+n2);
                                        break;
                                    }
                                case "-":
                                    {
                                        double n1 = (double)pilha.pop();
                                        double n2 = (double)pilha.pop();
                                        pilha.push(n2-n1);
                                        break;
                                    }
                                case "*":
                                    {
                                        double n1 = (double)pilha.pop();
                                        double n2 = (double)pilha.pop();
                                        pilha.push(n1*n2);
                                        break;
                                    }
                                case "/":
                                    {
                                        double n1 = (double)pilha.pop();
                                        double n2 = (double)pilha.pop();
                                        pilha.push(n2/n1);
                                        break;
                                    }
                                case "^":
                                    {
                                        double n1 = (double)pilha.pop();
                                        double n2 = (double)pilha.pop();
                                        pilha.push(Math.pow(n2,n1));
                                        break;
                                    }
                                default:
                                    throw new PostfixInvalidException("Operacao invalida");
                            }
			}
		}
                return pilha.top();
                
	}
	////FIM METODO
	
	/////AVALIADOR
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}	
	
	//metodo para verificar numero
	public boolean isNumeric(String str){  
	  try{  
		  d = Double.parseDouble(str);
	  }  
	  catch(NumberFormatException err){  
		  return false;
	  }  
	  return true;  
	}
}
        
