package carro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carro.model.Cliente;
import carro.model.Estoque;

/**
 * Servlet implementation class modificarCarroController
 */
@WebServlet("/modificarEstoqueController")
public class modificarEstoqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarEstoqueController() {
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
        
        String apagar = request.getParameter("apagar");
        String alterar = request.getParameter("alterar");
        String id = request.getParameter("id");
        
        if(apagar!=null && id!=null) {
        	new Estoque().excluir(Integer.valueOf(id));
        	RequestDispatcher dispatcher = request.getRequestDispatcher("consultarEstoque.jsp");
        	request.setAttribute("mensagem","Estoque apagado com sucesso!");
        	dispatcher.forward(request, response); 
        }else if (alterar != null && id !=null) {
        	Estoque estoque = new Estoque().buscarEstoquePorId(Integer.valueOf(id));
        	RequestDispatcher dispatcher = request.getRequestDispatcher("alterarEstoque.jsp");
        	request.setAttribute("estoque", estoque);
        	dispatcher.forward(request, response);
		
	}

}
}
