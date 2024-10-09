/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consulta;

import java.util.List;

public class Persona{
    private String DNI;
    private String nombre;
    private int edad;

    public Persona(String DNI, String nombre, int edad){   
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;

    }

    public int getEdad(){
        return this.edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDNI(){
        return this.DNI;
    }

    public String toString(){
        return ("DNI: "+this.DNI+", Nombre: "+this.nombre+", Edad: "+this.edad);
    }
}