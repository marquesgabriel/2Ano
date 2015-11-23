package br.edu.ifpr.app.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.edu.ifpr.app.banco.produto.ProdutoDB;
import br.edu.ifpr.app.banco.produto.ProdutoDao;

import java.awt.Toolkit;

public class Produto extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	BOTOES
	JButton inserir = new JButton("Inserir");
	JButton salvar = new JButton("Salvar");
	
	TrataBotao tratador = new TrataBotao();
	
//	LABELS
	JLabel lbNome = new JLabel("Nome:");
	JLabel lbFornecedor = new JLabel("Fornecedor:");
	JLabel lbPreco = new JLabel("Preco:");
	
//	TEXT FIELDS
	JTextField txfNome = new JTextField();
	JTextField txfFornecedor = new JTextField();
	JTextField txfPreco = new JTextField();
	
	public Produto(){
		super("Produto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produto.class.getResource("/br/edu/ifpr/images/basket.png")));
		getContentPane().setLayout(null);
		
//		BOUNDS PARA BOTOES
		inserir.setBounds(10, 10, 90, 20);
		
		
		
//		LABEL FOR
		lbNome.setLabelFor(txfNome);
		lbFornecedor.setLabelFor(txfFornecedor);
		lbPreco.setLabelFor(txfPreco);
		
//		BOUNDS PARA LABELS
		lbNome.setBounds(10, 50, 90, 20);
		lbFornecedor.setBounds(10, 81, 90, 20);
		lbPreco.setBounds(10, 112, 90, 20);
//		BOUNDS PARA TXFS
		txfNome.setBounds(100, 50, 150, 20);
		txfFornecedor.setBounds(100, 81, 150, 20);
		txfPreco.setBounds(100, 112, 150, 20);
		
//		label relogio
		Calendar time = Calendar.getInstance();
		JLabel clock = new JLabel("" +time.getTime());
		
		clock.setBounds(10, 171, 252, 20);
		
		getContentPane().add(clock);
		
//		ADD
		getContentPane().add(inserir);
		
		getContentPane().add(lbNome);
		getContentPane().add(lbFornecedor);
		getContentPane().add(lbPreco);
		
		getContentPane().add(txfNome);
		getContentPane().add(txfFornecedor);
		getContentPane().add(txfPreco);
		
		salvar.setBounds(110, 9, 89, 23);
		getContentPane().add(salvar);
		
		inserir.addActionListener(tratador);
		salvar.addActionListener(tratador);
		
//		SETS PADRAO
		this.setSize(278, 231);
//		this.setResizable(false);
		this.setVisible(true);
	}
	// CONSTRUTOR DE PARAMETROS
	public Produto(int id, String nome, double preco, String fornecedor){
		super("Produto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produto.class.getResource("/br/edu/ifpr/images/basket.png")));
		getContentPane().setLayout(null);
		
//		BOUNDS PARA BOTOES
		inserir.setBounds(10, 10, 90, 20);
		
		txfNome.setText(nome);
		txfFornecedor.setText(fornecedor);
		txfPreco.setText( Double.toString(preco) );
		
		
//		LABEL FOR
		lbNome.setLabelFor(txfNome);
		lbFornecedor.setLabelFor(txfFornecedor);
		lbPreco.setLabelFor(txfPreco);
		
//		BOUNDS PARA LABELS
		lbNome.setBounds(10, 50, 90, 20);
		lbFornecedor.setBounds(10, 78, 90, 20);
		lbPreco.setBounds(10, 109, 90, 20);
//		BOUNDS PARA TXFS
		txfNome.setBounds(100, 50, 150, 20);
		txfFornecedor.setBounds(100, 78, 150, 20);
		txfPreco.setBounds(100, 109, 150, 20);
		
//		label relogio
		Calendar time = Calendar.getInstance();
		JLabel clock = new JLabel("" +time.getTime());
		
		clock.setBounds(10, 171, 252, 20);
		
		getContentPane().add(clock);
		
//		ADD
		getContentPane().add(inserir);
		
		getContentPane().add(lbNome);
		getContentPane().add(lbFornecedor);
		getContentPane().add(lbPreco);
		
		getContentPane().add(txfNome);
		getContentPane().add(txfFornecedor);
		getContentPane().add(txfPreco);
		
		salvar.setBounds(110, 9, 89, 23);
		getContentPane().add(salvar);
		
		inserir.addActionListener(tratador);
		salvar.addActionListener(tratador);
		
//		SETS PADRAO
		this.setSize(278, 231);
//		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void clear(){
		txfNome.setText("");
		txfPreco.setText("");
		txfFornecedor.setText("");
		txfNome.requestFocus();
	}
	
	public void estadoInserir(){
		salvar.setEnabled(false);
	}
	
	public void estadoAlterar(){
		inserir.setEnabled(false);
	}
	
	
	private class TrataBotao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== inserir){
				ProdutoDB produtodb = new ProdutoDB();
				ProdutoDao produtodao = new ProdutoDao();
				
				produtodb.setNome(txfNome.getText());
				produtodb.setPreco(Double.parseDouble(txfPreco.getText()));
				produtodb.setFornecedor(txfFornecedor.getText());
				
				produtodao.adcionar(produtodb);
				clear();
			}
		}
	}
}
