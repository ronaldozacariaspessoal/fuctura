package controller;

import dao.ContaDAO;
import dao.EnderecoDAO;
import dao.impl.ContaDAOImpl;
import dao.impl.EnderecoDAOImpl;
import model.Conta;
import model.Endereco;

public class Principal {

	public static void main(String[] args) {
		
		
		Conta conta  = new Conta();
		conta.setNumero(1011);
		conta.setSaldo(4800d);
		conta.setLimite(80000d);
		
		ContaDAO contaDao = new ContaDAOImpl();
		contaDao.salvar(conta);
		conta.setSaldo(58000d);
		conta.setLimite(700000d);
		contaDao.alterar(conta);
		//contaDao.remover(1001);
		
		Endereco endereco = new Endereco();
		endereco.setRua("Rua Z");
		endereco.setNumero(12);
		endereco.setComplemento("Casa");
		
		EnderecoDAO enderecoDao = new EnderecoDAOImpl();
		enderecoDao.salvar(endereco);
		endereco.setRua("Rua T");
		endereco.setNumero(10);
		endereco.setComplemento("Casa");
		endereco.setId_endereco(1);
		enderecoDao.alterar(endereco);
		enderecoDao.remover(6);
		
		
		
		
		
	}

}
