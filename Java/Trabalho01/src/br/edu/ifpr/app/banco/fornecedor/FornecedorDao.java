package br.edu.ifpr.app.banco.fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.app.banco.ConnectionFactory;

public class FornecedorDao {
	// a conexão com o banco de dados
	private Connection con;

	public FornecedorDao() {
		this.con = new ConnectionFactory().geraConexao();
	}
	
	public void adiciona(FornecedorDB fornecedor) {
		String sql = "insert into fornecedor "
				+ "(nome,cnpj,telefone,endereco)" + " values (?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCnpj());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getEndereco());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<FornecedorDB> getLista() {
		try {
			List<FornecedorDB> fornecedores = new ArrayList<FornecedorDB>();
			PreparedStatement stmt = this.con
					.prepareStatement("select * from fornecedor");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Cliente
				FornecedorDB fornecedor = new FornecedorDB();
				
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setEndereco(rs.getString("endereco"));
				
				// adicionando o objeto � lista
				fornecedores.add(fornecedor);
			}
			rs.close();
			stmt.close();
			return fornecedores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
