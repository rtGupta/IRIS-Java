/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Firefighter;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.Utilities.Profile;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import UI.Paramedics.*;
import UI.Dispatcher.*;
import Util.MapsUtil;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author akshatajadhav
 */
public class FireFighterHomeJPanel extends javax.swing.JPanel {

    JLayeredPane mainPane;
    JLayeredPane workPane;
    private EcoSystem system;
    private UserAccount fireUserAccount;
    WorkRequest fireWorkRequest;

    /**
     * Creates new form AEmergencyJPanel
     */
    public FireFighterHomeJPanel(JLayeredPane mainPane, JLayeredPane workPane, EcoSystem system, UserAccount account) {
        initComponents();
        this.mainPane = mainPane;
        this.workPane = workPane;
        this.system = system;
        this.fireUserAccount = account;
        
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 590));
        setMinimumSize(new java.awt.Dimension(990, 590));
        setPreferredSize(new java.awt.Dimension(990, 590));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("<html><h1>Fire Fighter</h1><p style=\"font-size:130%;\">A firefighter is a rescuer extensively trained in firefighting. Firefighters frequently provide some degree of emergency medical care. The dispatch of firefighters to medical emergencies is particularly common in fire departments that run the EMS. Firefighters are often jointly trained as emergency medical technicians in order to deliver basic life support, and more rarely as paramedics to deliver advanced life support.</p></html>");
        jLabel2.setToolTipText("");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 950, 200));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/firetruck_320.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 490, 340));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}