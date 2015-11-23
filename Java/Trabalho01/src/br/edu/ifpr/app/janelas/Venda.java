package br.edu.ifpr.app.janelas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import br.edu.ifpr.app.banco.cliente.ClienteDB;
import br.edu.ifpr.app.banco.produto.ProdutoDB;
import br.edu.ifpr.app.banco.venda.VendaDB;
import br.edu.ifpr.app.banco.venda.VendaDao;
import br.edu.ifpr.app.banco.vendedor.VendedorDB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Venda extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TrataBotao tratador = new TrataBotao();
	
	private JTextField txfIdProduto;
	private JTextField txfCpfCliente;
	JButton inserir = new JButton("Inserir");
	private JTextField txfId_Vendedor;
	
	public Venda() {
		this.setTitle("Venda");
		getContentPane().setLayout(null);
		
		txfIdProduto = new JTextField("Venda");
		txfIdProduto.setText("");
		txfIdProduto.setBounds(100, 48, 169, 20);
		getContentPane().add(txfIdProduto);
		txfIdProduto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id do Produto:");
		lblNewLabel.setBounds(10, 48, 91, 20);
		getContentPane().add(lblNewLabel);
		
		txfCpfCliente = new JTextField();
		txfCpfCliente.setBounds(110, 79, 159, 20);
		getContentPane().add(txfCpfCliente);
		txfCpfCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF/CNPJ do Cliente:");
		lblNewLabel_1.setBounds(10, 79, 103, 29);
		getContentPane().add(lblNewLabel_1);
		
		inserir.setBounds(100, 157, 89, 23);
		getContentPane().add(inserir);
		
		JLabel lbId_Vendedor = new JLabel("Id do Vendedor");
		lbId_Vendedor.setBounds(10, 119, 91, 14);
		getContentPane().add(lbId_Vendedor);
		
		txfId_Vendedor = new JTextField();
		lbId_Vendedor.setLabelFor(txfId_Vendedor);
		txfId_Vendedor.setBounds(100, 116, 169, 20);
		getContentPane().add(txfId_Vendedor);
		txfId_Vendedor.setColumns(10);
		
		inserir.addActionListener(tratador);
		this.setSize(282, 224);
		setResizable(false);
		this.setVisible(true);
		
	}
	
	public void clear(){
		txfCpfCliente.setText(null);
		txfIdProduto.setText(null);
		txfId_Vendedor.setText(null);
		txfIdProduto.requestFocus();
	}
	
	private class TrataBotao implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == inserir){
				if(txfCpfCliente.getText() == null || txfIdProduto == null){
					JOptionPane.showMessageDialog(null, "Erro, campo(s) vazio(s)!");
				}
				VendaDB vendadb = new VendaDB();
				VendaDao vendadao = new VendaDao();
				
				ClienteDB tmp1 = new ClienteDB();
				tmp1.setCpf(txfCpfCliente.getText());
				vendadb.setCliente(tmp1);
				
				ProdutoDB tmp2 = new ProdutoDB();
				tmp2.setId(Integer.parseInt(txfIdProduto.getText() ) );
				vendadb.setProduto(tmp2);
				
				VendedorDB tmp3 = new VendedorDB();
				tmp3.setId(Integer.parseInt(txfId_Vendedor.getText() ) );
				vendadb.setVendedor(tmp3);
				
				vendadao.adiciona(vendadb);
				
				JOptionPane.showMessageDialog(null, "Venda inserida com sucesso!");
				clear();
				dispose();
			}
		}	
	}
}
