package carro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carro.dao.CarroDao;
import carro.model.Carro;

/**
 * Servlet implementation class alterarCarroController
 */
@WebServlet("/alterarCarroController")
public class alterarCarroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarCarroController() {
        super();
        // TODO Auto-generated constructor stub
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
	  

	        String modelo = request.getParameter("modelo");    
	        String marca = request.getParameter("marca");
	        String id = request.getParameter("id");
	        String mensagem;
	        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarCarro.jsp");
	        if (modelo != null && !modelo.isEmpty() &&
	            marca != null && !marca.isEmpty() &&
	            request.getParameter("ano") != null && !request.getParameter("ano").isEmpty() &&
	            request.getParameter("preco") != null && !request.getParameter("preco").isEmpty()) {
	            
	            int ano = Integer.parseInt(request.getParameter("ano"));
	            double preco = Double.parseDouble(request.getParameter("preco"));

	            Carro carro = new Carro(modelo,marca,ano,preco);
	            carro.setId(Integer.valueOf(id));
	            carro.alterar();
	            mensagem = "Carro alterado com sucesso!";
	            request.setAttribute("mensagem", mensagem);
	        } else {
	            mensagem = "Os campos precisam ser preenchidos!";
	            request.setAttribute("mensagem", mensagem);
	        }

	        dispatcher.forward(request, response);
	}

}
