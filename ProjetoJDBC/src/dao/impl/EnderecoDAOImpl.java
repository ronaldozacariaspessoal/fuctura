package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.EnderecoDAO;
import model.Endereco;
import model.util.Conexao;

public class EnderecoDAOImpl implements EnderecoDAO{
	
	Conexao conexao = new Conexao();


	@Override
	public Integer salvar(Endereco endereco) {
		Connection conn = conexao.getConnetion();
		
		Integer id = null;
		
		String sql = "INSERT INTO ENDERECO(RUA, NUMERO, COMPLEMENTO)"
				+ "VALUES(?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				id = rs.getInt(4);
				System.out.println(" Insertede ID -" + id);
			}
			
		} catch (SQLException e){
			System.out.println("Erro ao inserir endereco no banco"
					+ e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		return id;
	}

	@Override
	public void alterar(Endereco endereco) {
		Connection conn = conexao.getConnetion();
		
		String sql = "UPDATE ENDERECO SET RUA = ?, NUMERO = ?, COMPLEMENTO = ? WHERE ID_ENDERECO = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.setInt(4, endereco.getId_endereco());
			ps.executeUpdate();
			System.out.println("Endereço Atualizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar endereço no banco " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		
	}

	@Override
	public void remover(int id_endereco) {
	Connection conn = conexao.getConnetion();
		
		String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id_endereco);
			ps.execute();
			System.out.println("Endereco Deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar endereço no banco " + e.getMessage());
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar endereço no banco " + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
		
	}

	@Override
	public Endereco pesquisar(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
