<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,br.com.alura.javaservlet_alura.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty empresa }">
		Empresa ${empresa} cadastrada com sucesso!!!
	</c:if>
	
	<br/>
	<br/> Lista de empresas: <br/>
	
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			
			<li>
				
				${empresa.id} - ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
				<a href="/JavaServlet_Alura/mostraEmpresa?id=${empresa.id}">edita</a>
				<a href="/JavaServlet_Alura/removeEmpresa?id=${empresa.id}">remove</a>
				<a href="/JavaServlet_Alura/entrada?acao=mostraEmpresa&id=${empresa.id}">edita (Link novo)</a>
				<a href="/JavaServlet_Alura/entrada?acao=removeEmpresa&id=${empresa.id}">remove (link novo)</a>
			</li>
		
		</c:forEach>
		
	</ul>
	
	<br/>
	
	<a href="/JavaServlet_Alura/bem-vindo.html">Home</a></br></br>
	<a href="/JavaServlet_Alura/entrada?acao=NovaEmpresaForm">Nova Empresa</a>
	
	
</body>
</html>