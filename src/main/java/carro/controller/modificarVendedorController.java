package carro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carro.model.Usuario;
import carro.model.Vendedor;

/**
 * Servlet implementation class modificarCarroController
 */
@WebServlet("/modificarVendedorController")
public class modificarVendedorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarVendedorController() {
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
        	new Vendedor().excluir(Integer.valueOf(id));
        	RequestDispatcher dispatcher = request.getRequestDispatcher("consultarVendedor.jsp");
        	request.setAttribute("mensagem","Vendedor apagado com sucesso!");
        	dispatcher.forward(request, response); 
        }else if (alterar != null && id != null) {
            Vendedor vendedor = new Vendedor().buscarVendedorPorId(Integer.valueOf(id));
            RequestDispatcher dispatcher = request.getRequestDispatcher("alterarVendedor.jsp");
            request.setAttribute("vendedor", vendedor);
            dispatcher.forward(request, response);
		
	}

}
}
