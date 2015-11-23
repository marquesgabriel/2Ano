package br.edu.ifpr.app.banco.venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.app.banco.ConnectionFactory;
import br.edu.ifpr.app.banco.cliente.ClienteDB;
import br.edu.ifpr.app.banco.produto.ProdutoDB;
import br.edu.ifpr.app.banco.venda.VendaDB;
import br.edu.ifpr.app.banco.vendedor.VendedorDB;

public class VendaDao {
	// a conexão com o banco de dados
			private Connection con;

			public VendaDao() {
				this.con = new ConnectionFactory().geraConexao();
			}

			public void adiciona(VendaDB venda) {
				String sql = "insert into venda (cpf_cliente, id_produto, idVendedor)"
						+ "values(?,?,?);";

				try {
					// prepared statement para inserção
					PreparedStatement stmt = con.prepareStatement(sql);

					// seta os valores

//					stmt.setObject(1, venda.getCliente().getCpf());
					String a=venda.getCliente().getCpf();
					stmt.setObject(1, a);
//					System.out.println("CPF: "+a);
					
//					stmt.setObject(2, venda.getProduto().getId());
					long b=venda.getProduto().getId();
					stmt.setObject(2, b);
//					System.out.println("Produto: "+b);
					
//					stmt.setObject(3, venda.getVendedor().getId());
					long c=venda.getVendedor().getId();
					stmt.setObject(3, c);
//					System.out.println("vendedor: "+c);
					
					 System.out.println("Venda Cadastrada!");

					// executa
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			public List<VendaDB> getLista() {
				try {
					List<VendaDB> vendas = new ArrayList<VendaDB>();
					PreparedStatement stmt = this.con
							.prepareStatement("select * from venda");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						// criando o objeto venda
						VendaDB venda = new VendaDB();
						
						ClienteDB clientedb = new ClienteDB();
						clientedb.setCpf(rs.getString("cpf_cliente"));
						venda.setCliente(clientedb);

						venda.setId(rs.getInt("id") );
						
						ProdutoDB produtodb = new ProdutoDB();
						produtodb.setId(rs.getInt("id_produto"));
						venda.setProduto(produtodb);	
						
						VendedorDB vendedordb = new VendedorDB();
						vendedordb.setId(rs.getInt("idVendedor"));
						venda.setVendedor(vendedordb);
						
						// adicionando o objeto à lista
						vendas.add(venda);
					}
					rs.close();
					stmt.close();
					return vendas;
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
			public void remove(VendaDB venda) {
				try {
					PreparedStatement stmt = con.prepareStatement("delete from venda where id LIKE ?");
					stmt.setInt(1, venda.getId());
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
}
