package br.edu.ifpr.app;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import br.edu.ifpr.logica.Jogo;

public class Draw extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	TABULEIRO DA LOGICA DA VELHA
	int [][] tabuleiro = new int [3][3];
	Jogo logica = new Jogo(tabuleiro);
	//
	
//	CONSTRUTOR
	public Draw(){
		repaint();
		this.addMouseListener(this);
	}
	//
	
//	DESENHA BOLINHA
	public void circle(Graphics g,int x, int y){
		//super.paintComponent(g);
		logica.check();
		g.drawArc(x+10, y+10, 80, 80, 0, 360);
	}
	//
	
//	DESENHA X
	public void x(Graphics g, int x, int y){
		//super.paintComponent(g);
		logica.check();
		g.drawLine(x+20, y+20, (x+80), (y+80) );
		g.drawLine(x+20, (y+100)-20, (x+80), (y+20) );
	}
	//
	
	//desenha o tabuleiro
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//verticais
		g.drawLine(100, 0, 100, 300);
		g.drawLine(200, 0, 200, 300);
		//horizontais
		g.drawLine(0,100, 300, 100);
		g.drawLine(0, 200, 300, 200);
		//metodo que limpa o tabuleiro logico
		logica.zera();
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println(e.getX() +" "+ e.getY());
		//BOTAO DIREITO
		if(e.getButton()==3){
			
			//1,1
			
			if( (e.getX()<=100) && (e.getY()<=100) ){
				logica.putO(1);
				circle(getGraphics(), 0, 0);
			}
			//1,2
			
			else if( (e.getX()>100 && e.getX()<=200) && (e.getY()<=100) ){
				logica.putO(2);
				circle(getGraphics(), 100, 0);
			}
			//1,3
			
			else if( (e.getX()>200 && e.getX()<=300) && (e.getY()<=100) ){
				logica.putO(3);
				circle(getGraphics(), 200, 0);
			}
			
			//2,1
			
			else if( (e.getX()<=100 && e.getY()>100) && (e.getY()<=200) ){
				logica.putO(4);
				circle(getGraphics(), 0, 100);
			}
			//2,2
			
			else if( (e.getX()>100)&&(e.getX()<=200) && (e.getY()>100)&&(e.getY()<=200) ){
				logica.putO(5);
				circle(getGraphics(), 100, 100);
			}
			//2,3
			
			else if( (e.getX()>200) && (e.getX()<=300) && e.getY()>100 && e.getY()<=200){
				logica.putO(6);
				circle(getGraphics(), 200, 100);
			}
			//3,1
			
			else if( (e.getX()<=100) && (e.getY()>200) && e.getY()<=300 ){
				logica.putO(7);
				circle(getGraphics(), 0, 200);
			}
			//3,2
			
			else if( (e.getX()>100) && (e.getX()<=200) && e.getY()>200 && e.getY()<=300){
				logica.putO(8);
				circle(getGraphics(), 100, 200);
			}
			//3,3
			
			else if( (e.getX()>200)&&(e.getX()<=300) && (e.getY()>200)&&(e.getY()<=300) ){
				logica.putO(9);
				circle(getGraphics(), 200, 200);
			}
		}
		
		//BOTAO ESQUERDO
		if(e.getButton()==1){
			//1,1
			if( (e.getX()<=100) && (e.getY()<=100) ){
				logica.putX(1);
				x(getGraphics(), 0,0);				
			}
			//1,2
			else if( (e.getX()>100 && e.getX()<=200) && (e.getY()<=100) ){
				logica.putX(2);
				x(getGraphics(), 100,0);
			}
			//1,3
			else if( (e.getX()>200 && e.getX()<=300) && (e.getY()<=100) ){
				logica.putX(3);
				x(getGraphics(), 200,0);

			}
			
			//2,1
			else if( (e.getX()<=100 && e.getY()>100) && (e.getY()<=200) ){
				logica.putX(4);
				x(getGraphics(), 0,100);
			}
			//2,2
			else if( (e.getX()>100)&&(e.getX()<=200) && (e.getY()>100)&&(e.getY()<=200) ){
				logica.putX(5);
				x(getGraphics(), 100,100);
			}
			//2,3
			else if( (e.getX()>200) && (e.getX()<=300) && e.getY()>100 && e.getY()<=200){
				logica.putX(6);
				x(getGraphics(), 200,100);
			}
			//3,1
			else if( (e.getX()<=100) && (e.getY()>200) && e.getY()<=300 ){
				logica.putX(7);
				x(getGraphics(), 0,200);
			}
			//3,2
			else if( (e.getX()>100) && (e.getX()<=200) && e.getY()>200 && e.getY()<=300){
				logica.putX(8);
				x(getGraphics(), 100,200);
			}
			//3,3
			else if( (e.getX()>200)&&(e.getX()<=300) && (e.getY()>200)&&(e.getY()<=300) ){
				logica.putX(9);
				x(getGraphics(), 200,200);
			}
		}
			
			
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
