/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.ResultSet;
import Model.DBSearch;
import Model.DBConnection;
import View.Login;
import View.Home;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author SERVER
 */

public class LoginController {
    public static String index = null;
    public static void login(String name, String pw){
        try{
            String userName = null;
            String password = null;
            
            ResultSet rs = new DBSearch().searchLogin(name);
            
            while(rs.next()){
                userName = rs.getString("studentindex").toLowerCase();
                password = rs.getString("password");
            }
            
            if(userName != null && password != null){
                if(userName.equals(name) && password.equals(pw)){
                    System.out.println("Login successful");
                    index = userName; 
                    for (Frame frame : Frame.getFrames()) {
                        if (frame.isActive()) {
                            frame.dispose();
                            break;
                        }
                    }
                    new Home().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please check the credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please check the credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            DBConnection.closeConnection();
        }
        catch(SQLException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
