package br.com.alura.javaservlet_alura.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {
       
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException { 	
    	
    	System.out.println("Autoriza��o Filter");    	
    	
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
    	HttpServletResponse response = (HttpServletResponse) servletResponse;
    	
    	String paramAcao = request.getParameter("acao");
    	
    	HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		
		//Todas as a��es que n�o forem referentes a login n�o ser�o permitidas.
    	boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
    	
		if(acaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
    	chain.doFilter(request, response);
    	 	
	}

  
    
}
