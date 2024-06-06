/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Statement;

/**
 *
 * @author SERVER
 */
public class RegisterStudent {
    
    Statement stmt;
    
    public void registerStudent(String index, String name, String password){
        
        try{
            stmt = DBConnection.getConnStatement();
            stmt.executeUpdate("INSERT INTO student VALUES ('" + index + "', '" + name + "', '" + password + "')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
    }
        
    
}
