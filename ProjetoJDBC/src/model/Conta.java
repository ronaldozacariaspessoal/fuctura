package model;

public class Conta {

	private int numero;
	private Double saldo;
	private Double limite;
	
	
	
	public Conta(int numero, Double saldo, Double limite) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	public Conta () {
		
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getLimite() {
		return limite;
	}
	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	
	
	
	
	
	
	
	

}
