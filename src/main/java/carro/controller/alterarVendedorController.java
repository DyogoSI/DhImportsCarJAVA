package carro.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import carro.model.Vendedor;

/**
 * Servlet implementation class alterarVendedorController
 */
@WebServlet("/alterarVendedorController")
public class alterarVendedorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarVendedorController() {
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

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String id = request.getParameter("id");
        String mensagem;
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarVendedor.jsp");

        if (nome != null && !nome.isEmpty() &&
            email != null && !email.isEmpty() &&
            telefone != null && !telefone.isEmpty()) {

            Vendedor vendedor = new Vendedor(nome, email, telefone);
            vendedor.setId(Integer.valueOf(id));
            vendedor.alterar(); // Método para atualizar o vendedor no banco de dados

            mensagem = "Vendedor alterado com sucesso!";
            request.setAttribute("mensagem", mensagem);
        } else {
            mensagem = "Os campos precisam ser preenchidos!";
            request.setAttribute("mensagem", mensagem);
        }

        dispatcher.forward(request, response);
    }
}
