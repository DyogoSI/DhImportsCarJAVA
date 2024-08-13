<%@page import="carro.model.Cliente"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar Cliente</title>
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
   
   .clienteDivMother {
       display: flex;
       flex-direction: column;
       margin-top: 20px;
       padding: 10px;
       background: rgba(255, 255, 255, 0.8);
       border-radius: 8px;
       box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
   }
   .clienteDivItem {
       display: flex;
       justify-content: space-between;
       align-items: center;
       margin-bottom: 10px;
       padding: 10px;
       background-color: #f1f1f1;
       border-radius: 4px;
   }
   .clienteColumn {
       display: flex;
       flex-direction: column;
       margin-right: 10px;
   }
   .clienteColumn span {
       font-size: 14px;
       color: #333;
   }
   .clienteColumn span:first-child {
       font-weight: bold;
       color: #007BFF;
   }
   #clienteItemButton {
       padding: 5px 10px;
       font-size: 14px;
       color: #fff;
       background-color: #007BFF;
       border: none;
       border-radius: 4px;
       cursor: pointer;
       margin-left: 5px;
   }
   #clienteItemButton:hover {
       background-color: #0056b3;
   }
</style>
</head>
<body>
   <div class="container">
       <% String mensagem = (String) request.getAttribute("mensagem"); 
          if (mensagem != null) { %>
              <div style="color: #ff0000; text-align: center; margin-bottom: 20px;">
                  <%= mensagem %>
              </div>
       <% } %>

       <h1>Consultar Cliente</h1>
       <form action="buscarClientes" method="post" class="clienteform">
           <label for="nome">Nome:</label>
           <input type="text" id="nome" name="nome" required>
           <button type="submit">Buscar</button>
       </form>

       <c:if test="${not empty clientes}">
           <table>
               <tr>
                   <th>ID</th>
                   <th>Nome</th>
                   <th>Email</th>
                   <th>Telefone</th>
               </tr>
               <c:forEach var="cliente" items="${clientes}">
                   <tr>
                       <td>${cliente.id}</td>
                       <td>${cliente.nome}</td>
                       <td>${cliente.email}</td>
                       <td>${cliente.telefone}</td>
                   </tr>
               </c:forEach>
           </table>
       </c:if>
       <c:if test="${empty clientes}">
           <p>Nenhum cliente encontrado.</p>
       </c:if>

       <!-- Parte acrescentada -->
       <%
       if (request.getAttribute("clientes") != null) {
           List<?> clientes = (List<?>) request.getAttribute("clientes");
           for (int contador = 0; contador <= (clientes.size() - 1); contador++) {
               Cliente cliente = (Cliente) clientes.get(contador);
       %>
       <main>
           <div class="clienteDivMother">
               <div class="clienteDivItem">
                   <div class="clienteColumn">
                       <span>Id</span>
                       <span><% out.print(cliente.getId()); %></span>
                       <input type="hidden" name="id" value="<% out.print(cliente.getId()); %>">
                   </div>
                   <div class="clienteColumn">
                       <span>Nome</span>
                       <span><% out.print(cliente.getNome()); %></span>
                   </div>
                   <div class="clienteColumn">
                       <span>Email</span>
                       <span><% out.print(cliente.getEmail()); %></span>
                   </div>
                   <div class="clienteColumn">
                       <span>Telefone</span>
                       <span><% out.print(cliente.getTelefone()); %></span>
                   </div>
                   <div class="clienteColumn">
                       <span>Ações</span>
                       <form action="modificarCliente" method="post">
                           <input type="hidden" name="id" value="<% out.print(cliente.getId()); %>">
                           <input id="clienteItemButton" type="submit" name="alterar" value="Alterar">
                           <input id="clienteItemButton" type="submit" name="apagar" value="Apagar">
                       </form>
                   </div>
               </div>
           </div>
       </main>
       <%
           }
       }
       %>
   </div>
</body>
</html>
