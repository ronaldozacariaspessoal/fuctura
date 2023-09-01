package conta.model;

public abstract class Conta {
	private String titular;
	private int numero = 0, agencia, tipo;
	private double saldo;

	public Conta(String titular, int numero, int agencia, int tipo, double saldo) {
		this.titular = titular;
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(double valor) {

		if (this.getSaldo() < valor) {
			System.out.println("\n saldo Insuficiente!");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	public void depositar(double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	public void print() {

		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}

		System.out.println("\n###########################################################");
		System.out.println("                BANCO ZACARIAS");
		System.out.println("               --- Extrato --- ");
		System.out.println("###########################################################");
		System.out.println("# Numero Conta: " + this.numero + " Agência: " + this.agencia );
		System.out.println("###########################################################");
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: " + this.saldo + "\n");
		System.out.println("___________________________________________________________");
	}

}