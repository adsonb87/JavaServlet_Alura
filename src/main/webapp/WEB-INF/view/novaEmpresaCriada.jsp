<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <%
		String nomeEmpresa = (String)request.getAttribute("empresa");
	  %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	
		<c:import url="logout-parcial.jsp"/>
		
		<h1> Empresa ${ empresa } cadastrada com sucesso !!!</h1>
		
		<!-- 
		<h1>Empresa <%= nomeEmpresa %> cadastrada com sucesso !!!</h1>
		-->	
	</body>
</html>