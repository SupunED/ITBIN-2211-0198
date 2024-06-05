/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Login;
import View.Register;
import javax.swing.JOptionPane;

/**
 *
 * @author SERVER
 */
public class RegisterController {
    
    public void register(String index, String name, String pw){
        
        if (index == null || index.trim().isEmpty() || 
            name == null || name.trim().isEmpty() || 
            pw == null || pw.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        new Model.RegisterStudent().registerStudent(index, name, pw);
        JOptionPane.showMessageDialog(null, "New user has been registered!", "Successfull", JOptionPane.INFORMATION_MESSAGE);
        Register.getFrames()[1].dispose();
        new Login().setVisible(true);
    }
    
}
