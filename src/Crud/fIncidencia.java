
package Crud;

import Modelo.Incidencia;
import utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author Sandro
 */
public class fIncidencia {
    private Conexion conectar = new Conexion();
    private Connection con = conectar.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
     public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","N° HABITACIÓN","FECHA_INCIDENTE","DESCRIPCIÓN","ESTADO"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
            sSQL="select * from indicidencia where idHabitacion like '"+Buscar+"%' order by idIncidencia desc";
        
        try {
            
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idIncidencia");
                registro [1]=rs.getString("idHabitacion");
                registro [2]=rs.getString("fecha");
                registro [3]=rs.getString("descripcion");
                registro [4]=rs.getString("estado");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
       
    }
     
     public boolean insertar(Incidencia pdt){
        sSQL="insert into indicidencia (idHabitacion,fecha,descripcion,estado)"+
                "values (?,?,?,?)";
        
        try {
            PreparedStatement pst=con.prepareStatement(sSQL);
            pst.setInt(1, pdt.getPiso());
            pst.setDate(2,  pdt.getFecha());
            pst.setString(3, pdt.getDescripcion());
            pst.setString(4, pdt.getEstado());

            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
    
    public boolean editar(Incidencia pdt){
        sSQL="update indicidencia set idHabitacion=?,fecha=?,descripcion=?, estado=?"+
                "where idIncidencia=?";
        
        try {
            PreparedStatement pst=con.prepareStatement(sSQL);
            pst.setInt(1, pdt.getPiso());
            pst.setDate(2,  pdt.getFecha());
            pst.setString(3, pdt.getDescripcion());
            pst.setString(4, pdt.getEstado());
            pst.setInt(5, pdt.getIdIncidencia());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
    
    public boolean eliminar(Incidencia pdt){
        sSQL="delete from indicidencia where idIncidencia=?";     
        try {
            PreparedStatement pst=con.prepareStatement(sSQL);
            
            pst.setInt(1, pdt.getIdIncidencia());
            
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
     public DefaultTableModel mostrarvista(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","N° HABITACIÓN","FECHA_INCIDENTE","DESCRIPCIÓN","ESTADO"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from indicidencia where idHabitacion like '%"+Buscar+"%' order by idHabitacion desc";
        
        try {
            
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idIncidencia");
                registro [1]=rs.getString("idHabitacion");
                registro [2]=rs.getString("fecha");
                registro [3]=rs.getString("descripcion");
                registro [4]=rs.getString("estado");
                
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
     
    public DefaultPieDataset numeroIncidencias(){
        DefaultPieDataset torta = new DefaultPieDataset();

        try {
           

            
            String sql = "SELECT idHabitacion, COUNT(*) AS cantidad FROM indicidencia GROUP BY idHabitacion";

            
            PreparedStatement pst = con.prepareStatement(sql);

            
            ResultSet rs = pst.executeQuery();

            
            while (rs.next()) {
                int habitacion = rs.getInt("idHabitacion");
                int cantidad = rs.getInt("cantidad");
                torta.setValue("Habitación " + habitacion, cantidad);
            }

            
            rs.close();
            rs.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return torta;
    }
}
