package br.edu.ifpr.app.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TableCreator {
	private Connection con;
	
	public TableCreator(){
		this.con = new ConnectionFactory().geraConexao();
	}
	
	public void criaCliente(){
		String sql="create table IF NOT EXISTS cliente( "
				+ "nome varchar (50),"
				+ "cpf varchar(15),"
				+ "telefone varchar (20),"
				+ "endereco varchar(100),"
				+ "primary key (cpf) );" ;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		}catch(SQLException err){
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela Cliente");
		}
	}
	public void criaProduto(){
		String sql="create table IF NOT EXISTS produto("
				+ "nome varchar(100),"
				+ "id int AUTO_INCREMENT,"
				+ "fornecedor varchar(100),"
				+ "preco double (6,2),"
				+ "PRIMARY KEY (id),"
				+ "FOREIGN KEY (fornecedor) REFERENCES fornecedor(cnpj) );" ;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		}catch(SQLException err){
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela Produto");
		}
	}
	public void criaFornecedor(){
		String sql="create table IF NOT EXISTS fornecedor( "
				+ "nome varchar (50),"
				+ "cnpj varchar(15),"
				+ "telefone varchar (20),"
				+ "endereco varchar(100),"
				+ "primary key (cnpj) );" ;
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		}catch(SQLException err){
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela Fornecedor");
		}
	}
	public void criaVendedor(){
		String sql="CREATE TABLE IF NOT EXISTS vendedor ("
				+ "id int auto_increment ,"
				+ "nome varchar(100),"
				+ "primary key(id) );";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		}catch(SQLException err){
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela Vendedor");
		}
	}
	public void criaVenda(){
		String sql="CREATE TABLE IF NOT EXISTS venda ("
				+ "cpf_cliente varchar(11),"
				+ "id int auto_increment,"
				+ "idVendedor int,"
				+ " id_produto int,"
				+ " primary key(id),"
				+ " foreign key (cpf_cliente) references cliente(cpf),"
				+ "foreign key (id_produto) references produto(id),"
				+ "foreign key (idVendedor) references vendedor(id) );";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		}catch(SQLException err){
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela Venda");
		}
	}
}
