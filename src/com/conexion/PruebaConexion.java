package com.conexion;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class PruebaConexion {
	final static Logger logger = Logger.getLogger(PruebaConexion.class); 

	public static void main(String[] args) {
		try{
			
		
		Conecta db = new Conecta();
		db.conectSQL();
		
		String Query = "SELECT * FROM producto";
		
		db.comando = db.conexion.createStatement();
		db.registro = db.comando.executeQuery(Query);
        while (db.registro.next()) {
            
            logger.info("\nID: " + db.registro.getString(1) + 
                    "\nNombre: " + db.registro.getString(2) +
                    "\nPrecio: " + db.registro.getString(3) +
                    "\nId_Fabrica: " + db.registro.getString(4));
            
            System.out.println("------------------------------------------");
        }
        db.conexion.close();
		}catch(SQLException ex){
			logger.error("Error al executar el QUERY: " + ex.getMessage());
		}

	}

}
