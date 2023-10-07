package model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.SQLException;

public class Conexao {
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String user = "postgres";
	private String password = "pwd123";

	public Connection getConnetion() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Banco conectado");
			}

		} catch (Exception e) {
			System.out.println("Erro na conexao com o banco. " + e.getMessage());
		}
		return conn;
	}

	public void fecharConexao(Connection conn) {
		try {
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexao. " + e.getMessage());
		}
	}

}
