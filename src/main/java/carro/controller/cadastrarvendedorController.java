package carro.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import carro.dao.VendedorDao;
import carro.model.Vendedor;

@WebServlet("/cadastrarvendedor")
public class cadastrarvendedorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cadastrarvendedorController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarVendedor.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String mensagem;

        if (nome != null && !nome.isEmpty() &&
            email != null && !email.isEmpty() &&
            telefone != null && !telefone.isEmpty()) {

            Vendedor vendedor = new Vendedor(nome, email, telefone);
            VendedorDao vendedorDao = new VendedorDao();
            vendedorDao.cadastrarVendedor(vendedor);

            mensagem = "Vendedor cadastrado com sucesso!";
        } else {
            mensagem = "Todos os campos devem ser preenchidos!";
        }

        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarVendedor.jsp");
        dispatcher.forward(request, response);
    }
}