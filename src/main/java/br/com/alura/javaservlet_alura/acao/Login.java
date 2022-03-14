package br.com.alura.javaservlet_alura.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.javaservlet_alura.modelo.Banco;
import br.com.alura.javaservlet_alura.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando... "+login);
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		
		if(usuario != null) {		
			System.out.println("Usuario logado "+ login);
			return "redirect:bem-vindo.html";
		}else {
			System.out.println("Login errado");
			return "redirect:entrada?acao=LoginForm";
		}
		
		
	}

}