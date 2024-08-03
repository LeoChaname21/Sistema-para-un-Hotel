/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;
/**
 *
 * @author Juan
 */


public class Pedido {
    
    private int idpedido;
    private int idproveedor;
    private String tipo;
    private String descripcion;
    private double costo;
    private Date fechapedido;

    public Pedido(int idpedido, int idproveedor, String tipo, String descripcion, double costo, Date fechapedido) {
        this.idpedido = idpedido;
        this.idproveedor = idproveedor;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechapedido = fechapedido;
    }

    public Pedido() {
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(Date fechapedido) {
        this.fechapedido = fechapedido;
    }

    
    
}