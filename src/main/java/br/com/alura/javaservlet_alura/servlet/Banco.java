package br.com.alura.javaservlet_alura.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	
	//Metodo static é carregado quando a classe é iniciada
	static {
		
		Date data = new Date();
		
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setDataAbertura(data);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(data);
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

}
