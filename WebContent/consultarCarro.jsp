<%@page import="carro.model.Carro"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Carro</title>
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
   
   /* Estilização para a parte acrescentada */
   .carroDivMother {
       display: flex;
       flex-direction: column;
       margin-top: 20px;
       padding: 10px;
       background: rgba(255, 255, 255, 0.8);
       border-radius: 8px;
       box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
   }
   .carroDivItem {
       display: flex;
       justify-content: space-between;
       align-items: center;
       margin-bottom: 10px;
       padding: 10px;
       background-color: #f1f1f1;
       border-radius: 4px;
   }
   .carroColumn {
       display: flex;
       flex-direction: column;
       margin-right: 10px;
   }
   .carroColumn span {
       font-size: 14px;
       color: #333;
   }
   .carroColumn span:first-child {
       font-weight: bold;
       color: #007BFF;
   }
   #carroItemButton {
       padding: 5px 10px;
       font-size: 14px;
       color: #fff;
       background-color: #007BFF;
       border: none;
       border-radius: 4px;
       cursor: pointer;
       margin-left: 5px;
   }
   #carroItemButton:hover {
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
  
       <form action="buscarCarros" method="post" class="containerform">
           <h1>Buscar Carro</h1>
           <label for="modelo">Modelo:</label>
           <input type="text" id="modelo" name="modelo" required>
           <button type="submit">Buscar</button>
       </form>
       
       <c:if test="${not empty carros}">
           <table>
               <tr>
                   <th>ID</th>
                   <th>Modelo</th>
                   <th>Marca</th>
                   <th>Ano</th>
                   <th>Preço</th>
               </tr>
               <c:forEach var="carro" items="${carros}">
                   <tr>
                       <td>${carro.id}</td>
                       <td>${carro.modelo}</td>
                       <td>${carro.marca}</td>
                       <td>${carro.ano}</td>
                       <td>${carro.preco}</td>
                   </tr>
               </c:forEach>
           </table>
       </c:if>
       
       <c:if test="${empty carros}">
           <!-- Opcional: Mensagem quando não há carros -->
       </c:if>
       
       <!-- Parte acrescentada -->
       <%
       if (request.getAttribute("carros") != null) {
           List<?> carros = (List<?>) request.getAttribute("carros");
           for (int contador = 0; contador <= (carros.size() - 1); contador++) {
               Carro carro = (Carro) carros.get(contador);
       %>
        
       <main>
           <div class="carroDivMother">
               <div class="carroDivItem">
                   <div class="carroColumn">
                       <span>Id</span>
                       <span><% out.print(carro.getId()); %></span>
                       <input type="hidden" name="id" value="<% out.print(carro.getId()); %>">
                   </div>
                   <div class="carroColumn">
                       <span>Modelo</span>
                       <span><% out.print(carro.getModelo()); %></span>
                   </div>
                   <div class="carroColumn">
                       <span>Marca</span>
                       <span><% out.print(carro.getMarca()); %></span>
                   </div>
                   <div class="carroColumn">
                       <span>Ano</span>
                       <span><% out.print(carro.getAno()); %></span>
                   </div>
                   <div class="carroColumn">
                       <span>Preço</span>
                       <span><% out.print(carro.getPreco()); %></span>
                   </div>

                   <!-- Formulário para modificar ou apagar o carro -->
                   <form action="modificarCarro" method="post">
                       <input type="hidden" name="id" value="<% out.print(carro.getId()); %>">
                       <input id="carroItemButton" type="submit" name="alterar" value="Alterar">
                       <input id="carroItemButton" type="submit" name="apagar" value="Apagar">
                   </form>
               </div>
               
               <% } 
           } %>
           </div>
       </main>
       
   </div>
</body>
</html>
