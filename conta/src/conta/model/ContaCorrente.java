package conta.model;

public class ContaCorrente extends Conta
{
	private double limite;
	public ContaCorrente(String titular, int numero, int agencia, int tipo, double saldo, double limite) 
	{
		super(titular, numero, agencia, tipo, saldo);
		this.limite = limite;
		
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(double valor) 
	{
		if(this.getSaldo() + this.getLimite() < valor) 
		{
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override
	public void print() 
	{
		super.print();
		System.out.println("Limite de Crédito: " + this.limite);
		System.out.println("Total disponível para saque: " + (this.limite + this.getSaldo()));
		System.out.println("###########################################################\n");
	}
	
}