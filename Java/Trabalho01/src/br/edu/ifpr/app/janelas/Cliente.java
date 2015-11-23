package br.edu.ifpr.app.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.ifpr.app.banco.cliente.ClienteDB;
import br.edu.ifpr.app.banco.cliente.ClienteDao;

import java.awt.Toolkit;

public class Cliente extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton inserir = new JButton("Inserir");
	private JButton salvar = new JButton("Salvar");
	
//	LABELS
	JLabel lbNome = new JLabel("Nome:");
	JLabel lbCPF = new JLabel("CPF/CNPJ:");
	JLabel lbTelefone = new JLabel("Telefone");
	JLabel lbEndereco = new JLabel("Endereço:");
	
//	TEXT FIELDS
	JTextField txfNome = new JTextField();
	JTextField txfCPF = new JTextField();
	JTextField txfTelefone = new JTextField();
	JTextField txfEndereco = new JTextField();
	
//	CONSTRUTOR INSERIR
	public Cliente(){
			super("Cliente");
			
			setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/br/edu/ifpr/images/user.png")));
			getContentPane().setLayout(null);
			
//			BOUNDS PARA BOTOES
			inserir.setBounds(10, 10, 90, 20);
			salvar.setBounds(110, 9, 89, 23);
			
//			LABEL FOR
			lbNome.setLabelFor(txfNome);
			lbCPF.setLabelFor(txfCPF);
			lbTelefone.setLabelFor(txfTelefone);
			lbEndereco.setLabelFor(txfEndereco);

			
//			BOUNDS PARA LABELS
			lbNome.setBounds(10, 41, 90, 20);
			lbCPF.setBounds(10, 72, 90, 20);
			lbTelefone.setBounds(10, 103, 90, 20);
			lbEndereco.setBounds(10, 134, 90, 20);
//			BOUNDS PARA TXFS
			txfNome.setBounds(100, 41, 150, 20);
			txfCPF.setBounds(100, 72, 150, 20);
			txfTelefone.setBounds(100, 103, 150, 20);
			txfEndereco.setBounds(100, 134, 150, 20);
			
//			label relogio
			Calendar time = Calendar.getInstance();
			JLabel clock = new JLabel("" +time.getTime());
			
			clock.setBounds(10, 165, 284, 20);
			
			getContentPane().add(clock);
//			ADD OS BOTOES
			getContentPane().add(inserir);
			getContentPane().add(salvar);
//			ADD AS LABELS
			getContentPane().add(lbNome);
			getContentPane().add(lbCPF);
			getContentPane().add(lbTelefone);
			getContentPane().add(lbEndereco);
//			ADD OS TXFS
			getContentPane().add(txfNome);
			getContentPane().add(txfCPF);
			getContentPane().add(txfTelefone);
			getContentPane().add(txfEndereco);
			
//			SETS PADRAO
			this.setSize(310, 226);
//			this.setResizable(false);
			this.setVisible(true);
			
			inserir.addActionListener(new TrataBotao());
			salvar.addActionListener(new TrataBotao());
			
	}
	
//	CONSTRUTOR SALVAR
	public Cliente(String nome, String cpf, String telefone, String endereco){
		super("Cliente");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/br/edu/ifpr/images/user.png")));
		getContentPane().setLayout(null);
		
//		BOUNDS PARA BOTOES
		inserir.setBounds(10, 10, 90, 20);
		salvar.setBounds(110, 9, 89, 23);
		
//		LABEL FOR
		lbNome.setLabelFor(txfNome);
		lbCPF.setLabelFor(txfCPF);
		lbTelefone.setLabelFor(txfTelefone);
		lbEndereco.setLabelFor(txfEndereco);

		
//		BOUNDS PARA LABELS
		lbNome.setBounds(10, 41, 90, 20);
		lbCPF.setBounds(10, 72, 90, 20);
		lbTelefone.setBounds(10, 103, 90, 20);
		lbEndereco.setBounds(10, 134, 90, 20);
//		BOUNDS PARA TXFS
		txfNome.setBounds(100, 41, 150, 20);
		txfCPF.setBounds(100, 72, 150, 20);
		txfTelefone.setBounds(100, 103, 150, 20);
		txfEndereco.setBounds(100, 134, 150, 20);
		
//		label relogio
		Calendar time = Calendar.getInstance();
		JLabel clock = new JLabel("" +time.getTime());
		
		clock.setBounds(10, 165, 284, 20);
		
		getContentPane().add(clock);
//		ADD OS BOTOES
		getContentPane().add(inserir);
		getContentPane().add(salvar);
//		ADD AS LABELS
		getContentPane().add(lbNome);
		getContentPane().add(lbCPF);
		getContentPane().add(lbTelefone);
		getContentPane().add(lbEndereco);
//		ADD OS TXFS
		getContentPane().add(txfNome);
		getContentPane().add(txfCPF);
		getContentPane().add(txfTelefone);
		getContentPane().add(txfEndereco);
		
//		SETS PADRAO
		this.setSize(310, 226);
//		this.setResizable(false);
		this.setVisible(true);
		
		inserir.addActionListener(new TrataBotao());
		salvar.addActionListener(new TrataBotao());
		
		txfNome.setText(nome);
		txfCPF.setText(cpf);
		txfTelefone.setText(telefone);
		txfEndereco.setText(endereco);
				
}
	
	public void clear(){
		txfNome.setText("");
		txfCPF.setText("");
		txfTelefone.setText("");
		txfEndereco.setText("");
		txfNome.requestFocus();
	}
	
	public void estadoInserir(){
		salvar.setEnabled(false);
	}
	
	public void estadoAlterar(){
		inserir.setEnabled(false);
		txfCPF.setEditable(false);
	}
	
	private class TrataBotao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if( e.getSource()== inserir ){
				try{
					ClienteDB clientedb = new ClienteDB();
					ClienteDao clientedao = new ClienteDao();
					
					clientedb.setNome(txfNome.getText() );
					clientedb.setCpf(txfCPF.getText() );
					clientedb.setTelefone(txfTelefone.getText() );
					clientedb.setEndereco(txfEndereco.getText() );
					clientedao.adiciona(clientedb);
					JOptionPane.showMessageDialog(null, "Cliente inserido!");
					clear();
				}catch(RuntimeException error){
					JOptionPane.showMessageDialog(null, "CPF Repetido, tente novamente");
					dispose();
				}
				
			}
			else if(e.getSource()== salvar){
				ClienteDB clientedb = new ClienteDB();
				ClienteDao clientedao = new ClienteDao();
				
				clientedb.setNome(txfNome.getText() );
				clientedb.setCpf(txfCPF.getText() );
				clientedb.setTelefone(txfTelefone.getText() );
				clientedb.setEndereco(txfEndereco.getText() );
				
				clientedao.altera(clientedb);
				JOptionPane.showMessageDialog(null, "Cliente alterado com Sucesso");
				dispose();
				
			}
		}
	}
}
