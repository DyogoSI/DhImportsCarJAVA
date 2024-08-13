<%@page import="carro.model.Estoque"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar Estoque</title>
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
       max-width: 800px;
       margin: 0 auto;
       padding: 20px;
       background: rgba(0, 0, 0, 0.7);
       border-radius: 8px;
       box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
   }
   form {
       display: flex;
       flex-direction: column;
       margin-bottom: 20px;
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
       border-collapse: collapse;
       margin-top: 20px;
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
   .estoqueDivMother {
       display: flex;
       flex-direction: column;
       margin-top: 20px;
       padding: 10px;
       background: rgba(255, 255, 255, 0.8);
       border-radius: 8px;
       box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
   }
   .estoqueDivItem {
       display: flex;
       justify-content: space-between;
       align-items: center;
       margin-bottom: 10px;
       padding: 10px;
       background-color: #f1f1f1;
       border-radius: 4px;
   }
   .estoqueColumn {
       display: flex;
       flex-direction: column;
       margin-right: 10px;
   }
   .estoqueColumn span {
       font-size: 14px;
       color: #333;
   }
   .estoqueColumn span:first-child {
       font-weight: bold;
       color: #007BFF;
   }
   #estoqueItemButton {
       padding: 5px 10px;
       font-size: 14px;
       color: #fff;
       background-color: #007BFF;
       border: none;
       border-radius: 4px;
       cursor: pointer;
       margin-left: 5px;
   }
   #estoqueItemButton:hover {
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

       <h1>Consultar Estoque</h1>
       <form action="buscarEstoques" method="post">
           <label for="descricao">Descrição:</label>
           <input type="text" id="descricao" name="descricao" required>
           <button type="submit">Buscar</button>
       </form>

       <c:if test="${not empty estoques}">
           <table>
               <tr>
                   <th>ID</th>
                   
                   <th>Quantidade</th>
                   <th>Descrição</th>
               </tr>
               <c:forEach var="estoque" items="${estoques}">
                   <tr>
                       <td>${estoque.id}</td>
                      
                       <td>${estoque.quantidade}</td>
                       <td>${estoque.descricao}</td>
                   </tr>
               </c:forEach>
           </table>
       </c:if>
       <c:if test="${empty estoques}">
           <p>Nenhum estoque encontrado com a descrição fornecida.</p>
       </c:if>

       <!-- Parte acrescentada -->
       <%
       if (request.getAttribute("estoques") != null) {
           List<?> estoques = (List<?>) request.getAttribute("estoques");
           for (int contador = 0; contador < estoques.size(); contador++) {
               Estoque estoque = (Estoque) estoques.get(contador);
       %>
       <div class="estoqueDivMother">
           <div class="estoqueDivItem">
               <div class="estoqueColumn">
                   <span>ID</span>
                   <span><% out.print(estoque.getId()); %></span>
                   <input type="hidden" name="id" value="<% out.print(estoque.getId()); %>">
               </div>
              
               <div class="estoqueColumn">
                   <span>Quantidade</span>
                   <span><% out.print(estoque.getQuantidade()); %></span>
               </div>
               <div class="estoqueColumn">
                   <span>Descrição</span>
                   <span><% out.print(estoque.getDescricao()); %></span>
               </div>
               <div class="estoqueColumn">
                   <span>Ações</span>
                   <form action="modificarEstoque" method="post">
                        <input type="hidden" name="id" value="<% out.print(estoque.getId()); %>">
                       <input id="estoqueItemButton" type="submit" name="alterar" value="Alterar">
                       <input id="estoqueItemButton" type="submit" name="apagar" value="Apagar">
                   </form>
               </div>
           </div>
       </div>
       <%
           }
       }
       %>
   </div>
</body>
</html>
