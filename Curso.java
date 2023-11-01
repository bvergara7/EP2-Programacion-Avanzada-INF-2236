/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author bverg
 */
public class Curso 
{
    private String sigla;
    private String area;  
    private ArrayList <String> rutEstudiantes = new ArrayList<String>();
    private Docente docenteTitular;
    private ArrayList <String> idMateriales = new ArrayList<String>();
    private ArrayList <String> idReuniones = new ArrayList<String>();
    
    //Aquí va la ruta del archivo csv con los datos a leer
    public static String file = "";
    private ArrayList <Curso> listaCursos = new ArrayList <Curso>();

    public Curso(ArrayList <String> rutAlumnos, Docente docenteTitular, ArrayList <String> materialAsociado, String sigla, String area, ArrayList <String> sesion) 
    {
        this.rutEstudiantes = rutAlumnos;
        this.docenteTitular = docenteTitular;
        this.idMateriales = materialAsociado;
        this.sigla = sigla;
        this.area = area;
        this.idReuniones = sesion;
    }
    public Curso()
    {
        
    }    

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ArrayList<String> getRutEstudiantes() {
        return rutEstudiantes;
    }

    public void setRutEstudiantes(ArrayList<String> rutEstudiantes) {
        this.rutEstudiantes = rutEstudiantes;
    }

    public Docente getDocenteTitular() {
        return docenteTitular;
    }

    public void setDocenteTitular(Docente docenteTitular) {
        this.docenteTitular = docenteTitular;
    }

    public ArrayList<String> getIdMateriales() {
        return idMateriales;
    }

    public void setIdMateriales(ArrayList<String> idMateriales) {
        this.idMateriales = idMateriales;
    }

    public ArrayList<String> getIdReuniones() {
        return idReuniones;
    }

