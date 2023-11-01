/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bverg
 */
public class Docente extends Persona
{
    private String rut;
    private ArrayList <String> CursosImpartidos = new ArrayList<String>();
    private ArrayList <Docente> VectorDocentes = new ArrayList<Docente>();
    

    public Docente(String nombre, int edad, String email, String rut, String contrasena, ArrayList <String> CursosImpartidos) 
    {
        super(nombre, edad, email, contrasena);
        this.rut = rut; 
        this.CursosImpartidos = CursosImpartidos;
    }
    
    public Docente(){
        
    }
    
    public ArrayList<String> getCursosImpartidos() {
        return CursosImpartidos;
    }

    public void setCursosImpartidos(ArrayList<String> CursosImpartidos) {
        this.CursosImpartidos = CursosImpartidos;
    }


    public ArrayList<Docente> getVectorDocentes() {
        return VectorDocentes;
    }

    public void setVectorDocentes(ArrayList <Docente> VectorDocentes) {
        this.VectorDocentes = VectorDocentes;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    
    public void leerDatos()
    {
        Scanner entrada = new Scanner(System.in); 
        
        this.rut = entrada.nextLine();

        System.out.println("Ingrese el nombre");
        setNombre(entrada.nextLine());

        System.out.println("Ingrese la edad");
        setEdad(entrada.nextInt());

        System.out.println("Ingrese el email");
        setEmail(entrada.nextLine()); 


        System.out.println("Ingrese la contraseña");
        setContrasena(entrada.nextLine());
        
        agregarCurso();
    }

    public void agregarDatosDocentes()
    {
        Scanner entrada = new Scanner(System.in);
        while(true)
        {
            int x;
            x = entrada.nextInt();
            if(x == 0) break;

            else
           {
               leerDatos();
               VectorDocentes.add(new Docente(getNombre(), getEdad(), getEmail(), this.rut,  getContrasena(), this.CursosImpartidos));
           }
        }
    }

    public void mostrarDatosDocentes(){
        System.out.println("Nombre:" + getNombre());
        System.out.println("Edad:" + getEdad());
        System.out.println("Email:" + getEmail());
        System.out.println("Rut:" + this.rut);
        System.out.println("Contraseña:" + getContrasena());
    }
    
    public void modificarDocente(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el rut del docente buscado");
        String rutBucado = entrada.nextLine();
        int posicion = buscarDocente(rutBucado,VectorDocentes);
        if(posicion != -1){
            System.out.println("Modificar : \n1. Nombre 2.Edad 3.Email 4.Rut 5.Contraseña \n");
            int opcion = entrada.nextInt();
            switch (opcion){
                case 1:{
                    System.out.println("Ingrese el nombre");
                    setNombre(entrada.nextLine());
                }
                case 2:{
                    System.out.println("Ingrese la edad");
                    setEdad(entrada.nextInt());
                }
                case 3:{
                    System.out.println("Ingrese el email");
                    setEmail(entrada.nextLine());
                }
                case 4:{
                    System.out.println("Ingrese el rut");
                    setRut(entrada.nextLine()); 
                }
                case 5:{
                    System.out.println("Ingrese la contraseña");
                    setContrasena(entrada.nextLine());
                }
            }       
        }
        else{
            System.out.println("No se pudo encontrar el docente");
                 
        }
    }

    public int buscarDocente(String rut, ArrayList <Docente> VectorDocentes){
        for (int i = 0; i < VectorDocentes.size(); i++)
        {
            if (VectorDocentes.get(i).getRut().equals(rut))
            {
                System.out.println("El Docente con rut" + rut + "se ha encontrado correctamente");
                return i; 
            }
        }
        return -1 ;
    }
    
    public Docente buscarDocente(String rut)
    {
        for (int i = 0; i < VectorDocentes.size(); i++)
        {
            if (VectorDocentes.get(i).getRut().equals(rut))
            {
                System.out.println("El Docente con rut" + rut + "se ha encontrado correctamente");
                return VectorDocentes.get(i);
            }
        }
        return null;
    }
    
    public void eliminarDocente(String rut)
    {
        int pos = buscarDocente(rut, VectorDocentes);
        if(pos != -1){
            VectorDocentes.remove(pos);
            System.out.println("El Docente con rut" + rut + "se ha eliminado correctamente");
                 
        }
        else{
            System.out.println("No se pudo eliminar el docente respectivo");
                 
        }  
    }
    
    public void agregarCurso()
    {
        Scanner entrada = new Scanner(System.in);
        while(true)
        {
            String sigla;
            System.out.println("Ingrese la sigla");
            sigla = entrada.nextLine();
            if (sigla == "0")
                break;
            
            CursosImpartidos.add(sigla);            
        }
    }
    
    public int buscarCurso(String siglaBuscado)
    {
        for(int i = 0; i < CursosImpartidos.size(); i++)
        {    
            if(CursosImpartidos.get(i).equals(siglaBuscado))
                return i;   
        }
        return -1;
    }
    
    //eliminar cursooos
    
    public void eliminarCursoImpartido(ArrayList<String> CursosImpartidos, String sigla)
    {
        int posicion = buscarCurso(sigla);
        
        if(posicion != -1)
            CursosImpartidos.remove(posicion);
    }
    
    //eliminar de todos los pofrees
    public void eliminarCursosEnLista(String sigla){
        
        for(int i = 0; i < VectorDocentes.size(); i++)
        {
            eliminarCursoImpartido(VectorDocentes.get(i).CursosImpartidos, sigla);
        }
    }
    
    
}