package br.edu.ifpr.app.banco.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import br.edu.ifpr.app.banco.ConnectionFactory;

public class ClienteDao {

	// a conexão com o banco de dados
	private Connection con;

	public ClienteDao() {
		this.con = new ConnectionFactory().geraConexao();
	}

	public void adiciona(ClienteDB cliente) {
		String sql = "insert into cliente "
				+ "(nome,cpf,telefone,endereco)" + " values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEndereco());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<ClienteDB> getLista() {
		try {
			List<ClienteDB> clientes = new ArrayList<ClienteDB>();
			PreparedStatement stmt = this.con
					.prepareStatement("select * from cliente");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Cliente
				ClienteDB cliente = new ClienteDB();
				
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				
				// adicionando o objeto à lista
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<ClienteDB> pesquisa(String nome) {
		try {
			List<ClienteDB> clientes = new ArrayList<ClienteDB>();
			PreparedStatement stmt = con.prepareStatement("select * from cliente where nome like ?");
			stmt.setString(1, "%"+nome+"%");
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Cliente
				ClienteDB cliente = new ClienteDB();
				
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				
				// adicionando o objeto à lista
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(ClienteDB cliente) {
		String sql = "update cliente set nome = ?, telefone = ?,"
				+ "endereco = ? where cpf LIKE ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(ClienteDB cliente) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete from cliente where cpf LIKE ?");
			stmt.setString(1, cliente.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
