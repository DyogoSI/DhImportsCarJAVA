package carro.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import carro.model.Cliente;

/**
 * Servlet implementation class cadastrarclienteController
 */
@WebServlet("/cadastrarcliente")
public class cadastrarclienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarclienteController() {
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
		System.out.println("CLIENTE CADASTRADO!");
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String mensagem;
		
		if (nome != null && !nome.isEmpty() 
		    && email != null && !email.isEmpty() 
		    && telefone != null && !telefone.isEmpty()) {
			 
			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setTelefone(telefone);
			cliente.salvar();
			
			System.out.println("[CLIENTE]:" + nome);
			System.out.println("[CLIENTE]:" + email);
			System.out.println("[CLIENTE]:" + telefone);
			
			mensagem = "Cliente Cadastrado com sucesso!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarCliente.jsp");
			dispatcher.forward(request, response);
			
		} else {
			mensagem = "Os campos precisam ser preenchidos!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarCliente.jsp");
			dispatcher.forward(request, response);
		}
	}
}