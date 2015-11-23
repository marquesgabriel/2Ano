package br.edu.ifpr.app.banco.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.app.banco.produto.ProdutoDB;
import br.edu.ifpr.app.banco.*;

public class ProdutoDao {
	private Connection con;

	public ProdutoDao() {
		this.con = new ConnectionFactory().geraConexao();
		System.out.println("Conexão estabelecida com sucesso");
	}
	
	public void adcionar(ProdutoDB produto){
		String sql = "insert into produto (preco,nome,fornecedor) values (?,?,?)";

		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, produto.getPreco());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getFornecedor());
						
			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Dados inseridos com sucesso");
		} catch (SQLException erro){
			throw new RuntimeException(erro);
		}
	}
	
	public List<ProdutoDB> getLista(){
				
		try {
			PreparedStatement stmt;
			List<ProdutoDB> produtos = new ArrayList<ProdutoDB>();
			stmt = this.con.prepareStatement("select * from produto");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				ProdutoDB produto = new ProdutoDB();
				produto.setId(rs.getInt("id"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setNome(rs.getString("nome"));
				produto.setFornecedor(rs.getString("fornecedor"));
				
				produtos.add(produto);	
			}
			rs.close();
			stmt.close();
			return produtos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void alterar(ProdutoDB produto){
		String sql = "update produto set nome = ?, preco = ?, fornecedor = ? where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setString(3, produto.getFornecedor());
			stmt.setLong(  5, produto.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void remove(ProdutoDB produto){
		try {
			PreparedStatement stmt = con.prepareStatement("delete from produto where id = ?");
			stmt.setLong(1, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
