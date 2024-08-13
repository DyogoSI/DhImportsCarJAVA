package carro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carro.model.Carro;
import carro.model.Estoque;

/**
 * Servlet implementation class buscarCarroController
 */
@WebServlet("/buscarEstoqueController")
public class buscarEstoqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarEstoqueController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String descricao =request.getParameter("descricao");
		ArrayList<Estoque> estoques = new Estoque().buscarEstoquePorDescricao(descricao);
		
		 request.setAttribute("estoques", estoques);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("consultarEstoque.jsp");
	        dispatcher.forward(request, response);
	}

}