package model;

public abstract class Pessoa {
	String nome;
	String email;
	String sexo;
	int idade;
	String cpf;
	
	
	
	
	
	public Pessoa(String nome, String email, String sexo, int idade, String cpf) {
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.idade = idade;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
