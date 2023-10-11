package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ContaDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import model.Pessoa;
import model.util.Conexao;

public class PessoaDAOImpl implements PessoaDAO{
	
	Conexao conexao = new Conexao();
	EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
	ContaDAO contaDAO = new ContaDAOImpl();

	@Override
	public void salvar(Pessoa pessoa) {
		Connection conn = conexao.getConnetion();
		
		String sql  = "INSERT INTO PESSOA(NOME, CPF, SEXO, IDADE, ID_ENDERECO, NUMERO_CONTA) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			Integer id = this.enderecoDAO.salvar(pessoa.getEndereco());
			this.contaDAO.salvar(pessoa.getConta());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getSexo());
			ps.setInt(4, pessoa.getIdade());
			ps.setInt(5, id);
			ps.setInt(6, pessoa.getConta().getNumero());
			ps.execute();
			System.out.println("Pessoa inserida com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa no banco" + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
		
	}

	@Override
	public void alterar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String cpf) {
		Connection conn = conexao.getConnetion();
		Pessoa p = pesquisar(cpf);
		
		String sql = "DELETE FROM PESSOA WHERE CPF = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.execute();
			System.out.println("Pessoa deletada com sucesso");
			contaDAO.remover(p.getConta().getNumero());
			enderecoDAO.remover(p.getEndereco().getId_endereco());
			
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar pessoa" + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
	}

	@Override
	public Pessoa pesquisar(String cpf) {
		Connection conn = conexao.getConnetion();
		Pessoa pessoa = new Pessoa();
		String sql = "SELECT * FROM PESSOA WHERE CPF = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				pessoa.setNome(rs.getString("NOME"));
				pessoa.setCpf(rs.getString("CPF"));
				pessoa.setSexo(rs.getString("SEXO"));
				pessoa.setIdade(rs.getInt("IDADE"));
				pessoa.setEndereco(this.enderecoDAO.pesquisar(rs.getInt("ID_ENDERECO")));
				pessoa.setConta(this.contaDAO.pesquisar(rs.getInt("NUMERO_CONTA")));
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar Pessoa" + e.getMessage());
		}

		return pessoa;
	}

	@Override
	public List<Pessoa> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
