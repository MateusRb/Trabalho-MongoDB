package br.edu.unoesc.model;

public class Cliente {

	private String nome;
	private String cpf;
	private Double renda;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String cpf, Double renda) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.renda = renda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

}
