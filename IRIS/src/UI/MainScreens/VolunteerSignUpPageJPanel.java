/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.MainScreens;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Util.MapsUtil;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author akshatajadhav
 */
public class VolunteerSignUpPageJPanel extends javax.swing.JPanel {

    private EcoSystem system;
//    private Organization organization;
//    private Enterprise enterprise;
    private UserAccount userAccount;
    
    boolean menuCollapse = false;
    JLayeredPane mainPane;
    boolean menuButton = false;

    /**
     * Creates new form DispatcherJPanel
     */
    public VolunteerSignUpPageJPanel(JLayeredPane mainPane, EcoSystem system) {
        initComponents();
        this.mainPane = mainPane;
        this.system = system;
        
        radbtnMale.setActionCommand("Male");
        radbtnFemale.setActionCommand("Female");
        radbtnNotToSay.setActionCommand("PreferNotToSay");
        gender.add(radbtnMale);
        gender.add(radbtnFemale);
        gender.add(radbtnNotToSay);
        
        Physician.setActionCommand("Physician");
        Transport.setActionCommand("Transport");
        volunteerType.add(Physician);
        volunteerType.add(Transport);

    }

    public void displayPanel(JLayeredPane lpane, JPanel panel) {
        lpane.removeAll();
        lpane.add(panel);
        lpane.repaint();
        lpane.revalidate();
        JFrame parentFrame = (JFrame) SwingUtilities.getRoot(mainPane);
        parentFrame.pack();
        parentFrame.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        volunteerType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        menuTab = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        Transport = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        Physician = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        loginButton = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        loginButton2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        radbtnMale = new javax.swing.JRadioButton();
        radbtnFemale = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        radbtnNotToSay = new javax.swing.JRadioButton();
        jTextField5 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        closeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 675));
        setMinimumSize(new java.awt.Dimension(1200, 675));
        setPreferredSize(new java.awt.Dimension(1200, 675));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(38, 38, 38));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon_64px.gif"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("IRIS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 90));

        menuTab.setBackground(new java.awt.Color(255, 255, 255));
        menuTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuTab.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 413, 10));

        jLabel12.setText("<html><h2>Volunteer:</h2></html>");
        menuTab.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 413, 44));

        Transport.setText("Transport");
        menuTab.add(Transport, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, -1, 45));

        jLabel10.setText("<html><h2>Username:</h2></html>");
        menuTab.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 413, 44));

        Physician.setText("Physician");
        menuTab.add(Physician, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, -1, 45));

        jTextField1.setText("Enter Username");
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        menuTab.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 413, 45));
        menuTab.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 413, 10));
        menuTab.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 413, 10));

        jLabel13.setText("<html><h2>Last Name:</h2></html>");
        menuTab.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 413, 44));
        menuTab.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 413, 10));

        jLabel11.setText("<html><h2>Password:</h2></html>");
        menuTab.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 413, 44));

        jPasswordField1.setText("jPasswordField");
        jPasswordField1.setBorder(null);
        jPasswordField1.setOpaque(false);
        menuTab.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 413, 50));

        kGradientPanel2.setkEndColor(new java.awt.Color(22, 116, 188));
        kGradientPanel2.setkStartColor(new java.awt.Color(38, 38, 38));

        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginButton.setText("Cancel");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        menuTab.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, -1));

        jLabel14.setText("<html><h2>Mobile Number:</h2></html>");
        menuTab.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 413, 44));
        menuTab.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 413, 10));

        jTextField2.setText("Enter First Name");
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        menuTab.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 413, 45));

        jTextField3.setText("Enter Mobile Number");
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        menuTab.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 413, 45));

        kGradientPanel4.setkEndColor(new java.awt.Color(22, 116, 188));
        kGradientPanel4.setkStartColor(new java.awt.Color(38, 38, 38));

        loginButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton2.setForeground(new java.awt.Color(255, 255, 255));
        loginButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginButton2.setText("Sign Up");
        loginButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        menuTab.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, -1, -1));

        jLabel15.setText("<html><h2>Last Name:</h2></html>");
        menuTab.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 413, 44));

        jTextField4.setText("Enter Last Name");
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        menuTab.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 413, 45));
        menuTab.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 413, 10));

        radbtnMale.setText("Male");
        menuTab.add(radbtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, 45));

        radbtnFemale.setText("Female");
        menuTab.add(radbtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, -1, 45));

        jLabel16.setText("<html><h2>Gender:</h2></html>");
        menuTab.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 413, 44));
        menuTab.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 413, 10));

        radbtnNotToSay.setText("Prefer not to say");
        menuTab.add(radbtnNotToSay, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, 45));

        jTextField5.setText("Enter Address");
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        menuTab.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 413, 45));
        menuTab.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 413, 10));

        jLabel17.setText("<html><h2>Address:</h2></html>");
        menuTab.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 413, 44));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        menuTab.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 2));

        add(menuTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 590));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Volunteer SignUp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 790, 90));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/close_30px.png"))); // NOI18N
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
        });
        add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, -1, -1));

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/minimize_24px.png"))); // NOI18N
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseExited(evt);
            }
        });
        add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        JFrame parentFrame = (JFrame) SwingUtilities.getRoot(this);
        parentFrame.dispose();
    }//GEN-LAST:event_closeButtonMouseClicked

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/close_rev_30px.png")));
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/close_30px.png")));
    }//GEN-LAST:event_closeButtonMouseExited

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        JFrame parentFrame = (JFrame) SwingUtilities.getRoot(this);
        parentFrame.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        //        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/minimize_rev_24px.png")));
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/minimize_24px.png")));
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        //DispatcherJPanel djp = new DispatcherJPanel(mainPane);
        JPanel djp = new LoginJPanel(mainPane, system);
        displayPanel(mainPane, djp);
    }//GEN-LAST:event_loginButtonMouseClicked

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        kGradientPanel2.setkEndColor(new Color(38,38,38));
        kGradientPanel2.setkStartColor(new Color(22,116,188));
        mainPane.repaint();
        mainPane.revalidate();
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        kGradientPanel2.setkStartColor(new Color(38,38,38));
        kGradientPanel2.setkEndColor(new Color(22,116,188));
        mainPane.repaint();
        mainPane.revalidate();
    }//GEN-LAST:event_loginButtonMouseExited

    private void loginButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButton2MouseClicked

    private void loginButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButton2MouseEntered

    private void loginButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButton2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButton2MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Physician;
    private javax.swing.JRadioButton Transport;
    private javax.swing.JLabel closeButton;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel loginButton1;
    private javax.swing.JLabel loginButton2;
    private javax.swing.JPanel menuTab;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JRadioButton radbtnFemale;
    private javax.swing.JRadioButton radbtnMale;
    private javax.swing.JRadioButton radbtnNotToSay;
    private javax.swing.ButtonGroup volunteerType;
    // End of variables declaration//GEN-END:variables
   
}