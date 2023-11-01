/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * @author bverg
 */
public class Persona 
{
     private String nombre;
     private int edad;
     private String email;
     private String contrasena;

    public Persona(String nombre, int edad, String email, String contrasena) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.contrasena = contrasena;
    }
    
    public Persona(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void leerDatos(){
        Scanner entrada = new Scanner(System.in); 
        
        System.out.println("Ingrese el nombre");
        this.nombre=entrada.nextLine();

        System.out.println("Ingrese la edad");
        this.edad=entrada.nextInt();

        System.out.println("Ingrese el email");
        this.email=entrada.nextLine(); 


        System.out.println("Ingrese la contraseña");
        this.contrasena=entrada.nextLine();
        
    }
    
    
    
    
    
     
}
