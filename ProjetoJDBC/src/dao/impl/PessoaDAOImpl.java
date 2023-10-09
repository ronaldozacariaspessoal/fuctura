package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		String sql  = "INSERT INTO PESSOA(NOME, CPF, SEXO, IDADE, ID_ENDERECO, NUMERO_CONTA)"
				+"VALUES(?, ?, ?, ?, ?, ?)";
		
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
			System.out.println("Inserido com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco" + e.getMessage());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa pesquisar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
