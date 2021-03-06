package br.com.alura.javaservlet_alura.acao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.javaservlet_alura.modelo.Banco;
import br.com.alura.javaservlet_alura.modelo.Empresa;

public class ListaEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Listando empresas");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
				
		return "forward:listaEmpresas.jsp";
		
		
	}
}
