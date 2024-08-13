package carro.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import carro.dao.CarroDao;
import carro.model.Carro;

@WebServlet("/cadastrarcarro")
public class cadastrarcarroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cadastrarcarroController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarCarro.jsp");
        dispatcher.forward(request, response);
        System.out.println("RECEBI A REQUISIÇÃO GET!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("CARRO CADASTRADO!");

        String modelo = request.getParameter("modelo");    
        String marca = request.getParameter("marca");
        String mensagem;

        if (modelo != null && !modelo.isEmpty() &&
            marca != null && !marca.isEmpty() &&
            request.getParameter("ano") != null && !request.getParameter("ano").isEmpty() &&
            request.getParameter("preco") != null && !request.getParameter("preco").isEmpty()) {
            
            int ano = Integer.parseInt(request.getParameter("ano"));
            double preco = Double.parseDouble(request.getParameter("preco"));

            Carro carro = new Carro();
            carro.setModelo(modelo);
            carro.setMarca(marca);
            carro.setAno(ano);
            carro.setPreco(preco);

            CarroDao carroDao = new CarroDao();
            carroDao.cadastrarCarro(carro);

            System.out.println("[CARRO]:" + modelo);
            System.out.println("[CARRO]:" + marca);
            System.out.println("[CARRO]:" + ano);
            System.out.println("[CARRO]:" + preco);

            mensagem = "Carro cadastrado com sucesso!";
            request.setAttribute("mensagem", mensagem);
        } else {
            mensagem = "Os campos precisam ser preenchidos!";
            request.setAttribute("mensagem", mensagem);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarCarro.jsp");
        dispatcher.forward(request, response);
    }
}