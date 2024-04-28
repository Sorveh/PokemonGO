/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongo;

import fitxers.Caratula;
import fitxers.LineaLecturaFichero;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mabardaji
 */
public class PokemonGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PokemonGo app = new PokemonGo();
        app.run();
    }

    /* la ejecucion programa*/
    private void run() {
        
        mostarLogo();
        System.out.println("");
        
        mostrarMenu();  
    }

    private void mostarLogo() {
        try {
            Caratula logo = new Caratula("ficheros/caratula.txt");
            
            ArrayList<String> logoPokemon = logo.recuperarDatos();
            
            System.out.println(logoPokemon);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    private int cargarMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("0.- Salir");
        System.out.println("1.- Dar de alta entrenador.");
        System.out.println("2.- Dar de baja entrenador.");
        System.out.println("3.- Consultar entrenador.");
        System.out.println("4.- Cazar Pokemon.");
        System.out.println("5.- Listar Pokemons cazados.");
        System.out.println("6.- Listar tipos de pokemons existentes en juego.");

        return sc.nextInt();
    }
    
    
    private void mostrarMenu() {
        boolean exit = false;
        System.out.println("Cargando menu...");
            do{
                int opcion = cargarMenu();
                switch(opcion)
                {
                    case 1:
                        System.out.println("Has dado en la opcion 1");
                        break;
                    case 2:
                        System.out.println("Has dado en la opcion 2");
                        break;                     
                    case 3:
                        System.out.println("Has dado en la opcion 3");
                        break;  
                    case 4:
                        System.out.println("Has dado en la opcion 4");
                        break;
                    case 5:
                        System.out.println("Has dado en la opcion 5");
                        break;                     
                    case 6:
                        System.out.println("Has dado en la opcion 6");
                        break;   
                    case 0:
                        System.out.println("Has dado en la opcion 0");
                        exit = true;
                        break;
                }
            } while(!exit);
    }
    
}
