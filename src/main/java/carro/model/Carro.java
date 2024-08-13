package carro.model;

import java.util.ArrayList;

import carro.dao.CarroDao;

public class Carro {
	private int id;
   private String modelo;
   private String marca;
   private String descricao;
   private int ano;
   private double preco;
   public Carro() {
   	
   	
   }
  
  
  
   public Carro(String modelo, String marca, int ano, double preco) {
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.preco = preco;
	}
	public Carro(int id,String modelo,String marca,int ano, double preco) {
   	this.id =  id;
   	
   	this.modelo = modelo;
   	this.marca = marca;
   	this.ano = ano;
   	this.preco = preco;
   	
   	
   }
	public int getid() {
		return this.id;
	}
   public void setid(int id) {
   	this.id = id;
   }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() { 
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
  

public void salvar() {
	  new CarroDao().cadastrarCarro(this);
	  
  }

public void excluir (int id) {
	new CarroDao().ExcluirCarro(id);
}

public void alterar() {
	new CarroDao().AlterarCarro(this);
}


public Carro buscarCarroPorId(int id) {
	return new CarroDao().BuscarCarroPorId(id);
}

  public ArrayList<Carro> buscarCarroPorModelo(String modelo){
	  return new CarroDao().BuscarCarroPorModelo(modelo);
	  
  }
}