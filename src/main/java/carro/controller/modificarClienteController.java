package carro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carro.model.Carro;
import carro.model.Cliente;

/**
 * Servlet implementation class modificarCarroController
 */
@WebServlet("/modificarClienteController")
public class modificarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarClienteController() {
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
        	new Cliente().excluir(Integer.valueOf(id));
        	RequestDispatcher dispatcher = request.getRequestDispatcher("consultarCliente.jsp");
        	request.setAttribute("mensagem","Cliente apagado com sucesso!");
        	dispatcher.forward(request, response); 
        	
        } else if (alterar != null && id !=null) {
        	Cliente cliente = new Cliente().buscarClientePorId(Integer.valueOf(id));
        	RequestDispatcher dispatcher = request.getRequestDispatcher("alterarCliente.jsp");
        	request.setAttribute("cliente", cliente);
        	dispatcher.forward(request, response);
		
	}

}
}
