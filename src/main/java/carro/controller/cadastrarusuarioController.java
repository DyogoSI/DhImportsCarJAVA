package carro.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import carro.model.Usuario; // Assuming your Usuario class is in this package

@WebServlet("/cadastrarusuario") // Maps the servlet to the URL /cadastrarUsuario
public class cadastrarusuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarusuarioController() {
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

        // Get form data
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");
        String mensagem;
        
        if (username != null && !username.isEmpty() && 
            senha != null && !senha.isEmpty() && 
            papel != null && !papel.isEmpty()) {
        	
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario.setSenha(senha);
            usuario.setPapel(papel);
            usuario.salvar();

            System.out.println("USUÁRIO CADASTRADO!");
            System.out.println("[USUÁRIO] Nome de Usuário: " + username);
            System.out.println("[USUÁRIO] Senha: " + senha); 
            System.out.println("[USUÁRIO] Papel: " + papel);
         
            mensagem = "Usuário Cadastrado com sucesso!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");
            dispatcher.forward(request, response);

        } else {
            mensagem = "Os campos precisam ser preenchidos!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }
}