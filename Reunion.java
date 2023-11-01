package com.mycompany.main;

/**
 *
 * @author bverg
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Reunion 
{
    private String mensaje;
    private String linkReunion;
    private Date fechaReunion;
    private String estado;
    private String idReunion;
    
     
    //Aquí va la ruta del archivo csv con los datos a leer
    public static String file = "";
    private static ArrayList <Reunion> historial = new ArrayList<Reunion>();
    
    public Reunion(String mensaje, String linkReunion, Date fechaReunion, String estado, String idReunion) 
    {
        this.mensaje = mensaje;
        this.linkReunion = linkReunion;
        this.fechaReunion = fechaReunion;
        this.estado = estado;
        this.idReunion = idReunion;
    }
    
    public Reunion()
    {
        return;
    }    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getLinkReunion() {
        return linkReunion;
    }

    public void setLinkReunion(String linkReunion) {
        this.linkReunion = linkReunion;
    }

    public Date getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(Date fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public String getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(String idReunion) {
        this.idReunion = idReunion;
    }
    
    public void Leer() throws CsvValidationException
    {
        File file = new File(this.file);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);

            String[] nextRecord;

            // we are going to read data line by line
            int i=0;
            while ((nextRecord = reader.readNext()) != null){

                Date fecha=new SimpleDateFormat("dd/mm/yyyy").parse(nextRecord[2]);

                if(i>0)historial.add(new Reunion(nextRecord[0],nextRecord[1],fecha,nextRecord[3],nextRecord[4]));

                for (String cell : nextRecord)
                {
                    System.out.print(cell + "\t");
                }
                i++;
                System.out.println();
            }
        }
        catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    }
    
    public void leerDatosReunion() throws ParseException
    {
        
        Scanner entrada = new Scanner(System.in); 
        this.estado = entrada.nextLine();
        this.linkReunion = entrada.nextLine();
        this.fechaReunion = new SimpleDateFormat("dd/mm/yyyy").parse(entrada.nextLine());
        this.mensaje = entrada.nextLine();
        this.idReunion = entrada.nextLine();

    }
    
    public void AgregarDatosReunion() throws ParseException
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
               leerDatosReunion();
               historial.add(new Reunion(this.mensaje, this.linkReunion,this.fechaReunion ,this.estado, this.idReunion));  
            } 
        }
    }

    public void mostrarDatosReunion()
    {
        System.out.println("Mensaje" + this.mensaje);
        System.out.println("Link Reunion: " + this.linkReunion);
        System.out.println("Fecha Reunión: " + this.fechaReunion);
        System.out.println("Estado Reunion:" + this.estado);
        System.out.println("Estado Reunion:" + this.idReunion);
    }
    
    
    public int buscar(String idBuscada)
    {
        for(int i = 0; i < historial.size(); i++)
        {    
            if(historial.get(i).idReunion.equals(idBuscada)) 
                return i;   
        }
        return -1;
    }
    
    public void eliminar(String idBuscada)
    {
        int posicion  = buscar(idBuscada);
        if(posicion == -1)
            System.out.println("No se encontro la reunion");
        
        else
        {    
            historial.remove(posicion);
            System.out.println("Reunion eliminada con exito");
        }
    }
    
    
    public void modificarDatosReunion()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id de la reunion que quiere modificar");
        String idBuscada = entrada.nextLine();
        int posicion = buscar(idBuscada);
        if(posicion != -1)
        {
            System.out.println("Modificar Reunion: \n1. Mensaje 2. Link Reunion 3. Fecha Reunión 4. Estado 5. ID Reunion\n");
            int opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion)
            {
                case 1:{
                    System.out.println("Ingrese el mensaje");
                    setMensaje(entrada.nextLine());
                }
                case 2:{
                    System.out.println("Ingrese el link de la reunión");
                    setLinkReunion(entrada.nextLine());
                }
                case 3:
                {
                    System.out.println("Ingrese la fecha de Reunión (dd/MM/yyyy)");
                    setFechaReunion(SimpleDateFormat("dd/mm/YYYY"));
                }
                case 4:
                {
                    System.out.println("Ingrese el estado");
                    setEstado(entrada.nextLine()); 
                }
                case 5:
                {
                    System.out.println("Ingrese el Id de la Reunion");
                    setIdReunion(entrada.nextLine());
                }                
            }    
        }

    }

    private Date SimpleDateFormat(String ddmmYYYY) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}