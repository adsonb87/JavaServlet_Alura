<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovaEmpresa" var="linkServeletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${linkServeletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome"/>
		Data: <input type="text" name="data"/>
		<input type="submit"/>
	</form>
	</br></br>
	<a href="/JavaServlet_Alura/bem-vindo.html">Home</a></br></br>
	<a href="/JavaServlet_Alura/listaEmpresas">Lista de empresas</></br></br>
	<a href="/JavaServlet_Alura/entrada?acao=ListaEmpresas">Novo link Lista de empresas</a>
</body>
</html>