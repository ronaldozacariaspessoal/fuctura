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
//		conta.setNumero(1001);
//		conta.setSaldo(4800d);
//		conta.setLimite(80000d);
//		
//		ContaDAO contaDao = new ContaDAOImpl();
//		contaDao.salvar(conta);
//		conta.setSaldo(58000d);
//		conta.setLimite(700000d);
//		contaDao.alterar(conta);
//		contaDao.remover(1001);
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
//		
 		PessoaDAO pessoaDAO = new PessoaDAOImpl();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("07392031315");
		pessoa.setIdade(40);
		pessoa.setNome("Jose Pereira");
		pessoa.setSexo("M");
		
		Conta contaPessoa = new Conta();
		contaPessoa.setNumero(1029);
		contaPessoa.setSaldo(35000d);
		contaPessoa.setLimite(70000d);
		
		Endereco enderecoPessoa = new Endereco();
		enderecoPessoa.setComplemento("Casa");
		enderecoPessoa.setNumero(25);
		enderecoPessoa.setRua("Rua Vinte");
		
		pessoa.setConta(contaPessoa);
		pessoa.setEndereco(enderecoPessoa);
		pessoaDAO.salvar(pessoa);
		//pessoaDAO.remover("11392031318");
		
		
		
		
		
		
	}

}
