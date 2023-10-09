package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ContaDAO;
import model.Conta;
import model.util.Conexao;

public class ContaDAOImpl implements ContaDAO{
	
	Conexao conexao = new Conexao();

	@Override
	public void salvar(Conta conta) {
		Connection conn = conexao.getConnetion();
		String sql = "INSERT INTO CONTA(NUMERO, SALDO , LIMITE)"
				+ "VALUES(?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, conta.getNumero());
			ps.setDouble(2, conta.getSaldo());
			ps.setDouble(3, conta.getLimite());
			ps.execute();
			System.out.println("Conta inserida com sucesso");
		} catch (SQLException e){
			System.out.println("Erro ao inserir conta no banco"
					+ e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		
		
	}

	@Override
	public void alterar(Conta conta) {
		Connection conn = conexao.getConnetion();
		
		String sql = "UPDATE CONTA SET SALDO = ?, LIMITE = ? WHERE NUMERO = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, conta.getSaldo());
			ps.setDouble(2, conta.getLimite());
			ps.setInt(3, conta.getNumero());
			ps.executeUpdate();
			System.out.println("Conta Atualizada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar conta no banco " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	
	
		
	}

	@Override
	public void remover(int numero) {
		Connection conn = conexao.getConnetion();
		
		String sql = "DELETE FROM CONTA WHERE NUMERO = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.execute();
			System.out.println("Conta Deletada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar onta no banco " + e.getMessage());
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar conta no banco " + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
		

		
	}

	@Override
	public Conta pesquisar(int numero) {
		Connection conn  = conexao.getConnetion();
		Conta conta = new Conta();
		
		String sql = "SELECT * FROM CONTA WHERE NUMERO  = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				conta.setNumero(rs.getInt("NUMERO"));
				conta.setSaldo(rs.getDouble("SALDO"));
				conta.setLimite(rs.getDouble("LIMITE"));
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar" + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		return conta;
	}

	@Override
	public List<Conta> listarTodos() {
		Connection conn = conexao.getConnetion();
		List<Conta> retorno = new ArrayList<Conta>();
		
		String sql = "SELECT * FROM CONTA";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Conta conta = new Conta();
				conta.setNumero(rs.getInt("NUMERO"));
				conta.setSaldo(rs.getDouble("SALDO"));
				conta.setLimite(rs.getDouble("LIMITE"));
				retorno.add(conta);
			}
			
		} catch (Exception e) {
			System.out.print("Erro ao pesquisar Conta" + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		
		return retorno;
	}
	

}
