package model;

public class Pessoa {
	private String cpf;
	private String sexo;
	private int idade;
	private String nome;
	private Conta conta;
	private Endereco endereco;
	
	
	
	public Pessoa(String cpf, String sexo, int idade, String nome, Conta conta, Endereco endereco) {
		super();
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
		this.nome = nome;
		this.conta = conta;
		this.endereco = endereco;
	}
	
	public Pessoa() {
		
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
