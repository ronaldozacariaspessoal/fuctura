package model;

public class Endereco {
	private int id_endereco;
	private String rua;
	private int numero;
	private String complemento;
	
	

	
	public Endereco(int id_endereco, String rua, int numero, String complemento) {
		super();
		this.id_endereco = id_endereco;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}


	public Endereco() {
		
	}
	
	
	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	

}
