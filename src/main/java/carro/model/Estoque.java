package carro.model;

import java.util.ArrayList;

import carro.dao.CarroDao;
import carro.dao.ClienteDao;
import carro.dao.EstoqueDao;

public class Estoque {

    private int id;
    private int carroId;
    private int quantidade;
    private String descricao; // Novo atributo adicionado

    public Estoque() {
    }

    public Estoque(int id,  int quantidade, String descricao) {
        this.id = id;
        
        this.quantidade = quantidade;
        this.descricao = descricao; // Novo atributo no construtor
    }

    public Estoque( int quantidade, String descricao) {
       
        this.quantidade = quantidade;
        this.descricao = descricao; // Novo atributo no construtor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void salvar() {
        new EstoqueDao().cadastrarEstoque(this);
    }
    public void excluir (int id) {
    	new EstoqueDao().ExcluirEstoque(id);
    }
    public void alterar() {
		new EstoqueDao().AlterarEstoque(this);
	}
    
    public Estoque buscarEstoquePorId(int id) {
    	return new EstoqueDao().BuscarEstoquePorId(id);
    }
    
    public ArrayList<Estoque> buscarEstoquePorDescricao(String descricao){
  	  return new EstoqueDao().BuscarEstoquePorDescricao(descricao);
    }
}