package br.edu.ifpr.app.banco.venda;

import br.edu.ifpr.app.banco.cliente.ClienteDB;
import br.edu.ifpr.app.banco.produto.ProdutoDB;
import br.edu.ifpr.app.banco.vendedor.VendedorDB;

public class VendaDB {
	private int id;
	private ProdutoDB produto;
	private ClienteDB cliente;
	private VendedorDB vendedor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProdutoDB getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDB produto) {
		this.produto = produto;
	}
	public ClienteDB getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDB cliente) {
		this.cliente = cliente;
	}
	public VendedorDB getVendedor() {
		return vendedor;
	}
	public void setVendedor(VendedorDB vendedor) {
		this.vendedor = vendedor;
	}
	
	@Override
	public String toString() {
		return "VendaDB [id=" + id + ", produto=" + produto + ", cliente="
				+ cliente + ", vendedor=" + vendedor + "]";
	}	
}
