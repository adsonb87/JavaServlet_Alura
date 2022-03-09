package br.com.alura.javaservlet_alura.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.javaservlet_alura.acao.ListaEmpresas;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String paramAcao = request.getParameter("acao");
    	
    	if(paramAcao.equals("listaEmpresa")) {
    		
    		ListaEmpresas acao = new ListaEmpresas();
    		acao.executa(request, response);
    		
    	} else if(paramAcao.equals("RemovaEmpresa")) {
    		System.out.println("Remova empresa");
    	} else if(paramAcao.equals("mostraEmpresa")) {
    		System.out.println("Mostra empresa");
    	}
	}

}
