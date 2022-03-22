package br.com.alura.javaservlet_alura.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.javaservlet_alura.acao.Acao;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String paramAcao = request.getParameter("acao");
    	
//    	HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//		
//		//Todas as ações que não forem referentes a login não serão permitidas.
//    	boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//    	
//		if(acaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
//    	 	
    	
    	String nomeDaClasse = "br.com.alura.javaservlet_alura.acao." + 
    							paramAcao;
    	
    	String nome;
    	
		try {
			Class classe = Class.forName(nomeDaClasse);
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj;
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
    	
		
		String[] tipoEndereco =  nome.split(":");
    	
    	if(tipoEndereco[0].equals("forward")) {
    		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
    		rd.forward(request, response);
    	}else  {
    		response.sendRedirect(tipoEndereco[1]);
    	}
		
		
		
		
		
//    	String nome = null; 
//    			
//    	if(paramAcao.equals("listaEmpresas")) {
//    		ListaEmpresas acao = new ListaEmpresas();
//    		 nome = acao.executa(request, response);   		
//    	} else if(paramAcao.equals("removeEmpresa")) {
//    		RemoveEmpresa acao = new RemoveEmpresa();
//    		nome = acao.executa(request, response);
//    	} else if(paramAcao.equals("mostraEmpresa")) {
//    		MostraEmpresa acao = new MostraEmpresa();
//    		nome = acao.executa(request, response);
//    	} else if(paramAcao.equals("alteraEmpresa")) {
//    		AlteraEmpresa acao = new AlteraEmpresa();
//    		nome = acao.executa(request, response);
//    	} else if(paramAcao.equals("novaEmpresa")) {
//    		NovaEmpresa acao = new NovaEmpresa();
//    		nome = acao.executa(request, response);
//    	} else if(paramAcao.equals("NovaEmpresaForm")) {
//    		NovaEmpresaForm acao = new NovaEmpresaForm();
//    		nome = acao.executa(request, response);
//    	}
    	
   
	}

}
