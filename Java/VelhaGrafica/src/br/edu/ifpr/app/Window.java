package br.edu.ifpr.app;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window(){
	}
	
	public void print(){
		JFrame window = new JFrame();
		Draw desenho = new Draw();
		
		window.add(desenho);
		
		window.setTitle("Graphic Tic Tac Toe");
		window.setSize(300, 300);
		window.setVisible(true);
	}
}
