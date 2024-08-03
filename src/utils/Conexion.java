package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	

    public Conexion() {
    }
	public Connection conectar() {
             Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3307/gestionhotel";
			String user="root";
			String pass="";
			conn = DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println("Error de conexion: "+ex.getMessage());
		}
		return conn;
	}
            
    public static ResultSet getTabla(String SQL){
        Conexion conectar = new Conexion();
        Connection con = conectar.conectar();
        Statement st;
        ResultSet datos=null;
        try
        {
         st=con.createStatement();
         datos=st.executeQuery(SQL);
        }
        catch(Exception e){
            System.out.println(e.toString());   
        }
        return datos;
        
        
    }
	
}
