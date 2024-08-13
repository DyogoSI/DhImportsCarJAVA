<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ALTERAR CARRO</title>
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
        input[type="number"] {
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
        <h1>ALTERAR CARRO</h1>
        <form action="${pageContext.request.contextPath}/alterarCarroController" method="post">
            <input type="hidden" name="id" value="${carro.id}">
            
            <label for="modelo">Modelo:</label>
            <input type="text" id="modelo" name="modelo" value="${carro.modelo}" required>
            
            <label for="marca">Marca:</label>
            <input type="text" id="marca" name="marca" value="${carro.marca}" required>
            
            <label for="ano">Ano:</label>
            <input type="number" id="ano" name="ano" value="${carro.ano}" required>
            
            <label for="preco">Preço:</label>
            <input type="text" id="preco" name="preco" value="${carro.preco}" required>
            
            <button type="submit">Alterar Carro</button>
            
            <% String mensagem = (String) request.getAttribute("mensagem"); 
            if (mensagem != null) {
                out.print("<div class='error'>" + mensagem + "</div>");
            }
            %>
            
        </form>
       
    </div>
</body>
</html>
