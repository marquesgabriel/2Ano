package br.edu.ifpr.app.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import br.edu.ifpr.app.banco.vendedor.VendedorDB;
import br.edu.ifpr.app.banco.vendedor.VendedorDao;

public class Vendedor extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TrataBotao tratador = new TrataBotao();
	
//	BOTOES
	JButton inserir = new JButton("Inserir");
	JTextField txfNome = new JTextField();
	
	public Vendedor(){
		super("Vendedor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vendedor.class.getResource("/br/edu/ifpr/images/user_suit.png")));
		getContentPane().setLayout(null);		
//		BOUNDS PARA BOTOES
		inserir.setBounds(107, 147, 90, 20);
		
//		LABELS
		JLabel lbNome = new JLabel("Nome:");
		
//		LABEL FOR
		lbNome.setLabelFor(txfNome);
		
//		BOUNDS PARA LABELS
		lbNome.setBounds(24, 69, 47, 20);
//		BOUNDS PARA TXFS
		txfNome.setBounds(81, 69, 150, 20);
		
//		label relogio
		Calendar time = Calendar.getInstance();
		JLabel clock = new JLabel("" +time.getTime());
		
		clock.setBounds(0, 178, 239, 20);
		
//		add
		getContentPane().add(clock);
		getContentPane().add(inserir);
		getContentPane().add(lbNome);
		getContentPane().add(txfNome);
		
		inserir.addActionListener(tratador);
		
//		SETS PADRAO
		this.setSize(306, 232);
//		this.setResizable(false);
		this.setVisible(true);
	}
	
	private class TrataBotao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== inserir){
				if(txfNome.getText() == null){
					JOptionPane.showMessageDialog(null, "Insira um nome para o vendedor");
				}
				else {
					try{
						VendedorDB vendedordb = new VendedorDB();
						VendedorDao vendedorDao= new VendedorDao();
						
						vendedordb.setNome(txfNome.getText());
						vendedorDao.adiciona(vendedordb);
						
						txfNome.setText(null);
						txfNome.requestFocus();
						
						JOptionPane.showMessageDialog(null, "Vendedor inserido.");
					}catch(RuntimeException error){
						JOptionPane.showMessageDialog(null, "Ocorreu algum erro, Tente novamente");
						dispose();
					}
				}
			}
		}
	}
}
