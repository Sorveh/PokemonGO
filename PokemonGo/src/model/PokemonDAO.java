/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mabardaji
 */
public class PokemonDAO {
//atribut per la conexió 
 //atribut per la conexió
    Connection conn_principal;

    public PokemonDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); //estara oberta fins al final
    }    
    
    
    public List<Pokemon> getAllPokemons() throws SQLException
    {
        List<Pokemon> all_pokemon = null;
        if (conn_principal!=null)
        {
            Statement stmt = conn_principal.createStatement();
            String query = "Select num,name,type"
                    + " from Pokedex";
            
            ResultSet cursor = stmt.executeQuery(query);
            all_pokemon = new ArrayList<>();
            while(cursor.next())
            {
                int num = cursor.getInt(1);
                String nom = cursor.getString("name");
                String contrasenya = cursor.getString("type");
                

                all_pokemon.add(new Pokemon(num, nom, contrasenya));
            }
             cursor.close();
        }
        return all_pokemon;        
    }
    
    public Pokemon getPokemonRandom() throws SQLException
    {
        List<Pokemon> all_pokemon = this.getAllPokemons();
        int max = all_pokemon.size();
        
        Random rd = new Random();
        int valor = rd.nextInt(max);
        
        return all_pokemon.get(valor);
        
    }
    
    
}
