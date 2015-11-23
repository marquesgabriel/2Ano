/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpr.posfixa.stack;

/**
 *
 * @author Naturallis
 */
public class TesteAvalia {
    public static void main(String[]args){
        PostFixEvaluator teste = new PostFixEvaluator();
         teste.setExpression("2 3 + 5 *");
         
         System.out.println(teste.avalia().toString());
         
    }
}
