package Crud;

import Modelo.Pedido;
import utils.Conexion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class fpedido {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private  String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","idproveedor","proveedor","tipo","descripcion","costo","Fecha"};
        
        String [] registro =new String [7];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select r.idpedido,r.idproveedor,"+
                "(select nombre from persona where idpersona=r.idproveedor)as proveedorn,"+ 
                "(select apellidopaterno from persona where idpersona=r.idproveedor)as proveedorap,r.tipo,r.descripcion,"+
                "r.costo,r.fechapedido from pedido r where r.fechapedido like '%"+Buscar+
                "%' order by idpedido desc";
        
        
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpedido");           
                registro [1]=rs.getString("idproveedor");
                registro [2]=rs.getString("proveedorn")+ " "+rs.getString("proveedorap");
                registro [3]=rs.getString("tipo");
                registro [4]=rs.getString("descripcion");
                registro [5]=rs.getString("costo");
                registro [6]=rs.getString("fechapedido");   
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
    public boolean insertar(Pedido rsv){
        sSQL="insert into pedido (idproveedor,tipo,descripcion,costo,fechapedido)"+
                "values (?,?,?,?,?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
      
            pst.setInt(1, rsv.getIdproveedor());
            pst.setString(2, rsv.getTipo());
            pst.setString(3, rsv.getDescripcion());
            pst.setDouble(4, rsv.getCosto());
            pst.setDate(5, rsv.getFechapedido());           
        
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
    
    public boolean editar(Pedido rsv){
        sSQL="update pedido set idproveedor=?,tipo=?,descripcion=?,costo=?,fechapedido=?"+
                "where idpedido=?";
       
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
 
            pst.setInt(1, rsv.getIdproveedor());
            pst.setString(2, rsv.getTipo());
            pst.setString(3, rsv.getDescripcion());  
            pst.setDouble(4, rsv.getCosto());
            pst.setDate(5, rsv.getFechapedido());
            pst.setInt(6, rsv.getIdpedido());
            
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
    
    public boolean eliminar(Pedido rsv){
        sSQL="delete from pedido where idpedido=?";     
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, rsv.getIdpedido());
            
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
        
        String [] titulos= {"ID","idproveedor","proveedor","tipo","Fecha","descripcion","Costo"};
        
        String [] registro =new String [7];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select r.idpedido,r.idproveedor,"+
                "(select nombre from persona where idpersona=r.idproveedor)as proveedorn,"+ 
                "(select apellidopaterno from persona where idpersona=r.idproveedor)as proveedorap,r.tipo,r.fechapedido,"+
                "r.descripcion,r.costo from pedido r where r.fechapedido like '%"+Buscar+
                "%' order by idpedido desc";
        
      
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpedido");
         
                registro [1]=rs.getString("idproveedor");
                registro [2]=rs.getString("proveedorn")+ " "+rs.getString("proveedorap");
                registro [3]=rs.getString("tipo");
                registro [4]=rs.getString("fechapedido");
                
                registro [5]=rs.getString("descripcion");
                registro [6]=rs.getString("costo");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
}
