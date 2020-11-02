package br.com.prog2.rh.view;

import java.sql.Connection;
import br.com.prog2.rh.controller.ClienteController;
import br.com.prog2.rh.model.Cliente;
import br.com.prog2.rh.persistencia.ConnectionFactory;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if(con != null){
			System.out.println("OK");
			ConnectionFactory.close(con);
		}

		
		Cliente emp = new Cliente();
		ClienteController controller = new ClienteController();
		emp.setRgCliente("123456789");
		System.out.println(controller.excluir(emp));
	}
	
}