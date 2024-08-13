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

/**
 * Servlet implementation class buscarCarroController
 */
@WebServlet("/buscarCarroController")
public class buscarCarroController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public buscarCarroController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Método doGet deixado em branco
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String modelo = request.getParameter("modelo");
        ArrayList<Carro> carros = new Carro().buscarCarroPorModelo(modelo);
        
        // Corrigido para definir o atributo "carros"
        request.setAttribute("carros", carros);

        RequestDispatcher dispatcher = request.getRequestDispatcher("consultarCarro.jsp");
        dispatcher.forward(request, response);
    }
}
