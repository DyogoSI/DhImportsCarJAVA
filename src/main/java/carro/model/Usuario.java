package carro.model;

import java.util.ArrayList;

import carro.dao.CarroDao;
import carro.dao.EstoqueDao;
import carro.dao.UsuarioDao;

public class Usuario {
  
   private int id;
   private String username;
   private String senha;
   private String papel;
	
	
   public Usuario() {
   	
   	
   }
	public Usuario(int id, String username, String senha, String papel) {
		this.id = id;
		this.username = username;
		this.senha = senha;
		this.papel = papel;
	}
	public Usuario(String username, String senha, String papel) {
		this.username = username;
		this.senha = senha;
		this.papel = papel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	public void salvar() {
		  new UsuarioDao().cadastrarUsuario(this);
	       
	  }
	public void excluir (int id) {
		new UsuarioDao().ExcluirUsuario(id);
	}
	 public void alterar() {
			new UsuarioDao().AlterarUsuario(this);
		}
	  public Usuario buscarUsuarioPorId(int id) {
	    	return new UsuarioDao().BuscarUsuarioPorId(id);
	    }
	public ArrayList<Usuario> buscarUsuarioPorSenha(String senha){
		  return new UsuarioDao().BuscarUsuarioPorSenha(senha);
		  
	  }
}