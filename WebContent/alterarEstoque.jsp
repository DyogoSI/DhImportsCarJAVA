<%@ page import="carro.model.Estoque" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ALTERAR ESTOQUE</title>
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
        <h1>DHIMPORTSCAR</h1>
        <form action="${pageContext.request.contextPath}/alterarEstoques" method="post">
            <c:choose>
                <c:when test="${not empty estoque}">
                    <input type="hidden" name="id" value="${estoque.id}">
                    
                    <label for="descricao">Descrição:</label>
                    <input type="text" id="descricao" name="descricao" value="${estoque.descricao}">
                    
                    <label for="quantidade">Quantidade:</label>
                    <input type="number" id="quantidade" name="quantidade" value="${estoque.quantidade}">
                    
                    <button type="submit">Alterar Estoque</button>
                </c:when>
                <c:otherwise>
                    <div class='error'>Estoque não encontrado.</div>
                </c:otherwise>
            </c:choose>
            
            <c:if test="${not empty mensagem}">
                <div class='error'>${mensagem}</div>
            </c:if>
        </form>
    </div>
</body>
</html>
