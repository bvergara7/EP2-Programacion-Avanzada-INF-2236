/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;



import java.text.ParseException;
import java.util.Scanner;


public class Menu 
{

    public String file = "src/test/datos.txt";
    public static Estudiante estudiante = new Estudiante();
    
    public static void main(String[] args) throws ParseException 
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido al Aula Virtual");
        // agregar, mostrar, actualizar, eliminar
        
        System.out.println("Desea ingresar como Estudiante o docente \n1: Estudiante 2:Docente");
        int i = entrada.nextInt();
        if(i == 1){
            //estudianteeeee
            
            System.out.println("1. Agregar Estudiante, 2. Mostrar Estudiantes\n");
            System.out.println("3. Actualizar/modificar información 4. Eliminar Estudiante");
            int opcion = entrada.nextInt();
            
            switch (opcion){
                case 1->{estudiante.leerDatos();}
                case 2->estudiante.mostrar();
                case 3->estudiante.modificarEstudiante();
                case 4->{
                    String codigo = entrada.next();
                    estudiante.eliminarEstudiante(codigo);
                }
                default-> System.out.println("Opcion no valida");
            } 
        }
        else{
            //docenteeee
            Docente profe = new Docente();
            System.out.println("1. Agregar Profesor, 2. Mostrar Profesores 3. Modificar informacion 4. Eliminar Profesor");
            int opcion = entrada.nextInt();
            
            switch (opcion){
                case 1:profe.agregarDatosDocentes();
                case 2:profe.mostrarDatosDocentes();
                case 3:profe.modificarDocente();
                case 4:{
                    String rut = entrada.next();
                    profe.eliminarDocente(rut);
                }
                default:
                    System.out.println("Opcion no valida");
                
                
            }
            //otras funciones para docentes
            
            System.out.println("¿Desea operar los cursos? (1: Agregar 2:Mostrar 3: Modificar informacion 4:Eliminar\n)");
            opcion = entrada.nextInt();
            Curso curso = new Curso();
            switch (opcion){
                case 1:curso.agregarCurso();
                case 2:curso.mostrarDatos();
                case 3:curso.modificarCurso();
                case 4:{
                    String sigla = entrada.next();
                    curso.eliminarCurso(sigla);
                }
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("Desea operar los materiales? (1: Agregar 2:Mostrar 3:Modificar informacion 4:Eliminar)\n");
            opcion = entrada.nextInt();
            Material material = new Material();
            switch (opcion){
                case 1:material.agregar();
                case 2:material.mostrarDatos();
                case 3:material.modificarMaterial();
                case 4:{
                    String idMaterial = entrada.next();
                    material.eliminar(idMaterial);
                }
                default:
                    System.out.println("Opcion no valida");
            }
                        
            System.out.println("¿Desea operar las reuniones? (1: Agregar 2:Mostrar 3:Modificar informacion 4:Eliminar)\n");
            opcion = entrada.nextInt();
            Reunion reunion = new Reunion();
            switch (opcion)
            {
                case 1:reunion.AgregarDatosReunion(); 
                case 2:reunion.mostrarDatosReunion();
                case 3:reunion.modificarDatosReunion();
                case 4:{
                    String idReunion = entrada.next();
                    reunion.eliminar(idReunion);
                }
                default:
                    System.out.println("Opcion no valida");
            }
            
        }
        
    }
}


