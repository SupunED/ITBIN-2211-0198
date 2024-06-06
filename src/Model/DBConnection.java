/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author SERVER
 */
public class DBConnection {
    
    static Connection conn;
    static Statement stat = null;
    
    public static Statement getConnStatement(){
        
        try{
            String url = "jdbc:mysql://localhost:3306/systemdb";
            conn = DriverManager.getConnection(url, "root", "");
            stat = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return stat;
    }
    
    
    public static void closeConnection() throws SQLException{
        conn.close();
    }
}
