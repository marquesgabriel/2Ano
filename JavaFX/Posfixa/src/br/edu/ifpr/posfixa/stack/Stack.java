/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpr.posfixa.stack;

import br.edu.ifpr.posfixa.exceptions.StackEmptyException;
import br.edu.ifpr.posfixa.exceptions.StackFullException;
import br.edu.ifpr.posfixa.exceptions.StackNullException;

public class Stack {
	private Object [] stack = new Object[666];
	private int peak=-1;	
	
	public int getPeak(){
		return this.peak;
	}
	
	public Stack(){
		stack= new Object[100];
	}
	
	public Stack(int tam) throws StackNullException{
		if(tam>1){
			stack= new Object[tam];
		}
		else{
			throw new StackNullException("Pilha de tamanho invalido.");
		}
	}
	
	
	
	public void push(Object obj) throws StackFullException{
		if (this.isFull()){
			throw new StackFullException("Pilha cheia, impossivel inserir outro item.");			
		}
		else{
			peak++;
			stack[peak]=obj;
			//System.out.println("Adicionado com sucesso.");
		}
	}
	
	
	public Object pop() throws StackEmptyException{
		Object poptemp;
		if (isEmpty()){
			throw new StackEmptyException("Paranaue vazio, nao da pra remover");
		}
		else{
			poptemp=stack[peak];
			stack[peak]=null;
			peak--;
			//System.out.println("Removido com sucesso.");
			return poptemp;
		}
	}
	
	public Object top() throws StackEmptyException{
		if(isEmpty()){
			throw new StackEmptyException("Pilha vazia, não existe topo");
		}
		else{
			return stack[peak];
		}
	}	
	public int size(){
		return stack.length;
	}
	
	
	public boolean isFull(){
		if(peak==stack.length-1){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isEmpty(){
		if (peak==-1){
			return true;
		}
		else{
			return false;
		}
	}
}
