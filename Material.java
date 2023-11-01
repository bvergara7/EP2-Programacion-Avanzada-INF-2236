package com.mycompany.main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileWriter;



public class Material 
{
    private String link;
    private Date fecha;
    private String titulo;
    private String idMaterial;
    
    
    //Aquí va la ruta del archivo csv con los datos a leer
    public static String file = "";
    private static ArrayList <Material> materiales = new ArrayList<Material>();
    
    

    public Material(String link, Date fecha, String titulo, String idMaterial) 
    {
        this.link = link;
        this.fecha = fecha;
        this.titulo = titulo;
        this.idMaterial = idMaterial;
    }
    public Material()
    {
        
    }    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }
    
    
    
    public void Leer() throws CsvValidationException{
        File file = new File(this.file);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);
        
            String[] nextRecord;
            
            // we are going to read data line by line
            int i=0;
            while ((nextRecord = reader.readNext()) != null) {
                
                Date fecha=new SimpleDateFormat("dd/mm/yyyy").parse(nextRecord[1]);
                
                if(i>0)materiales.add(new Material(nextRecord[0],fecha,nextRecord[2],nextRecord[4]));
                  
                
                
                for (String cell : nextRecord) {
                    
                    System.out.print(cell + "\t");
                }
                i++;
                System.out.println();
            }
            
        
        }catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    }
    
    

    
    public static void leerDatos()
    {
        try {
            BufferedReader archivo = new BufferedReader(new FileReader(file));
            
             int i=0;
             String linea;
             String [] campos=new String[4];
              while ((linea = archivo.readLine()) != null) {
                //System.out.println();
                if(i>0)
                {
                   campos=linea.split(";");
                   Date fecha=new SimpleDateFormat("dd/mm/yyyy").parse(campos[1]);
                   materiales.add(new Material(campos[0],fecha, campos[2], campos[3]));
                //tratamiento para separar los ';'
                }
                
                i++;
             }
              
             System.out.println("el tamaño de objetos es "+materiales.size()); 
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException e){
        
        } catch(ParseException e){
            
        }
    }
    
    public void leerDatosNuevo() throws ParseException
    {
        Scanner entrada = new Scanner(System.in); 
        this.link = entrada.nextLine();
        this.fecha = new SimpleDateFormat("dd/mm/yyyy").parse(entrada.nextLine());
        this.titulo = entrada.nextLine();

    }
     
     
     
    
    public void agregar()
    {
        Scanner entrada = new Scanner(System.in);
       
        while(true)
        {
            int cantidadReuniones; 
            cantidadReuniones = entrada.nextInt();
            entrada.nextLine();
            
            if(cantidadReuniones == 0)
            {
                break;

            } 
            else 
            {
               leerDatos();
               materiales.add(new Material(this.link, this.fecha,this.titulo, this.idMaterial));  
            } 
        } 
    }

    public void mostrarDatos()
    {
        int size = materiales.size();
        for (int i = 0; i < size; i++)
        {
            System.out.println(materiales.get(i));
            
        }
    }

    
    public void modificarMaterial(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese ID del material que desea modificar.");
        String idBuscado = entrada.nextLine();
        int posicion = buscarMaterial(idBuscado);
        if(posicion != -1){
            System.out.println("Modificar : \n1. Link 2.Fecha 3.Titulo\n");
            int opcion = entrada.nextInt();
            switch (opcion){
                case 1:{
                    System.out.println("Ingrese el link nuevo.");
                    setLink(entrada.nextLine());
                }
                case 2:{
                    System.out.println("Ingrese la fecha nueva.");
                    setFecha(SimpleDateFormat("dd/mm/YYYY"));
                }
                case 3:{
                    System.out.println("Ingrese el titulo nuevo.");
                    setTitulo(entrada.nextLine());
                }
                
            }
            
                 
        }
        else{
            System.out.println("No se pudo encontrar el estudiante");
                 
        }
    }
    

    public int buscarMaterial(String idBuscada)
    {
        for(int i = 0; i < materiales.size(); i++)
        {
            if(materiales.get(i).idMaterial.equals(idBuscada)) 
                return i;
        }
        return -1;
    }

    public void eliminar(String idBuscada)
    {
        int posicion  = buscarMaterial(idBuscada);
        if(posicion == -1 )
            System.out.println("No se encontro el material");

        else
        {
            materiales.remove(posicion);
            System.out.println("Material eliminado con exito");
        }
    }

    private Date SimpleDateFormat(String ddmmYYYY) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}