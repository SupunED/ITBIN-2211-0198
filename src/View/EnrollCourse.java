/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.CourseController;
import Controller.LoginController;
import Model.DBSearch;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author SERVER
 */
public class EnrollCourse extends javax.swing.JFrame {

    /**
     * Creates new form EnrollCourse
     */
    public EnrollCourse() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        courseIdTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        courseNameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        creditsTF = new javax.swing.JTextField();
        enrollBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enroll in a Course");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 16, 125, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Course ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 67, -1, -1));
        jPanel1.add(courseIdTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 64, 150, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Course Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 105, -1, -1));
        jPanel1.add(courseNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 102, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Credits");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 148, 50, 22));
        jPanel1.add(creditsTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 149, 150, -1));

        enrollBtn.setText("Enroll");
        enrollBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollBtnActionPerformed(evt);
            }
        });
        jPanel1.add(enrollBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 217, -1, -1));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 217, -1, -1));

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 217, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/bg.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -5, 410, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void clearField(){
        courseNameTF.setText("");
        courseIdTF.setText("");
        creditsTF.setText("");
    }
    
    
    private void enrollBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollBtnActionPerformed
        // TODO add your handling code here:
        
        if(courseIdTF.getText().equals("") || courseNameTF.getText().equals("") || creditsTF.getText().equals("")){
            JOptionPane.showMessageDialog(null, "All fields must be filled!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(new DBSearch().isCourseEnrolled(LoginController.index, courseIdTF.getText())){
            JOptionPane.showMessageDialog(null, "Course Already Enrolled!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            
            int credits = Integer.parseInt(creditsTF.getText());
        
            CourseController.form(LoginController.index, courseIdTF.getText(), courseNameTF.getText(),credits);
            clearField();
 
        }
    }//GEN-LAST:event_enrollBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        for (Frame frame : Frame.getFrames()) {
            if (frame.isActive()) {
                frame.dispose();
                break;
            }
        }
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnrollCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnrollCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnrollCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnrollCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnrollCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField courseIdTF;
    private javax.swing.JTextField courseNameTF;
    private javax.swing.JTextField creditsTF;
    private javax.swing.JButton enrollBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
