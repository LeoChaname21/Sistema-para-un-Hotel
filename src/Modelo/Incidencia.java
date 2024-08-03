
package Modelo;

import java.sql.Date;

/**
 *
 * @author Sandro
 */
public class Incidencia {
    private int idIncidencia;
    private int piso;
    private Date fecha;
    private String descripcion;
    private String estado;

    public Incidencia() {
    }

    public Incidencia(int idIncidencia, int piso, Date fecha, String descripcion, String estado) {
        this.idIncidencia = idIncidencia;
        this.piso = piso;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

   

   
    
    
}
