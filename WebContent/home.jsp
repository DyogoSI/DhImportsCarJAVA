<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ImportAuto - Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('${pageContext.request.contextPath}/css/jsp imageee.png') no-repeat center center fixed;
            background-size: cover;
            color: #fff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background: rgba(0, 0, 0, 0.7);
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }
        h1 {
            color: #00aaff;
            margin-bottom: 30px;
            text-shadow: 2px 2px 4px #000;
        }
        .button-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .button-container a {
            margin: 10px;
            padding: 15px 25px;
            font-size: 16px;
            color: #fff;
            background-color: #007BFF;
            text-decoration: none;
            border-radius: 4px;
            display: inline-block;
            transition: background-color 0.3s ease;
        }
        .button-container a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bem-vindo ao ImportAuto</h1>
        <div class="button-container">
            <!-- Cadastros -->
            <a href="${pageContext.request.contextPath}/cadastrarCarro.jsp">Cadastrar Carro</a>
            <a href="${pageContext.request.contextPath}/cadastrarCliente.jsp">Cadastrar Cliente</a>
            <a href="${pageContext.request.contextPath}/cadastrarEstoque.jsp">Cadastrar Estoque</a>
            <a href="${pageContext.request.contextPath}/cadastrarUsuario.jsp">Cadastrar Usuário</a>
            <a href="${pageContext.request.contextPath}/cadastrarVendedor.jsp">Cadastrar Vendedor</a>

            <!-- Consultas -->
            <a href="${pageContext.request.contextPath}/consultarCarro.jsp">Consultar Carro</a>
            <a href="${pageContext.request.contextPath}/consultarCliente.jsp">Consultar Cliente</a>
            <a href="${pageContext.request.contextPath}/consultarEstoque.jsp">Consultar Estoque</a>
            <a href="${pageContext.request.contextPath}/consultarUsuario.jsp">Consultar Usuário</a>
            <a href="${pageContext.request.contextPath}/consultarVendedor.jsp">Consultar Vendedor</a>

            <!-- Alterações -->
            <a href="${pageContext.request.contextPath}/alterarCarro.jsp">Alterar Carro</a>
            <a href="${pageContext.request.contextPath}/alterarCliente.jsp">Alterar Cliente</a>
            <a href="${pageContext.request.contextPath}/alterarEstoque.jsp">Alterar Estoque</a>
            <a href="${pageContext.request.contextPath}/alterarUsuario.jsp">Alterar Usuário</a>
            <a href="${pageContext.request.contextPath}/alterarVendedor.jsp">Alterar Vendedor</a>
        </div>
    </div>
</body>
</html>
