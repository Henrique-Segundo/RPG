package br.com.rpg.dal;

import java.sql.*;

public class ModuloConexao {

	//metodo de conecxão com o banco
	public static Connection conector() {
	java.sql.Connection conexao = null;
	
	//"chamar" o driver
	String driver = "com.mysql.cj.jdbc.Driver";
	
	// informações do banco
	String url="jdbc:mysql://localhost:3306/dbRPGtormenta";
	String user="root";
	String password="ufc123";
	
	//estabelecer conecxão
	try {
		Class.forName(driver);
		conexao = DriverManager.getConnection(url, user, password);
		return conexao;
	} catch (Exception e) {
		 return null;
	}
}
}