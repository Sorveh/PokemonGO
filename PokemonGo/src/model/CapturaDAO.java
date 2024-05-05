/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.*;

/**
 *
 * @author Thezo
 */
public class CapturaDAO {
    
    Connection conn_principal;

    public CapturaDAO(Connection conn_principal) throws SQLException {
        this.conn_principal = DBConnect.getConnection(); 
    }
    
    public boolean darCaptura(int id_coach, int num_pokemon, int CP) throws SQLException {
    
        int rows = 0;
        if (conn_principal!=null) {
            
            String query = "INSERT INTO CAPTURA "
                    + "(id, num, cp) "
                    + "VALUES "
                    + "(?,?,?)";
            
            PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
            preparedQuery.setInt(1, id_coach);
            preparedQuery.setInt(2, num_pokemon);
            preparedQuery.setInt(3, CP);
            
            rows = preparedQuery.executeUpdate();
        }
        
        return rows > 0;
    }
    
}
