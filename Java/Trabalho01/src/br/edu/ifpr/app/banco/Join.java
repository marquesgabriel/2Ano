package br.edu.ifpr.app.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import br.edu.ifpr.app.banco.cliente.ClienteDB;
import br.edu.ifpr.app.banco.fornecedor.FornecedorDB;
import br.edu.ifpr.app.banco.produto.ProdutoDB;
import br.edu.ifpr.app.banco.venda.VendaDB;

public class Join {
	Connection con = new ConnectionFactory().geraConexao();
	DefaultTableModel dtm;
	
	public DefaultTableModel produtosPorCliente(){
		DefaultTableModel dtm = new DefaultTableModel();
		
		String sql="SELECT produto.nome AS Produto,"
				+ "cliente.nome AS Cliente"
				+ " FROM venda"
				+ " JOIN cliente ON venda.cpf_cliente = cliente.cpf"
				+ " JOIN produto ON venda.id_produto = produto.id;";
		try {
			List<VendaDB> join = new ArrayList<VendaDB>();
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto venda
				VendaDB venda = new VendaDB();
				
				ClienteDB clientedb = new ClienteDB();
				clientedb.setNome(rs.getString("Cliente"));
				venda.setCliente(clientedb);
				
				ProdutoDB produtodb = new ProdutoDB();
				produtodb.setNome(rs.getString("Produto"));
				venda.setProduto(produtodb);
				
				// adicionando o objeto à lista
				join.add(venda);
			}
			rs.close();
			stmt.close();
			
			Vector pai = new Vector();
			Vector filho;
			Vector nomeColunas = new Vector();
			
			nomeColunas.add("Produto");
			nomeColunas.add("Cliente");
			
			for(VendaDB l : join){
				filho = new Vector();
				filho.add(l.getProduto().getNome());
				filho.add(l.getCliente().getNome());
				
				pai.add(filho);
			}
			
			dtm = new DefaultTableModel( pai, nomeColunas);
			
			return dtm;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public DefaultTableModel produtosPorFornecedor(){
		String sql="SELECT produto.nome AS Produto,"
				+ " fornecedor.nome AS Fornecedor"
				+ " FROM produto"
				+ " JOIN fornecedor ON produto.fornecedor = fornecedor.cnpj;";
		
		try {
			List<ProdutoDB> join = new ArrayList<ProdutoDB>();
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto produto
				ProdutoDB produto = new ProdutoDB();
				
				produto.setFornecedor(rs.getString("Fornecedor"));
				
				produto.setNome(rs.getString("Produto"));
				
				// adicionando o objeto à lista
				join.add(produto);
			}
			rs.close();
			stmt.close();
			
			Vector pai = new Vector();
			Vector filho;
			Vector nomeColunas = new Vector();
			
			nomeColunas.add("Produto");
			nomeColunas.add("Fornecedor");
			
			for(ProdutoDB l : join){
				filho = new Vector();
				filho.add(l.getNome());
				filho.add(l.getFornecedor());
				
				pai.add(filho);
			}
			
			dtm = new DefaultTableModel( pai, nomeColunas);
			
			return dtm;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public DefaultTableModel fornecedorDeProdutoPorCliente(){
		String sql="SELECT fornecedor.nome AS Fornecedor,"
				+ " produto.nome AS Produto,"
				+ " cliente.nome AS Cliente"
				+ " FROM venda"
				+ " JOIN cliente ON venda.cpf_cliente = cliente.cpf"
				+ " JOIN produto ON venda.id_produto = produto.id"
				+ " JOIN fornecedor ON produto.fornecedor = fornecedor.cnpj ;";
		try {
			
			List<VendaDB> join = new ArrayList<VendaDB>();
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				VendaDB venda = new VendaDB();
				
				ProdutoDB produtodb = new ProdutoDB();
				
				produtodb.setFornecedor(rs.getString("Fornecedor"));
				
				ClienteDB clientedb = new ClienteDB();
				clientedb.setNome(rs.getString("Cliente"));
				venda.setCliente(clientedb);
				
				
				produtodb.setNome(rs.getString("Produto"));
				venda.setProduto(produtodb);
				
				// adicionando o objeto à lista
				join.add(venda);
			}
			rs.close();
			stmt.close();
			
			Vector pai = new Vector();
			Vector filho;
			Vector nomeColunas = new Vector();
			
			nomeColunas.add("Fornecedor");
			nomeColunas.add("Produto");
			nomeColunas.add("Cliente");
			
			for(VendaDB l : join){
				filho = new Vector();
				filho.add(l.getProduto().getFornecedor());
				filho.add(l.getProduto().getNome());
				filho.add(l.getCliente().getNome());
				
				pai.add(filho);
			}
			
			dtm = new DefaultTableModel( pai, nomeColunas);
			
			return dtm;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}