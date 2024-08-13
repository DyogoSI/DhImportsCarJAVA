<%@page import="carro.model.Vendedor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Vendedor</title>
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
       margin: 20px 0;
   }
   .carroDivItem {
       display: flex;
       justify-content: space-between;
       padding: 10px;
       border-bottom: 1px solid #ddd;
       background-color: rgba(0, 0, 0, 0.5);
       border-radius: 4px;
       margin-bottom: 10px;
   }
   .carroColumn {
       flex: 1;
       margin: 0 10px;
       padding: 5px;
       background-color: #333;
       color: #fff;
       border-radius: 4px;
       display: flex;
       flex-direction: column;
   }
   .carroColumn span {
       display: block;
   }
   .carroColumn span:first-child {
       font-weight: bold;
       margin-bottom: 5px;
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
       <form action="buscarVendedores" method="post" class="containerform">
           <h1>Buscar Vendedor</h1>
           <label for="telefone">Telefone:</label>
           <input type="text" id="telefone" name="telefone" required>
           <button type="submit">Buscar</button>
       </form>

       <% 
       String mensagem = (String) request.getAttribute("mensagem");
       if (mensagem != null) {
           out.print("<p style='color: #ff0000; text-align: center;'>" + mensagem + "</p>");
       }
       %>

       <c:if test="${not empty vendedores}">
           <table>
               <tr>
                   <th>ID</th>
                   <th>Nome</th>
                   <th>Email</th>
                   <th>Telefone</th>
               </tr>
               <c:forEach var="vendedor" items="${vendedores}">
                   <tr>
                       <td>${vendedor.id}</td>
                       <td>${vendedor.nome}</td>
                       <td>${vendedor.email}</td>
                       <td>${vendedor.telefone}</td>
                   </tr>
               </c:forEach>
           </table>
       </c:if>
       <c:if test="${empty vendedores}">
           <p>Nenhum vendedor encontrado com o telefone informado.</p>
       </c:if>
   </div>

   <% if(request.getAttribute("vendedores") != null) { %>
   <main>
       <div class="carroDivMother">
           <%
           List<?> vendedores = (List<?>) request.getAttribute("vendedores");
           for(int contador = 0; contador < vendedores.size(); contador++) {
               Vendedor vendedor = (Vendedor) vendedores.get(contador);
           %>
           <div class="carroDivItem">
               <div class="carroColumn">
                   <span>Id</span>
                   <span><%= vendedor.getId() %></span>
                   <input type="hidden" name="id" value="<% out.print(vendedor.getId()); %>">
               </div>
               <div class="carroColumn">
                   <span>Nome</span>
                   <span><%= vendedor.getNome() %></span>
               </div>
               <div class="carroColumn">
                   <span>Email</span>
                   <span><%= vendedor.getEmail() %></span>
               </div>
               <div class="carroColumn">
                   <span>Telefone</span>
                   <span><%= vendedor.getTelefone() %></span>
               </div>
               <form action="modificarVendedor" method="post" style="display: flex; gap: 5px;">
                    <input type="hidden" name="id" value="<% out.print(vendedor.getId()); %>">
                   <input id="carroItemButton" type="submit" name="alterar" value="Alterar">
                   <input id="carroItemButton" type="submit" name="apagar" value="Apagar">
               </form>
           </div>
           <% } %>
       </div>
   </main>
   <% } %>
</body>
</html>
