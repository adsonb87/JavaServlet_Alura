<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=AlteraEmpresa" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${linkEntradaServlet}" method="post">
		ID: <input type="hidden" name="id" value="${empresa.id}"  readonly="readonly"/>
		Nome: <input type="text" name="nome" value="${empresa.nome}"/>
		Data: <input type="text" name="data" 
				value= "<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> "/>
		
		<input type="submit"/>
	</form>
	</br></br>
	<a href="/JavaServlet_Alura/bem-vindo.html">Home</a></br></br>
	<a href="/JavaServlet_Alura/listaEmpresas">Lista de empresas</a></br></br>
	<a href="/JavaServlet_Alura/entrada?acao=ListaEmpresas">Novo link Lista de empresas</a>
	
</body>
</html>