/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mabardaji
 */
public class PokemonDAO {
    Connection conn_principal;
    
    public PokemonDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); //estara oberta fins al final
    }
    
    public Pokemon getPokemonRandom() throws SQLException {
        Pokemon rand = null;
        
        if (conn_principal!=null) {
            
            List<Pokemon> pokemons = getTodosPokemons();
            
            int min = 1, max = pokemons.size(),range = max-min;
           
            int random = (int) (Math.random()* (range + 1) + min);
            
            rand = pokemons.get(random);
            System.out.println("Pokemon random! " + rand);
        }
        
        return rand;
    }
    
    public List<Pokemon> getTodosPokemons() throws SQLException {
        List<Pokemon> pokemons = null;
        
        if (conn_principal!=null) {
            pokemons = new ArrayList<>();
            
            Statement stmt = conn_principal.createStatement();
            String query = "SELECT num, name, type FROM POKEDEX";
            
            ResultSet cursor = stmt.executeQuery(query);
            
            if (cursor.next()) {
                Pokemon afegir = new Pokemon(cursor.getInt("num"), cursor.getString("name"), cursor.getString("type"));
                pokemons.add(afegir);
            }
        }
        
        return pokemons;
    }
    
}
