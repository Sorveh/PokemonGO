/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitxers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Thezo
 */
public class LineaLecturaFichero {
    File ruta_archivo; //objecte file necessari
    FileReader reader; //
    BufferedReader fichero;
    
    //els 2 constructors  (un sense el boolean i el altre amb el boolean
    public LineaLecturaFichero(String ruta_relativa) throws FileNotFoundException
    {
        ruta_archivo = new File(ruta_relativa);
        reader = new FileReader(ruta_archivo);
        fichero = new BufferedReader(reader);
    }
    
    /**
     * 
     * @return linbea llegida o null si es final fitxer
     */
    public String leerLinea() throws IOException
    {
        return fichero.readLine();
    }
    //tancar el fitxer
    public void cerrarFicheros() throws IOException
    {
        reader.close();
        fichero.close();
    }
} 