package br.edu.ifpr.logica;

import javax.swing.JOptionPane;

public class Jogo {
	public int [][] tabuleiro= new int [3][3];

	
	public Jogo(){
		
	}
	public Jogo(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public void zera(){
		for(int x=0;x<3;x++){
			for(int y=0; y<3; y++){
				tabuleiro[x][y]=0;
			}
		}
	}
	
	public void putX(int x){
		
		if ( x==1 && tabuleiro[0][0]==0 ){
			tabuleiro[0][0]=1;
		}
		else if (x==2 && tabuleiro[0][1]==0 ){
			tabuleiro[0][1]=1;
		}
		else if (x==3 && tabuleiro[0][2]==0 ){
			tabuleiro[0][2]=1;
		}
		else if (x==4 && tabuleiro[1][0]==0 ){
			tabuleiro[1][0]=1;
		}
		else if (x==5 && tabuleiro[1][1]==0 ){
			tabuleiro[1][1]=1;
		}
		else if (x==6 && tabuleiro[1][2]==0 ){
			tabuleiro[1][2]=1;
		}
		else if (x==7 && tabuleiro[2][0]==0 ){
			tabuleiro[2][0]=1;
		}
		else if (x==8 && tabuleiro[2][1]==0 ){
			tabuleiro[2][1]=1;
		}
		else if (x==9 && tabuleiro[2][2]==0 ){
			tabuleiro[2][2]=1;
		}
		else{
			JOptionPane.showMessageDialog(null, "JOGUE EM OUTRA CASA");
		}
	}
	
	public void putO(int x){
		
		if (x==1 && tabuleiro[0][0]==0 ){
			tabuleiro[0][0]=-1;
		}
		else if (x==2 && tabuleiro[0][1]==0 ){
			tabuleiro[0][1]=-1;
		}
		else if (x==3 && tabuleiro[0][2]==0 ){
			tabuleiro[0][2]=-1;
		}
		else if (x==4 && tabuleiro[1][0]==0 ){
			tabuleiro[1][0]=-1;
		}
		else if (x==5 && tabuleiro[1][1]==0 ){
			tabuleiro[1][1]=-1;
		}
		else if (x==6 && tabuleiro[1][2]==0 ){
			tabuleiro[1][2]=-1;
		}
		else if (x==7 && tabuleiro[2][0]==0 ){
			tabuleiro[2][0]=-1;
		}
		else if (x==8 && tabuleiro[2][1]==0 ){
			tabuleiro[2][1]=-1;
		}
		else if (x==9 && tabuleiro[2][2]==0 ){
			tabuleiro[2][2]=-1;
		}
		else{
			JOptionPane.showMessageDialog(null, "JOGUE EM OUTRA CASA");
		}
	}
	
	public void check(){
//		DIAGONAIS X
		if(tabuleiro[0][0]+tabuleiro[1][1]+tabuleiro[2][2]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		else if(tabuleiro[2][0]+tabuleiro[1][1]+tabuleiro[0][2]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
//		DIAGONAIS O
		if(tabuleiro[0][0]+tabuleiro[1][1]+tabuleiro[2][2]==-3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		else if(tabuleiro[2][0]+tabuleiro[1][1]+tabuleiro[0][2]==-3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		//LINHAS E COLUNAS X
		if(tabuleiro[0][0]+tabuleiro[0][1]+tabuleiro[0][2]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		else if(tabuleiro[1][0]+tabuleiro[1][1]+tabuleiro[1][2]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		else if(tabuleiro[2][0]+tabuleiro[2][1]+tabuleiro[2][2]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		/////////////////////////////
		if(tabuleiro[0][0]+tabuleiro[1][0]+tabuleiro[2][0]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		else if(tabuleiro[0][1]+tabuleiro[1][1]+tabuleiro[2][1]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
		else if(tabuleiro[0][2]+tabuleiro[1][2]+tabuleiro[2][2]==3){
			JOptionPane.showMessageDialog(null, "X GANHOU");
			zera();
		}
//		LINHAS E COLUNAS O;
		if(tabuleiro[0][0]+tabuleiro[0][1]+tabuleiro[0][2]==-3){
			JOptionPane.showMessageDialog(null, "O GANHOU");
			zera();
		}
		else if(tabuleiro[1][0]+tabuleiro[1][1]+tabuleiro[1][2]==-3){
			JOptionPane.showMessageDialog(null, "O GANHOU");
			zera();
		}
		else if(tabuleiro[2][0]+tabuleiro[2][1]+tabuleiro[2][2]==-3){
			JOptionPane.showMessageDialog(null, "O GANHOU");
			zera();
		}
		/////////////////////////////
		if(tabuleiro[0][0]+tabuleiro[1][0]+tabuleiro[2][0]==-3){
			JOptionPane.showMessageDialog(null, "O GANHOU");
			zera();
		}
		else if(tabuleiro[0][1]+tabuleiro[1][1]+tabuleiro[2][1]==-3){
			JOptionPane.showMessageDialog(null, "O GANHOU");
			zera();
		}
		else if(tabuleiro[0][2]+tabuleiro[1][2]+tabuleiro[2][2]==-3){
			JOptionPane.showMessageDialog(null, "O GANHOU");
			zera();
		}
		
		
	}
}
