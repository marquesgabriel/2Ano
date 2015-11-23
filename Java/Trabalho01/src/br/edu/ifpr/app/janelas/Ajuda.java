package br.edu.ifpr.app.janelas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Ajuda extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ajuda(){
		super("Ajuda");
		JTextArea ajuda = new JTextArea();
		ajuda.setText("Para cadastrar basta clicar no Menu e no Item Desejado. \nPreencha os campos e Decida o que fazer");
		ajuda.setEnabled(false);
		
		JLabel author = new JLabel("Gabriel. Naturallis™ ");
		author.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.setLayout(new BorderLayout() );
		this.add(author, BorderLayout.SOUTH);
		this.add(ajuda, BorderLayout.NORTH);
		this.setSize(350, 100);
		this.setResizable(false);
		
		this.setVisible(true);
	}
}
