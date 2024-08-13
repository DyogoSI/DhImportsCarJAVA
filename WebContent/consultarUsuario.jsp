<%@page import="carro.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Usuário por Senha</title>
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
      color: #fff;
  }
  input[type="text"] {
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
  table {
      width: 100%;
      margin-top: 20px;
      border-collapse: collapse;
      background-color: #fff;
      color: #000;
  }
  table, th, td {
      border: 1px solid #ddd;
  }
  th, td {
      padding: 10px;
      text-align: left;
  }
  th {
      background-color: #007BFF;
      color: #fff;
  }
  main {
      padding: 20px;
      background: rgba(0, 0, 0, 0.7);
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
      margin-top: 20px;
  }
  .carroDivMother {
      display: flex;
      flex-direction: column;
  }
  .carroDivItem {
      display: flex;
      justify-content: space-between;
      padding: 10px;
      border-bottom: 1px solid #ddd;
  }
  .carroColumn {
      flex: 1;
      margin: 0 10px;
  }
  .carroColumn span {
      display: block;
  }
  #carroItemButton {
      padding: 5px 10px;
      font-size: 14px;
      color: #fff;
      background-color: #007BFF;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      margin: 0 5px;
  }
  #carroItemButton:hover {
      background-color: #0056b3;
  }
</style>
</head>
<body>
  <div class="container">
      <form action="buscarUsuarios" method="post" class="containerform">
          <h1>Buscar Usuário por Senha</h1>
          <label for="senha">Senha:</label>
          <input type="text" id="senha" name="senha" required>
          <button type="submit">Buscar</button>
      </form>
      
      <% 
      String mensagem = (String) request.getAttribute("mensagem");
      if (mensagem != null) {
          out.print("<p style='color: #ff0000; text-align: center;'>" + mensagem + "</p>");
      }
      %>
      
      <c:if test="${not empty usuarios}">
          <table>
              <tr>
                  <th>ID</th>
                  <th>Nome de Usuário</th>
                  <th>Senha</th>
                  <th>Papel</th>
              </tr>
              <c:forEach var="usuario" items="${usuarios}">
                  <tr>
                      <td>${usuario.id}</td>
                      <td>${usuario.username}</td>
                      <td>${usuario.senha}</td>
                      <td>${usuario.papel}</td>
                  </tr>
              </c:forEach>
          </table>
      </c:if>
      <c:if test="${empty usuarios}">
          <p>Nenhum usuário encontrado com a senha fornecida.</p>
      </c:if>
  </div>
  
  <% if(request.getAttribute("usuarios") != null) { %>
  <main>
      <div class="carroDivMother">
          <%
          List<?> usuarios = (List<?>) request.getAttribute("usuarios");
          for(int contador = 0; contador < usuarios.size(); contador++) {
              Usuario usuario = (Usuario) usuarios.get(contador);
          %>
          <div class="carroDivItem">
              <div class="carroColumn">
                  <span style="font-weight: bold">Id</span>
                  <span><%= usuario.getId() %></span>
                  <input type="hidden" name="id" value="<% out.print(usuario.getId()); %>">
              </div>
              <div class="carroColumn">
                  <span style="font-weight: bold">Username</span>
                  <span><%= usuario.getUsername() %></span>
              </div>
              <div class="carroColumn">
                  <span style="font-weight: bold">Senha</span>
                  <span><%= usuario.getSenha() %></span>
              </div>
              <div class="carroColumn">
                  <span style="font-weight: bold">Papel</span>
                  <span><%= usuario.getPapel() %></span>
              </div>
              <div class="carroColumn">
                  <form action="modificarUsuario" method="post">
                       <input type="hidden" name="id" value="<% out.print(usuario.getId()); %>">
                      <input id="carroItemButton" type="submit" name="alterar" value="Alterar">
                      <input id="carroItemButton" type="submit" name="apagar" value="Apagar">
                  </form>
              </div>
          </div>
          <% } %>
      </div>
  </main>
  <% } %>
</body>
</html>