    public void setIdReuniones(ArrayList<String> idReuniones) {
        this.idReuniones = idReuniones;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    
    public Curso leerDatosCurso() 
    {
        Scanner entrada = new Scanner(System.in);
        this.sigla = entrada.nextLine();
        this.area = entrada.nextLine();
        String rutDocente = entrada.nextLine();
        this.docenteTitular = docenteTitular.buscarDocente(rutDocente);
       
        this.rutEstudiantes= agregarEstudiantes();
        this.idMateriales = agregarMateriales();
        this.idReuniones = agregarReunion();

        return new Curso(this.rutEstudiantes, this.docenteTitular, this.idMateriales, this.sigla, this.area,this.idReuniones);
    }

    public void agregarCurso()
    {
        Scanner entrada = new Scanner(System.in);
        while(true){
            int x = entrada.nextInt();
            if(x==0) break;

            Curso cursoN = leerDatosCurso();

            listaCursos.add(cursoN);

        }
    }

    public int buscarCurso(String sigla){
        for (int i = 0; i < listaCursos.size(); i++)
        {
             if (listaCursos.get(i).getSigla().equals(sigla))
             {
                 System.out.println("El curso con sigla" + sigla + "se ha encontrado correctamente");
                 return i; 
             }
        }
        return -1 ;  
    }
    
    public void eliminarCurso(String sigla){
        int pos = buscarCurso(sigla);
        
        if(pos != -1){
            listaCursos.remove(pos);
           
            Estudiante est = new Estudiante();
            est.eliminarCursosEnLista(sigla);
            Docente doc = new Docente();

            doc.eliminarCursosEnLista(sigla);
            
   
            System.out.println("El curso con sigla" + sigla + "se ha eliminado correctamente");
                 
        }
        
        else{
            System.out.println("El curso no se pudo eliminar");
        }
    }

    public void mostrarDatos()
    {
        int size = listaCursos.size();
        for (int i = 0; i < size; i++)
        {
            System.out.println(listaCursos.get(i));

        }
    }
    
    
    public void modificarCurso(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese sigla del curso que desea modificar.");
        String siglaBuscar = entrada.nextLine();
        int posicion = buscarCurso(siglaBuscar);
        if(posicion != -1){
            System.out.println("Modificar : \n1. Sigla 2.Area 3.Docente Titular\n");
            int opcion = entrada.nextInt();
            switch (opcion){
                case 1:{
                    System.out.println("Ingrese la nueva Sigla.");
                    setSigla(entrada.nextLine());
                }
                case 2:{
                    System.out.println("Ingrese el Area nueva.");
                    setArea(entrada.nextLine());
                }
                case 3:{
                    System.out.println("Ingrese el nuevo Docente Titular.");
                    Docente doc = new Docente();
                    doc.modificarDocente();
                }
                
            }
                     
        }
        else{
            System.out.println("No se pudo encontrar el estudiante");
                 
        }
    }
    public ArrayList <String> agregarEstudiantes()
    {
        Scanner entrada = new Scanner(System.in);
        while(true)
        {
            String rut;
            System.out.println("Ingrese el rut");
            rut = entrada.nextLine();
            if (rut == "0")
                break;
            
            rutEstudiantes.add(rut);            
        }
        return null;
    }
    
    public int buscarEstudiante(String rut)
    {
        for (int i = 0; i < rutEstudiantes.size(); i++)
        {
             if (rutEstudiantes.get(i).equals(rut))
             {
                 System.out.println("El estudiante con rut" + rut + "se ha encontrado correctamente");
                 return i; 
             }
        }
        System.out.println("El estudiante con rut" + rut + "no se ha encontrado");
        return -1 ;
    }
    
    public void eliminarEstudiante(ArrayList<String> rutEstudiantes, String rut) 
    {
        int posicion = buscarEstudiante(rut);
        if(posicion != -1)
        {
            rutEstudiantes.remove(posicion);
            
            System.out.println("El estudiante con rut" + rut +  "se pudo eliminar correctamente");
            
        }else{
             System.out.println("El estudiante con rut" + rut + "no se pudo eliminar");
        }
    }
    
    public void eliminarCursosEnLista(String sigla){
        
        for(int i = 0; i < listaCursos.size(); i++)
        {
            eliminarEstudiante(listaCursos.get(i).rutEstudiantes, sigla);
        }
    }
    
    ////////////////////
    
    
    public ArrayList <String> agregarMateriales()
    {
        Scanner entrada = new Scanner(System.in);
        while(true)
        {
            String id;
            System.out.println("Ingrese el id del material");
            id = entrada.nextLine();
            if (id == "0")
                break;
            
            idMateriales.add(id);            
        }
        return null;
    }
    
    public int buscarMaterial(String id)
    {
        for (int i = 0; i < idMateriales.size(); i++)
        {
             if (idMateriales.get(i).equals(id))
             {
                 System.out.println("El material con id" + id + "se ha encontrado correctamente");
                 return i; 
             }
        }
        System.out.println("El material con id" + id + "no se ha encontrado");
        return -1 ;
    }
    
    public void eliminarMaterial(ArrayList<String> idMateriales, String id) 
    {
        int posicion = buscarEstudiante(id);
        if(posicion != -1)
        {
            idMateriales.remove(posicion);
            
            System.out.println("El material con id" + id +  "se pudo eliminar correctamente");
            
        }else{
             System.out.println("El material con id" + id + "no se pudo eliminar");
        }
    }
    
    public void eliminarMaterialesEnCursos(String id){
        
        for(int i = 0; i < listaCursos.size(); i++)
        {
            eliminarEstudiante(listaCursos.get(i).idMateriales, id);
        }
    }
    
    ////////////////////
    
    public ArrayList <String> agregarReunion()
    {
        Scanner entrada = new Scanner(System.in);
        while(true)
        {
            String id;
            System.out.println("Ingrese el id de la reunion");
            id = entrada.nextLine();
            if (id == "0")
                break;
            
            idReuniones.add(id);            
        }
        return null;
    }
    
    public int buscarReuniones(String id)
    {
        for (int i = 0; i < idReuniones.size(); i++)
        {
             if (idReuniones.get(i).equals(id))
             {
                 System.out.println("La reunion con id" + id + "se ha encontrado correctamente");
                 return i; 
             }
        }
        System.out.println("La reunion con id" + id + "no se ha encontrado");
        return -1 ;
    }
    
    public void eliminarReunion(ArrayList<String> idReuniones, String id) 
    {
        int posicion = buscarEstudiante(id);
        if(posicion != -1)
        {
            idReuniones.remove(posicion);
            
            System.out.println("La reunion con id" + id +  "se pudo eliminar correctamente");
            
        }else{
             System.out.println("la reunion con id" + id + "no se pudo eliminar");
        }
    }
    
    public void eliminarReunionesEnCursos(String id){
        
        for(int i = 0; i < listaCursos.size(); i++)
        {
            eliminarEstudiante(listaCursos.get(i).idReuniones, id);
        }
    }
    
}
