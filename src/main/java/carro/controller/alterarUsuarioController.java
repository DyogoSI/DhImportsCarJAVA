package carro.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import carro.model.Usuario;

/**
 * Servlet implementation class alterarUsuarioController
 */
@WebServlet("/alterarUsuarioController")
public class alterarUsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarUsuarioController() {
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

        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");
        String id = request.getParameter("id");
        String mensagem;
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");

        if (username != null && !username.isEmpty() &&
            senha != null && !senha.isEmpty() &&
            papel != null && !papel.isEmpty()) {

            Usuario usuario = new Usuario(username, senha, papel);
            usuario.setId(Integer.valueOf(id));
            usuario.alterar(); // Presume-se que o método salvar faz a atualização, pode precisar de ajuste no método

            mensagem = "Usuário alterado com sucesso!";
            request.setAttribute("mensagem", mensagem);
        } else {
            mensagem = "Os campos precisam ser preenchidos!";
            request.setAttribute("mensagem", mensagem);
        }

        dispatcher.forward(request, response);
    }
}
