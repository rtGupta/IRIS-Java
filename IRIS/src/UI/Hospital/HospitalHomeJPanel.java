/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Hospital;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.util.List;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author akshatajadhav
 */
public class HospitalHomeJPanel extends javax.swing.JPanel {

    JLayeredPane mainPane;
    JLayeredPane workPane;
    private EcoSystem system;
    private UserAccount userAccount;

    /**
     * Creates new form HosptialHomeJPanel
     */
    public HospitalHomeJPanel(JLayeredPane mainPane, JLayeredPane workPane, EcoSystem system, UserAccount account) {
        initComponents();
        this.mainPane = mainPane;
        this.workPane = workPane;
        this.system = system;
        this.userAccount = account;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 590));
        setMinimumSize(new java.awt.Dimension(990, 590));
        setPreferredSize(new java.awt.Dimension(990, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(990, 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(990, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("<html><h1>Hospital</h1><p style=\"font-size:130%;\">A hospital is a health care institution providing patient treatment with specialized health science staff and medical equipment.The acute-care hospital handle many kinds of disease and injury, and normally have an emergency department (sometimes known as \"accident & emergency\") or trauma center to deal with immediate and urgent threats to health.</p></html>");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 950, 200));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/hospital.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 930, 340));
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
