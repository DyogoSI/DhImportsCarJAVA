package carro.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import carro.model.Estoque;

/**
 * Servlet implementation class alterarEstoqueController
 */
@WebServlet("/alterarEstoqueController")
public class alterarEstoqueController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarEstoqueController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String descricao = request.getParameter("descricao");
        String id = request.getParameter("id");
        String mensagem;
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEstoque.jsp");

        if (descricao != null && !descricao.isEmpty() &&
            request.getParameter("quantidade") != null && !request.getParameter("quantidade").isEmpty()) {

            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            Estoque estoque = new Estoque(quantidade, descricao);
            estoque.setId(Integer.valueOf(id));
            estoque.alterar(); // Presume-se que o método salvar faz a atualização, pode precisar de ajuste no método

            mensagem = "Estoque alterado com sucesso!";
            request.setAttribute("mensagem", mensagem);
        } else {
            mensagem = "Os campos precisam ser preenchidos!";
            request.setAttribute("mensagem", mensagem);
        }

        dispatcher.forward(request, response);
    }
}
