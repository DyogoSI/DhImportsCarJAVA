package carro.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import carro.model.Estoque;

/**
 * Servlet implementation class CadastrarEstoqueController
 */
@WebServlet("/cadastrarestoque") // Maps the servlet to the URL /cadastrarEstoque
public class cadastrarestoqueController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarestoqueController() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        System.out.println("RECEBI A REQUISIÇÃO GET!");
        this.doPost(request, response);    
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        
        String quantidade = request.getParameter("quantidade");
        String descricao = request.getParameter("descricao"); // Novo parâmetro
        String mensagem;

        if ( 
            quantidade != null && !quantidade.isEmpty() &&
            descricao != null && !descricao.isEmpty()) { // Verificando se descricao não está vazia

            // Get form data
          // Assuming carroId is an integer
            int quantidadeInt = Integer.parseInt(quantidade); // Assuming quantidade is an integer

            Estoque estoque = new Estoque();
            
            estoque.setQuantidade(quantidadeInt);
            estoque.setDescricao(descricao); // Setando o atributo descricao
            estoque.salvar();
        
            System.out.println("ESTOQUE CADASTRADO!");
         
            System.out.println("[ESTOQUE] Quantidade: " + quantidadeInt);
            System.out.println("[ESTOQUE] Descrição: " + descricao); // Adicionando o print da descricao
        
            mensagem = "Estoque Cadastrado com sucesso!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEstoque.jsp");
            dispatcher.forward(request, response);
        } else {
            mensagem = "Os campos precisam ser preenchidos!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEstoque.jsp");
            dispatcher.forward(request, response);
        }
    }
}