<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuario</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('${pageContext.request.contextPath}/css/jsp imageee.png') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            color: #fff;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7);
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }

        h1 {
            text-align: center;
            color: #00aaff;
            text-shadow: 2px 2px 4px #000;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #fff;
        }

        input[type="text"],
        input[type="password"] {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: calc(100% - 22px); /* Ajustar a largura para caber o padding e a borda */
        }

        input[type="submit"] {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .message {
            color: red;
            font-weight: bold;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Cadastro de Usuario</h1>
        <form action="cadastrarusuarioController" method="post">
            <label for="username">Nome de usu�rio:</label>
            <input type="text" id="username" name="username" required>
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required>
            <label for="papel">Papel:</label>
            <input type="text" id="papel" name="papel" required>
            <input type="submit" value="Cadastrar">
        </form>
    </div>
    
    <div class="message">
        <%
        String mensagem = (String) request.getAttribute("mensagem");
        if (mensagem != null) {
            out.print(mensagem);
        }
        %>
    </div>
</body>
</html>