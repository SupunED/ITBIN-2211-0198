/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import View.EnrollCourse;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author SERVER
 */
public class AddCourse {
    
    Statement st;
    public void form(String index, String courseid, String name, int credits){
        try{
            String status = "Ongoing";
            st = DBConnection.getConnStatement();
            st.executeUpdate("INSERT INTO course VALUES ('" + index + "','" + courseid + "', '" + name + "', '" + credits + "', '"+ status +"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
