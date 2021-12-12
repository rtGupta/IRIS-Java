/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Dispatcher;

import Util.MapsUtil;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author akshatajadhav
 */
public class AEmergencyJPanel extends javax.swing.JPanel {

    JLayeredPane mainPane;
    JLayeredPane workPane;
    /**
     * Creates new form AEmergencyJPanel
     */
    public AEmergencyJPanel(JLayeredPane mainPane,JLayeredPane workPane) {
        initComponents();
        this.mainPane = mainPane;
        this.workPane = workPane;
        JPanel map = MapsUtil.defaultMap();
        displayPanel(maps, map);
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
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        maps = new javax.swing.JLayeredPane();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 590));
        setMinimumSize(new java.awt.Dimension(790, 550));
        setPreferredSize(new java.awt.Dimension(990, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(990, 2));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(990, 2));

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

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Police:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 403, 100, 22));

        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 402, 202, -1));

        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 447, 202, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Paramedics:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 448, 110, 22));

        add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 492, 202, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fire Fighters:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 493, 110, 22));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Dispatch");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 537, 113, -1));

        maps.setLayout(new java.awt.CardLayout());
        add(maps, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 8, 990, 353));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Reset");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 367, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLayeredPane maps;
    // End of variables declaration//GEN-END:variables
}
