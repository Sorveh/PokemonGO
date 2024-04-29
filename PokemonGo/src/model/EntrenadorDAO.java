/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mabardaji
 */
public class EntrenadorDAO {
    //atribut per la conexió
    Connection conn_principal;

    public EntrenadorDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); //estara oberta fins al final
    }
    
    
    public int altaEntrenador(Entrenador trainer) throws SQLException
    {

        int rows=0;
        if (conn_principal!=null)
        {
           String query = "INSERT INTO ENTRENADORS  "
                        + "(name, password) "
                        + " VALUES"
                        + " (?,?)";
           
            System.out.println(query);
            
            PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
            preparedQuery.setString(1, trainer.getName());
            preparedQuery.setString(2,trainer.getPassword());
            rows = preparedQuery.executeUpdate();
            
        }
        
        return rows;
    }
    
    
    public boolean existeEntrenador(String name) throws SQLException
    {
        int rows=0;
        if (conn_principal!=null)
        {
            //realitzo insert
           //llamar al metodo existeEntrenador y si da cierto no hago el insert
            
           String query = "SELECT * FROM ENTRENADORS "
                        + "WHERE  name = ?";
            //verificacio
            System.out.println(query); //s'ha de treure quant funcioni 
            
            PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
            preparedQuery.setString(1, name);
            rows = preparedQuery.executeUpdate();
            
        }
        
        return rows > 1;
    }
    
    
    public Entrenador borrarEntrenador(Entrenador trainer) throws SQLException
    {
        int rows=0;
        if (conn_principal!=null)
        {
           String query = "DELETE FROM ENTRENADORS "
                        + "WHERE name = ? ";
            System.out.println(query); //s'ha de treure quant funcioni 
            
            PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
            preparedQuery.setString(1, trainer.getName());
            rows = preparedQuery.executeUpdate();   
        }
        
        if (rows > 0) {
            return trainer;
        }
        else 
        {
            return null;
        }
    }    
    
    public List<Entrenador> todosEntrenadores() throws SQLException
    {
        List<Entrenador> entrenadores = new ArrayList<>();
        
        if (conn_principal!=null)
        {
            
            Statement stmt = conn_principal.createStatement();
                
                String query = "SELECT * from entrenadors";
                
                ResultSet res = stmt.executeQuery(query);
                
                //fetch
                while(res.next())
                {
                    Entrenador afegir = new Entrenador(res.getString("name"), res.getString("password"));
                    entrenadores.add(afegir);
                }
                res.close();
                stmt.close();  
        }
        
        return entrenadores;
    }    
    
    
    public Entrenador devolverEntrenador(String name) throws SQLException
    { 
        Entrenador search = null;
        if (conn_principal!=null)
        {
            
            Statement stmt = conn_principal.createStatement();
                
                String query = "SELECT * FROM ENTRENADORS "
                         + "WHERE name = ? ";
                
                PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
                preparedQuery.setString(1, name);
                
                ResultSet res = stmt.executeQuery(query);
                
                //fetch
                while(res.next())
                {
                    search = new Entrenador(res.getString("name"), res.getString("password"));
                }
                res.close();
                stmt.close();  

        }
        
        return search;
    }
    
}
