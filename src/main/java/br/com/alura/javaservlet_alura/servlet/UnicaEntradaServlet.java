package br.com.alura.javaservlet_alura.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.javaservlet_alura.acao.AlteraEmpresa;
import br.com.alura.javaservlet_alura.acao.ListaEmpresas;
import br.com.alura.javaservlet_alura.acao.MostraEmpresa;
import br.com.alura.javaservlet_alura.acao.NovaEmpresa;
import br.com.alura.javaservlet_alura.acao.NovaEmpresaForm;
import br.com.alura.javaservlet_alura.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String paramAcao = request.getParameter("acao");
    	String nome = null;
    			
    	if(paramAcao.equals("listaEmpresas")) {
    		
    		ListaEmpresas acao = new ListaEmpresas();
    		 nome = acao.executa(request, response);
    		
    	} else if(paramAcao.equals("removeEmpresa")) {
    		RemoveEmpresa acao = new RemoveEmpresa();
    		nome = acao.executa(request, response);
    	} else if(paramAcao.equals("mostraEmpresa")) {
    		MostraEmpresa acao = new MostraEmpresa();
    		nome = acao.executa(request, response);
    	} else if(paramAcao.equals("alteraEmpresa")) {
    		AlteraEmpresa acao = new AlteraEmpresa();
    		nome = acao.executa(request, response);
    	} else if(paramAcao.equals("novaEmpresa")) {
    		NovaEmpresa acao = new NovaEmpresa();
    		nome = acao.executa(request, response);
    	} else if(paramAcao.equals("NovaEmpresaForm")) {
    		NovaEmpresaForm acao = new NovaEmpresaForm();
    		nome = acao.executa(request, response);
    	}
    	
    	String[] tipoEndereco =  nome.split(":");
    	
    	if(tipoEndereco[0].equals("forward")) {
    		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
    		rd.forward(request, response);
    	}else  {
    		response.sendRedirect(tipoEndereco[1]);
    	}
	}

}
