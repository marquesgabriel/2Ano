package br.edu.ifpr.app.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
//	public Connection getConnection(){
	public Connection geraConexao(){
		String url="jdbc:mysql://localhost/flavio";
		String usuario="root";
		String senha="aluno";
//		String senha="root";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e){
			System.out.println("Erro ao gerar conexao");
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao gerar conexao");
			throw new RuntimeException(e);
		}
	}
}
