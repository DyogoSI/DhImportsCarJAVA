package carro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carro.model.Carro;

/**
 * Servlet implementation class modificarCarroController
 */
@WebServlet("/modificarCarroController")
public class modificarCarroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarCarroController() {
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
        	new Carro().excluir(Integer.valueOf(id));
        	RequestDispatcher dispatcher = request.getRequestDispatcher("consultarCarro.jsp");
        	request.setAttribute("mensagem","Carro apagado com sucesso!");
        	dispatcher.forward(request, response); 
        }else if (alterar != null && id !=null) {
        	Carro carro = new Carro().buscarCarroPorId(Integer.valueOf(id));
        	RequestDispatcher dispatcher = request.getRequestDispatcher("alterarCarro.jsp");
        	request.setAttribute("carro", carro);
        	dispatcher.forward(request, response);
        }
		
	}

}
