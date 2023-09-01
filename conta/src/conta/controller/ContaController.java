package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository
{
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0; 

	@Override
	public void procurarPorNumeros(int numero) 
	{
		var conta = buscarNaCollection(numero);
		
		if (conta != null)
			conta.print();
		else
			System.out.println("\nA conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void listarTodas() 
	{
		for(var conta : listaContas) 
		{
			conta.print();
		}
	}

	@Override
	public void cadastrar(Conta conta) 
	{
		listaContas.add(conta);
		System.out.println("A conta número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) 
	{
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(buscarConta != null) 
		{
			listaContas.set(listaContas.indexOf(buscarConta), conta); 
			System.out.println("\nA conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA conta número: " + conta.getNumero() + " não foi encontrada!");
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null )
		{
			if(listaContas.remove(conta) == true) 
			{
				System.out.println("Sua conta foi deletada com sucesso!");
			}else 
			{
				System.out.println("Sua conta não foi encontrada!");
			}
		}
		
	}

	@Override
	public void sacar(int numero, double valor) 
	{
		var conta = buscarNaCollection(numero);
		
		if (conta != null) 
		{
			if (conta.sacar(valor) == true) 
			{
				System.out.println("\nSaque na conta número: " + numero + " foi efetuado com sucesso!");
				System.out.println("\nO novo saldo é: " + conta.getSaldo());
				
			}
		}else 
		{
			System.out.println("\nA conta número: " + numero + "não foi encontrada!");
		}
	}

	@Override
	public void depositar(int numero, double valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) 
		{
			conta.depositar(valor);
			System.out.println("\nO depósito na conta número " + numero + " foi efetuado com sucesso!");
			System.out.println("\nO saldo atualizado agora é: " + conta.getSaldo());
		}else 
		{
			System.out.println("\nA conta número: " + numero + "não foi encontrada ou"
								+ " a conta destino não é uma conta corrente!");
		}
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, double valor) 
	{
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) 
		{
			if(contaOrigem.sacar(valor) == true)
			{
				contaDestino.depositar(valor);
				System.out.println("\nTransferência efetuada com sucesso!");
			}
		}else 
		{
			System.out.println("\nA conta origem ou a conta destino não foram encontradas!");
		}
		
	}
	
	public int gerarNumero() 
	{
		return ++ numero; 
	}
	
	public Conta buscarNaCollection(int numero) 
	{
		for(var conta : listaContas) 
		{
			if(conta.getNumero() == numero) 
			{
				return conta;
			}
		}
		
		return  null; 
		
	}
	
	public int retornaTipo(int numero) 
	{
		for(var conta: listaContas) 
		{
			if(conta.getNumero() == numero) 
			{
				return conta.getTipo();
			}
		}
		return 0;
	}
	
	
	
}