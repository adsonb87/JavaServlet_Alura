package br.com.alura.javaservlet_alura.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.javaservlet_alura.acao.Acao;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class ControladorFilter extends HttpFilter implements Filter {
       

	@Override
	public void init() throws ServletException {
	
	}
	
	@Override
	public void destroy() {
	
	}
	
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException { 	
    	
    	System.out.println("Controlador Filter");    	
    	
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
    	HttpServletResponse response = (HttpServletResponse) servletResponse;
    	
    	String paramAcao = request.getParameter("acao");
    	
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
    	 	
	}

  
    
}
