package br.edu.ifpr.app.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.edu.ifpr.app.banco.fornecedor.FornecedorDB;
import br.edu.ifpr.app.banco.fornecedor.FornecedorDao;

import java.awt.Toolkit;

public class Fornecedor extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	BOTOES
	JButton inserir = new JButton("Inserir");
	
	TrataBotao tratador = new TrataBotao();
	
//	LABELS
	JLabel lbNome = new JLabel("Nome:");
	JLabel lbCNPJ = new JLabel("CNPJ:");
	JLabel lbTelefone = new JLabel("Telefone");
	JLabel lbEndereco = new JLabel("Endereço:");
	
//	TEXT FIELDS
	JTextField txfNome = new JTextField();
	JTextField txfCNPJ = new JTextField();
	JTextField txfTelefone = new JTextField();
	JTextField txfEndereco = new JTextField();

	
	public Fornecedor(){
		super("Fornecedor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedor.class.getResource("/br/edu/ifpr/images/user_orange.png")));
		getContentPane().setLayout(null);
		
		
//		BOUNDS PARA BOTOES
		inserir.setBounds(10, 10, 90, 20);		
		
//		LABEL FOR
		lbNome.setLabelFor(txfNome);
		lbCNPJ.setLabelFor(txfCNPJ);
		lbTelefone.setLabelFor(txfTelefone);
		lbEndereco.setLabelFor(txfEndereco);
		
//		BOUNDS PARA LABELS
		lbNome.setBounds(10, 50, 90, 20);
		lbCNPJ.setBounds(10, 80, 90, 20);
		lbTelefone.setBounds(10, 110, 90, 20);
		lbEndereco.setBounds(10, 140, 90, 20);
//		BOUNDS PARA TXFS
		txfNome.setBounds(100, 50, 150, 20);
		txfCNPJ.setBounds(100, 80, 150, 20);
		txfTelefone.setBounds(100, 110, 150, 20);
		txfEndereco.setBounds(100, 140, 150, 20);
		
//		label relogio
		Calendar time = Calendar.getInstance();
		JLabel clock = new JLabel("" +time.getTime());
		
		clock.setBounds(10, 171, 249, 20);
		
		getContentPane().add(clock);
		
//		ADD
		getContentPane().add(inserir);
		
		getContentPane().add(lbNome);
		getContentPane().add(lbCNPJ);
		getContentPane().add(lbTelefone);
		getContentPane().add(lbEndereco);
		
		getContentPane().add(txfNome);
		getContentPane().add(txfCNPJ);
		getContentPane().add(txfTelefone);
		getContentPane().add(txfEndereco);
		
		inserir.addActionListener(tratador);
		
//		SETS PADRAO
		this.setSize(275, 236);
//		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void clear(){
		txfCNPJ.setText(null);
		txfNome.setText(null);
		txfEndereco.setText(null);
		txfTelefone.setText(null);
		txfNome.requestFocus();
	}
	
	private class TrataBotao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== inserir){
				FornecedorDB fornecedordb = new FornecedorDB();
				FornecedorDao fornecedordao = new FornecedorDao();
				
				fornecedordb.setNome(txfNome.getText());
				fornecedordb.setCnpj(txfCNPJ.getText());
				fornecedordb.setEndereco(txfEndereco.getText());
				fornecedordb.setTelefone(txfTelefone.getText());
				
				fornecedordao.adiciona(fornecedordb);
				clear();
			}
		}

	}
	
}
