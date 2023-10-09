package controller;

import java.util.List;

import dao.ContaDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import dao.impl.ContaDAOImpl;
import dao.impl.EnderecoDAOImpl;
import dao.impl.PessoaDAOImpl;
import model.Conta;
import model.Endereco;
import model.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		
//		Conta conta  = new Conta();
//		conta.setNumero(1016);
//		conta.setSaldo(4800d);
//		conta.setLimite(80000d);
//		
//		ContaDAO contaDao = new ContaDAOImpl();
//		contaDao.salvar(conta);
//		conta.setSaldo(58000d);
//		conta.setLimite(700000d);
//		contaDao.alterar(conta);
//		//contaDao.remover(1001);
//		
//		Endereco endereco = new Endereco();
//		endereco.setRua("Rua Z");
//		endereco.setNumero(12);
//		endereco.setComplemento("Casa");
//		
//		EnderecoDAO enderecoDao = new EnderecoDAOImpl();
//		enderecoDao.salvar(endereco);
//		endereco.setRua("Rua T");
//		endereco.setNumero(10);
//		endereco.setComplemento("Casa");
//		endereco.setId_endereco(1);
//		enderecoDao.alterar(endereco);
//		enderecoDao.remover(6);
//		
//		ContaDAO contaDAO = new ContaDAOImpl();
//		
//		Conta conta1 = contaDAO.pesquisar(1002);
//		System.out.println(conta1.toString());
//		
//		List<Conta> listaConta = contaDAO.listarTodos();
//		for (Conta c : listaConta) {
//			System.out.println(c.toString());
//		}
//		
//		System.out.println("-------------------------------------------------");
//		
//		listaConta.forEach(System.out::println);
//		listaConta.forEach(c -> System.out.println(c));
//		System.out.println("-------------------------------------------------");
		
		PessoaDAO pessoaDAO = new PessoaDAOImpl();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("01392031310");
		pessoa.setIdade(55);
		pessoa.setNome("Maria da Silva");
		pessoa.setSexo("F");
		
		Conta contaPessoa = new Conta();
		contaPessoa.setNumero(1025);
		contaPessoa.setSaldo(5000d);
		contaPessoa.setLimite(10000d);
		
		Endereco enderecoPessoa = new Endereco();
		enderecoPessoa.setComplemento("Apt");
		enderecoPessoa.setNumero(39);
		enderecoPessoa.setRua("Rua Doze");
		
		pessoa.setConta(contaPessoa);
		pessoa.setEndereco(enderecoPessoa);
		pessoaDAO.salvar(pessoa);
		
		
		
		
		
		
	}

}
