/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;

/**
 *
 * @author SERVER
 */
public class CourseController {
    
    public static void form(String index, String id, String coursename, int credits){
        
        try{
            new Model.AddCourse().form(index, id, coursename, credits);
            JOptionPane.showMessageDialog(null, "Successfully enrolled in a new course!", "Successfull", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something went wrong!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
