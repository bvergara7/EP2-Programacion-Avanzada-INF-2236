/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author bverg
 */

import java.util.ArrayList;
import java.util.Scanner;


public class Estudiante extends Persona 
{
   
 
    private String apodo; 
    private String codigoEstudiante; 
    
    private ArrayList <String> CursosInscritos = new ArrayList<String>();
    
    private ArrayList <Estudiante> VectorEstudiantes  = new ArrayList <Estudiante>();
    
    
    
   public Estudiante(String nombre, int edad, String email, String apodo, String contrasena, String codigoEstudiante)
   {
       super(nombre, edad, email, contrasena);
   
       this.apodo = apodo;
       this.codigoEstudiante = codigoEstudiante;
             

   }
   
   public Estudiante(){
       super();
   }
   
   

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public ArrayList<String> getCursosInscritos() {
        return CursosInscritos;
    }

    public void setCursosInscritos(ArrayList<String> CursosInscritos) {
        this.CursosInscritos = CursosInscritos;
    }

    public ArrayList<Estudiante> getVectorEstudiantes() {
        return VectorEstudiantes;
    }

    public void setVectorEstudiantes(ArrayList<Estudiante> VectorEstudiantes) {
        this.VectorEstudiantes = VectorEstudiantes;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public void leerDatos()
    {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el nombre");
        setNombre(entrada.nextLine());

        System.out.println("Ingrese la edad");
        setEdad(entrada.nextInt());
        entrada.next();

        System.out.println("Ingrese el email");
        setEmail(entrada.nextLine()); 

        System.out.println("Ingrese el apodo");
        this.apodo = entrada.nextLine();

        System.out.println("Ingrese la contraseña");
        setContrasena(entrada.nextLine());
        
        System.out.println("Ingrese el codigo del Estudiante");
        setCodigoEstudiante(entrada.nextLine());
       
    }
    
    public void agregarDatosEstudiante()
    {
        Scanner entrada = new Scanner(System.in);
        while(true)
        {
            int x;
            x = entrada.nextInt();
            if(x == 0) break;

            else
           {
               //String nombre, int edad, String email, String apodo, String contrasena, String codigoEstudiante
               leerDatos();
               VectorEstudiantes.add(new Estudiante(getNombre(), getEdad(), getEmail(), this.apodo,  getContrasena(), this.codigoEstudiante));
           }
        }
    }
    
    
    public void mostrar()
    {
        System.out.println("Nombre Completo: " + getNombre());
        System.out.println("Edad del usuario: " +  getEdad());
        System.out.println("Email del usuario: " + getEmail());
        System.out.println("Apodo: " + this.apodo);
        System.out.println("Contraseña: " + getContrasena());
 

        int largoCursos = CursosInscritos.size();
        int i;

        System.out.println("Cursos tomados: ");
        for(i = 0; i < largoCursos; i++)
            System.out.println(CursosInscritos.get(i));
    }
    
    public void modificarEstudiante(){
        Scanner entrada = new Scanner(System.in);
        int posicion = buscarEstudiante(codigoEstudiante);
        if(posicion != -1){
            System.out.println("Modificar : \n1. Nombre 2.Edad 3.Apodo 4. Email 5.Contraseña 6. Codigo\n");
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
                    System.out.println("Ingrese el apodo");
                    setApodo(entrada.nextLine());
                }
                case 4:{
                    System.out.println("Ingrese el email");
                    setEmail(entrada.nextLine()); 
                }
                case 5:{
                    System.out.println("Ingrese la contraseña");
                    setContrasena(entrada.nextLine());
                }
                case 6:{       
                    System.out.println("Ingrese el codigo del Estudiante");
                    setCodigoEstudiante(entrada.nextLine());
                }
                
            }
            
                 
        }
        else{
            System.out.println("No se pudo encontrar el estudiante");
                 
        }
    }
    
    public int buscarEstudiante(String codigoBuscado)
    {
        for (int i = 0; i < VectorEstudiantes.size(); i++)
        {
             if (VectorEstudiantes.get(i).codigoEstudiante.equals(codigoBuscado))
             {
                 System.out.println("El Estudiante con codigo" + codigoEstudiante + "se ha encontrado correctamente");
                 return i; 
             }
        }
        return -1 ;
    }
    
    public void eliminarEstudiante(String codigoEstudiante)
    {
        int posicion = buscarEstudiante(codigoEstudiante);
        if(posicion != -1){
            VectorEstudiantes.remove(posicion);
            System.out.println("El Estudiante con codigo" + codigoEstudiante + "se ha eliminado correctamente");
                 
        }
        else{
            System.out.println("No se pudo eliminar el estudiante");
                 
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
            
            CursosInscritos.add(sigla);            
        }
    }
    
    //buscar cursooo
    
    public int buscarCurso(String sigla)
    {
        for (int i = 0; i < CursosInscritos.size(); i++)
        {
             if (CursosInscritos.get(i).equals(sigla))
             {
                 System.out.println("El curso con sigla" + sigla + "se ha encontrado correctamente");
                 return i; 
             }
        }
        System.out.println("El curso con sigla" + sigla + "no se ha encontrado");
        return -1 ;
    }
    
    //eliminaaaar cursoooo
    
    public void eliminarCursoInscrito(ArrayList<String> CursosInscritos, String sigla) 
    {
        int posicion = buscarCurso(sigla);
        if(posicion != -1)
        {
            CursosInscritos.remove(posicion);
            
            System.out.println("El Curso con sigla" + sigla +  "se pudo eliminar correctamente");
            
        }else{
            System.out.println("Cursos No Inscrito no se pudo eliminar");
        }
    }
    
    public void eliminarCursosEnLista(String sigla){
        
        for(int i = 0; i < VectorEstudiantes.size(); i++)
        {
            eliminarCursoInscrito(VectorEstudiantes.get(i).CursosInscritos, sigla);
        }
    }
    
    
}