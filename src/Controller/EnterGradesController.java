/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.AddGrade;
import javax.swing.JOptionPane;

/**
 *
 * @author SERVER
 */
public class EnterGradesController {
    public void enterGrades(String index, String id, String grade){
        String gpa = null;
        switch(grade){
            case "A+": gpa = "4.0";
            break;
            case "A": gpa = "4.0";
            break;
            case "A-": gpa = "3.7";
            break;
            case "B+": gpa = "3.3";
            break;
            case "B": gpa = "3.0";
            break;
            case "B-": gpa = "2.7";
            break;
            case "C+": gpa = "2.3";
            break;
            case "C": gpa = "2.0";
            break;
            case "C-": gpa = "1.7";
            break;
            case "D": gpa = "1.0";
            break;
        }
        
        try {
            new AddGrade().addGrade(index, id, grade, gpa);
            JOptionPane.showMessageDialog(null, "Grades have been entered successfully!", "Successfull", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Not an enrolled course!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
