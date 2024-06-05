/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.LoginController;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SERVER
 */
public class DBSearch {
    
    ResultSet rs;
    Statement stmt;
    
    public ResultSet searchLogin(String index){
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT * FROM student WHERE studentindex='" + index + "' ");
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet seachCourses(String index){
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT * FROM course WHERE studentindex='"+ index + "' ");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet seachEnrolledCourses(String index, String courseid){
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT * FROM course WHERE studentindex='"+ index + "' AND courseid= '"+ courseid + "' ");
            if (!rs.isBeforeFirst()) { // Check if the ResultSet is empty
                rs = null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchGrades(String index){
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT * FROM grade WHERE studentindex='" + index +"'");
            /*if(rs.isBeforeFirst()){
                rs = null;
            }*/
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchGrade(String index, String cid){
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT * FROM grade WHERE studentindex='" + index +"' AND courseid= '"+ cid +"'");
            /*if(rs.isBeforeFirst()){
                rs = null;
            }*/
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public int getNoOfSubjects(String index) throws SQLException{
        int subjects = 0;
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) AS subjects FROM grade WHERE studentindex='"+ LoginController.index +"'");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(rs.next()){
            subjects = rs.getInt("subjects");
        } 
        return subjects;
    }
    
    public float getGPA(String index) throws SQLException{
        float gpa = 0;
        int count = 0;
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT gpa from grade WHERE studentindex= '"+ LoginController.index +"'");
            
            while(rs.next()){
            gpa += rs.getFloat("gpa");
            count++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(count > 0){
            return gpa/count;
        }
        else{
            return gpa;
        }
    }
    
    public float getCGPA(String index) throws SQLException{
        float cgpa = 0;
        
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT gpa from grade WHERE studentindex= '"+ LoginController.index +"'");
            
            while(rs.next()){
            cgpa += rs.getFloat("gpa");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return cgpa;
    }
    
    
    public int getRepeats(String index) throws SQLException{
        int repeats = 0;
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) AS repeats FROM grade WHERE studentindex= '"+ LoginController.index +"' AND gpa<2");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(rs.next()){
            repeats = rs.getInt("repeats");
        } 
        
        
        return repeats;
        
    }
    
    
    
    public int getCompleted(String index) throws SQLException{
        int completed = 0;
        try{
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) AS completed FROM grade WHERE studentindex= '"+ LoginController.index +"' AND gpa>=2");
        
            if(rs.next()){
            completed = rs.getInt("completed");
            }
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
         
        
        return completed;
        
    }
    
    public String getName(String index){
        String name = "";
        try{
        
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT name FROM student WHERE studentindex= '"+ index +"'");
            while(rs.next()){
            name = rs.getString("name");
        }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
        return name;
    }
    
    public boolean isCourseEnrolled(String index, String courseId){
        boolean isEnrolled = false;
        try {
            stmt = DBConnection.getConnStatement();
            rs = stmt.executeQuery("SELECT * FROM course WHERE studentindex= '"+ index +"' AND courseid= '"+ courseId +"'");
        
            if(rs.next()){
                isEnrolled = true;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isEnrolled;
    }
    
}
