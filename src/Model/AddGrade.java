/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.LoginController;
import java.sql.Statement;

/**
 *
 * @author SERVER
 */
public class AddGrade {
    String status = "Complete";
    public void addGrade(String index, String id, String grade, String gpa){
        Statement st;
        
        if(gpa.equals("1.7") || gpa.equals("1.0")){
            status = "Failed";
        }
        
        try{
            st = DBConnection.getConnStatement();
            st.executeUpdate("INSERT INTO grade VALUES ('"+ index +"', '" + id + "', '"+ grade +"', '"+ gpa +"')");
            st.executeUpdate("UPDATE course SET status='"+ status +"' WHERE studentindex='"+LoginController.index+"' AND courseid='"+ id +"'");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
