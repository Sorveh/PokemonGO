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
import java.util.ArrayList;

/**
 *
 * @author mabardaji logo.pok
 */
public class Caratula {
    /*atributs necessaris per llegir un fitxer*/
    File ruta_fichero;
    
    /*constructor necessari*/
    public Caratula(String ruta_relativa) throws FileNotFoundException {
        ruta_fichero = new File(ruta_relativa);
    }

    /*recuperarDatos*/
    public ArrayList<String> recuperarDatos() throws FileNotFoundException, IOException {
    
        ArrayList<String> logoPokemon = new ArrayList<>();
        
        //abrir fichero
        LineaLecturaFichero logo = new LineaLecturaFichero(this.getRuta_fichero());
        
        //recuperar linea a linea y guardarlo en un arraylist<String>
        String linea;
        do {
            linea = logo.leerLinea();
            if (linea != null) {
                logoPokemon.add(linea + "\n");
            }
        } while (linea != null);
        
        //retornar el arrayList<String>
        //no sout!!!
        return logoPokemon;
    }

    public String getRuta_fichero() {
        return ruta_fichero.getPath();
    }
}
