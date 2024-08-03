package Crud;

import Modelo.Consumo;
import utils.Conexion;
import Modelo.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class fconsumo {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalconsumo;

    public DefaultTableModel mostrar(String Buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "ID Reserva", "ID Producto", "Producto", "Cantidad", "Precio Venta", "Estado"};

        String[] registro = new String[7];

        totalregistros = 0;
        totalconsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select c.idconsumo,c.idreserva,c.idproducto,p.nombre,c.cantidad,c.precio_venta"
                + ",c.estado from consumo c inner join productos p on c.idproducto = p.idproductos"
                + " where c.idreserva = '" + Buscar + "' order by c.idconsumo desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precio_venta");
                registro[6] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                totalconsumo = totalconsumo + (rs.getInt("cantidad") * rs.getDouble("precio_venta"));
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Consumo con) {
        sSQL = "insert into consumo (idreserva,idproducto,cantidad,precio_venta,estado)"
                + "values (?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, con.getIdreserva());
            pst.setInt(2, con.getIdproducto());
            pst.setInt(3, con.getCant());
            pst.setDouble(4, con.getPv());
            pst.setString(5, con.getEstado());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Consumo con) {
        sSQL = "update consumo set idreserva=?,idproducto=?,cantidad=?,precio_venta=?,estado=?"
                + "where idconsumo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, con.getIdreserva());
            pst.setInt(2, con.getIdproducto());
            pst.setInt(3, con.getCant());
            pst.setDouble(4, con.getPv());
            pst.setString(5, con.getEstado());
            pst.setInt(6, con.getIdconsumo());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Consumo con) {
        sSQL = "delete from consumo where idconsumo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, con.getIdconsumo());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel mostrartodos(String cat) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "ID Reserva", "ID Producto", "Producto", "Categoria", "Cantidad", "Precio Venta", "Estado", "Fecha","Importe"};

        String[] registro = new String[10];

        totalregistros = 0;
        totalconsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select c.idconsumo,c.idreserva,c.idproducto,p.nombre,p.categoria,c.cantidad,c.precio_venta,r.fechareserva "
                + ",c.estado,c.cantidad * c.precio_venta as importe from consumo c inner join productos p on c.idproducto = p.idproductos"
                + " inner join reserva r on c.idreserva = r.idreserva where p.categoria like '%"
                + cat + "%' order by r.fechareserva desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("categoria");
                registro[5] = rs.getString("cantidad");
                registro[6] = rs.getString("precio_venta");
                registro[7] = rs.getString("estado");
                registro[8] = rs.getString("fechareserva");
                registro[9] = rs.getString("importe");

                totalregistros = totalregistros + 1;
                totalconsumo = totalconsumo + (rs.getInt("cantidad") * rs.getDouble("precio_venta"));
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel buscarporfechas(String buscar, String buscar2) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "ID Reserva", "ID Producto", "Producto", "Categoria", "Cantidad", "Precio Venta", "Estado", "Fecha"};

        String[] registro = new String[9];

        totalregistros = 0;
        totalconsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select c.idconsumo,c.idreserva,c.idproducto,p.nombre,p.categoria,c.cantidad,c.precio_venta,r.fechareserva "
                + ",c.estado from consumo c inner join productos p on c.idproducto = p.idproductos"
                + " inner join reserva r on c.idreserva = r.idreserva where r.fechareserva between '" + buscar + "' and '"
                + buscar2 + "' order by r.fechareserva desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("categoria");
                registro[5] = rs.getString("cantidad");
                registro[6] = rs.getString("precio_venta");
                registro[7] = rs.getString("estado");
                registro[8] = rs.getString("fechareserva");

                totalregistros = totalregistros + 1;
                totalconsumo = totalconsumo + (rs.getInt("cantidad") * rs.getDouble("precio_venta"));
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel buscarcat(String buscar, String buscar2, String cat) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "ID Reserva", "ID Producto", "Producto", "Categoria", "Cantidad", "Precio Venta", "Estado", "Fecha"};

        String[] registro = new String[9];

        totalregistros = 0;
        totalconsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select c.idconsumo,c.idreserva,c.idproducto,p.nombre,p.categoria,c.cantidad,c.precio_venta,r.fechareserva "
                + ",c.estado from consumo c inner join productos p on c.idproducto = p.idproductos"
                + " inner join reserva r on c.idreserva = r.idreserva where r.fechareserva between '" + buscar + "' and '"
                + buscar2 + "' and p.categoria = '" + cat + "' order by r.fechareserva desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("categoria");
                registro[5] = rs.getString("cantidad");
                registro[6] = rs.getString("precio_venta");
                registro[7] = rs.getString("estado");
                registro[8] = rs.getString("fechareserva");

                totalregistros = totalregistros + 1;
                totalconsumo = totalconsumo + (rs.getInt("cantidad") * rs.getDouble("precio_venta"));
                modelo.addRow(registro);
            }
            return modelo;
            
            

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
