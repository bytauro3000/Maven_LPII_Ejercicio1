package org.cibertec;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static Connection con = null;
	private static String URL = "jdbc:mysql://localhost:3306/dbAcademico";
	private static String USER = "ever";
	private static String PASS = "mysql";

	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Conexion Exitosa con Maven");
			
			
		} catch (Exception ex) {
			System.out.println("Error al abrir Conexion: " + ex.getMessage());
			// TODO: handle exception
		}
		return con;
	}
	
	public static void main(String[] args) {
		conectar();
	}
}
