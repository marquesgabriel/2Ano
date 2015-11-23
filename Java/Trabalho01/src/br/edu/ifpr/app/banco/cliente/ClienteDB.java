package br.edu.ifpr.app.banco.cliente;


public class ClienteDB {

	  private String nome;
	  private String cpf;
	  private String telefone;
	  private String endereco;
	  
	  // métodos get e set para nome, cpf, telefone, endereço
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "ClienteDB [nome=" + nome + ", cpf=" + cpf + ", telefone="
				+ telefone + ", endereco=" + endereco + "]";
	}
}
