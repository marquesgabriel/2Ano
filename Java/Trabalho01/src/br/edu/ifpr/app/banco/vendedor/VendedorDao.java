package br.edu.ifpr.app.banco.vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.app.banco.ConnectionFactory;
import br.edu.ifpr.app.banco.vendedor.VendedorDB;

public class VendedorDao {
	// a conexão com o banco de dados
		private Connection con;

		public VendedorDao() {
			this.con = new ConnectionFactory().geraConexao();
		}

		public void adiciona(VendedorDB vendedor) {
			String sql = "insert into vendedor "
					+ "(nome)" + " values (?)";

			try {
				// prepared statement para inserção
				PreparedStatement stmt = con.prepareStatement(sql);

				// seta os valores

				stmt.setString(1, vendedor.getNome());

				// executa
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public List<VendedorDB> getLista() {
			try {
				List<VendedorDB> vendedores = new ArrayList<VendedorDB>();
				PreparedStatement stmt = this.con
						.prepareStatement("select * from vendedor");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto vendedor
					VendedorDB vendedor = new VendedorDB();
					
					vendedor.setId(rs.getInt("id"));
					vendedor.setNome(rs.getString("nome"));
					
					// adicionando o objeto à lista
					vendedores.add(vendedor);
				}
				rs.close();
				stmt.close();
				return vendedores;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void altera(VendedorDB vendedor) {
			String sql = "update vendedor set nome = ?"
					+ " where id LIKE ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, vendedor.getNome());
				stmt.setInt(2, vendedor.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void remove(VendedorDB vendedor) {
			try {
				PreparedStatement stmt = con.prepareStatement("delete from vendedor where id LIKE ?");
				stmt.setInt(1, vendedor.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
