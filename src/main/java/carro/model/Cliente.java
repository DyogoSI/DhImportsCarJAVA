package carro.model;

import java.util.ArrayList;

import carro.dao.CarroDao;
import carro.dao.ClienteDao;

public class Cliente {
	    private int id;
	    private String nome;
	    private String email;
	    private String telefone;
   public Cliente() {
   	
   	
   }
	public Cliente(int id, String nome, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
  
	public void salvar() {
		  new ClienteDao().cadastrarCliente(this);
	
	 
	  }
	public void excluir (int id) {
		new ClienteDao().ExcluirCliente(id);
	}
	
	public void alterar() {
		new ClienteDao().AlterarCliente(this);
	}

public Cliente buscarClientePorId(int id) {
	return new ClienteDao().BuscarClientePorId(id);
}

	public ArrayList<Cliente> buscarClientePorNome(String nome){
		  return new ClienteDao().BuscarClientePorNome(nome);
	}
  
}