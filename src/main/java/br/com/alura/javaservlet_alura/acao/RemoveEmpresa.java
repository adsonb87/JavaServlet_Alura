package br.com.alura.javaservlet_alura.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.javaservlet_alura.modelo.Banco;

public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Empresa removida.");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
				
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}
}
