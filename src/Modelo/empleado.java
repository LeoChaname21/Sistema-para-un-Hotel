/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.persona;

/**
 *
 * @author Juan
 */
public class empleado extends persona {
    
    private Double sueldo;
    private String cargo;


    public empleado() {
    }

    public empleado(Double sueldo, String Cargo) {
        this.sueldo = sueldo;
        this.cargo = Cargo;
   
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String Cargo) {
        this.cargo = Cargo;
    }

    
    
    
    
    
     
    
}
