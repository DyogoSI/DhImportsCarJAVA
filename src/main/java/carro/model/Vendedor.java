package carro.model;

import java.util.ArrayList;

import carro.dao.CarroDao;
import carro.dao.ClienteDao;
import carro.dao.UsuarioDao;
import carro.dao.VendedorDao;

public class Vendedor {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    // Construtor
    public Vendedor() {}

    public Vendedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters
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
  	  new VendedorDao().cadastrarVendedor(this);
  	  
    }
    public void excluir (int id) {
    	new VendedorDao().ExcluirVendedor(id);
    }
    
    public void alterar() {
		new VendedorDao().AlterarVendedor(this);
	}
    public Vendedor buscarVendedorPorId(int id) {
    	return new VendedorDao().BuscarVendedorPorId(id);
    }
    public ArrayList<Vendedor> buscarVendedorPorTelefone(String telefone){
		  return new VendedorDao().BuscarVendedorPorTelefone(telefone);
	}

}