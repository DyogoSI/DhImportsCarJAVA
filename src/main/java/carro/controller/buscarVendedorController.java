package carro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carro.model.Cliente;
import carro.model.Vendedor;



/**
 * Servlet implementation class buscarCarroController
 */
@WebServlet("/buscarVendedorController")
public class buscarVendedorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarVendedorController() {
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
		String telefone =request.getParameter("telefone");
		ArrayList<Vendedor> vendedores = new Vendedor().buscarVendedorPorTelefone(telefone);
		
		 request.setAttribute("vendedores", vendedores);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("consultarVendedor.jsp");
	        dispatcher.forward(request, response);
	}

}