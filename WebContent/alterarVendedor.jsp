<%@ page import="carro.model.Vendedor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Vendedor</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('${pageContext.request.contextPath}/css/jsp imageee.png') no-repeat center center fixed;
            background-size: cover;
            color: #fff;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #00aaff;
            margin-top: 30px;
            text-shadow: 2px 2px 4px #000;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background: rgba(0, 0, 0, 0.7);
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin: 10px 0 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="tel"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 15px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .error {
            color: blue;
            font-size: 14px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Alterar Vendedor</h1>
        <form action="${pageContext.request.contextPath}/alterarVendedorController" method="post">
            <%-- Recupera o vendedor da requisição --%>
            <%
            Vendedor vendedor = (Vendedor) request.getAttribute("vendedor");
            if (vendedor == null) {
                out.print("<div class='error'>Vendedor não encontrado.</div>");
                return;
            }
            %>
            
            <input type="hidden" name="id" value="<%= vendedor.getId() %>">
            
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= vendedor.getNome() %>" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= vendedor.getEmail() %>" required>
            
            <label for="telefone">Telefone:</label>
            <input type="tel" id="telefone" name="telefone" value="<%= vendedor.getTelefone() %>" required>
            
            <button type="submit">Alterar Vendedor</button>
            
            <%-- Mensagem de erro ou sucesso --%>
            <div class="error">
                <% 
                String mensagem = (String) request.getAttribute("mensagem");
                if (mensagem != null) {
                    out.print(mensagem);
                }
                %>
            </div>
        </form>
    </div>
</body>
</html>
