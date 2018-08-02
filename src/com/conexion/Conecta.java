package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class Conecta {
	final static Logger logger  = Logger.getLogger(Conecta.class);
	Connection conexion = null;
	Statement comando = null;
	ResultSet registro;
	
	@SuppressWarnings("finally")
	public Connection conectSQL(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/testweb";
			String user = "root";
			String pass = "holamundo";
			conexion = DriverManager.getConnection(servidor, user, pass);
//		}catch(ClassNotFoundException ex){
//			logger.error("Error en la conexión a la base de datos: " + ex.getMessage());
//			conexion = null;
		}catch(SQLException ex){
			logger.error("Error en la conexión a la base de datos: " + ex.getMessage());
			conexion = null;
		}catch(Exception e){
			logger.error("Error en la conexión a la base de datos: " + e.getMessage());
			conexion = null;
		} finally {
			logger.info("CONEXION EXITOSA");
			return conexion;
		}
	}

}
