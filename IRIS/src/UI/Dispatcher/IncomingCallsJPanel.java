/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Dispatcher;

import Business.Caller.Caller;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import Util.MapsUtil;
import java.awt.Component;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author akshatajadhav
 */
public class IncomingCallsJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private UserAccount dispatcherUserAccount;

    JLayeredPane mainPane;
    JLayeredPane workPane;
    boolean fromReset = false;

    /**
     * Creates new form IncomingCallsJPanel
     */
    public IncomingCallsJPanel(JLayeredPane mainPane, JLayeredPane workPane, EcoSystem system, UserAccount account) {
        initComponents();
        this.mainPane = mainPane;
        this.workPane = workPane;
        this.system = system;
        this.dispatcherUserAccount = account;

        populateIncidentTable();

        JPanel map = MapsUtil.defaultMap();
        map.setBounds(callerLocation.getBounds());
        callerLocation.removeAll();
        callerLocation.add(map);
        this.updateUI();
        emergencyCategoryA.setActionCommand("A");
        emergencyCategoryC.setActionCommand("C");
        emergencyCategoryE.setActionCommand("E");
        emergencyCategory.add(emergencyCategoryA);
        emergencyCategory.add(emergencyCategoryC);
        emergencyCategory.add(emergencyCategoryE);
    }

    public void displayPanel(JLayeredPane lpane, JPanel panel) {
        lpane.removeAll();
        lpane.add(panel);
        mainPane.repaint();
        mainPane.revalidate();
        JFrame parentFrame = (JFrame) SwingUtilities.getRoot(mainPane);
        parentFrame.pack();
        parentFrame.setLocationRelativeTo(null);
    }

    public void populateIncidentTable() {
        DefaultTableModel dispatcherIncidentTableModel = (DefaultTableModel) tbldispatcherWQ.getModel();
        dispatcherIncidentTableModel.setRowCount(0);

        WorkQueue workQueue = dispatcherUserAccount.getWorkQueue();
        if (workQueue != null) {
            List<WorkRequest> dispatcherWorkRequestList = workQueue.getWorkRequestList();
            if (CollectionUtils.isNotEmpty(dispatcherWorkRequestList)) {
                for (WorkRequest wr : dispatcherWorkRequestList) {
                    Object[] row = new Object[4];
                    row[0] = wr;
                    row[1] = wr.getCaller().getLocation();
                    row[2] = wr.getEmergencyLevel();
                    row[3] = wr.getStatus();
                    dispatcherIncidentTableModel.addRow(row);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        emergencyCategory = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldispatcherWQ = new javax.swing.JTable();
        nameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        callerId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextArea();
        emergencyCategoryA = new javax.swing.JRadioButton();
        emergencyCategoryC = new javax.swing.JRadioButton();
        emergencyCategoryE = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        resetMap = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        callerLocation = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 590));
        setMinimumSize(new java.awt.Dimension(990, 590));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(990, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Incoming Calls", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N

        tbldispatcherWQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request No.", "Location", "Emergency Level", "Request Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbldispatcherWQ.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tbldispatcherWQ.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbldispatcherWQ.setShowGrid(true);
        tbldispatcherWQ.setShowHorizontalLines(false);
        tbldispatcherWQ.getTableHeader().setResizingAllowed(false);
        tbldispatcherWQ.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbldispatcherWQ);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 970, 200));
        add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 242, 40));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 113, 40));
        add(callerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 242, 40));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Phone Number:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 113, 40));
        add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 242, 40));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Address:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 113, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Message:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 113, 90));

        messageText.setColumns(20);
        messageText.setRows(5);
        jScrollPane3.setViewportView(messageText);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 242, 100));

        emergencyCategoryA.setText("A");
        emergencyCategoryA.setToolTipText("Emergency");
        add(emergencyCategoryA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, 30));

        emergencyCategoryC.setText("C");
        emergencyCategoryC.setToolTipText("Doctor");
        add(emergencyCategoryC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, -1, 30));

        emergencyCategoryE.setText("E");
        emergencyCategoryE.setToolTipText("Volunteer");
        add(emergencyCategoryE, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, -1, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Emergency Category:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Caller Location");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 340, 30));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setText("Next>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 134, 30));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setText("Locate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 70, 40));

        resetMap.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        resetMap.setText("Reset");
        resetMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMapActionPerformed(evt);
            }
        });
        add(resetMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 540, 340, 30));

        jPanel2.setMinimumSize(new java.awt.Dimension(990, 2));
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

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 2));

        callerLocation.setLayout(new java.awt.BorderLayout());
        add(callerLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 340, 270));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String address = Address.getText();
        double[] location = MapsUtil.getGeoPointFromAddress(address);
        if (location[0] == 0 || location[1] == 0) {
            JPanel map = MapsUtil.defaultMap();
            map.setBounds(callerLocation.getBounds());
            callerLocation.add(map);
            this.updateUI();
            if (fromReset) {
                fromReset = false;
                return;
            }
            JOptionPane.showMessageDialog(this, "Wrong Address");
            return;
        }
        JPanel map = MapsUtil.mapWayPointWithLocationName(nameText.getText(), location[0], location[1]);
        map.setBounds(callerLocation.getBounds());
        callerLocation.add(map);
        this.updateUI();
        //displayPanel(callerLocation, map);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void resetMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMapActionPerformed
        fromReset = true;
        jButton2.doClick();
    }//GEN-LAST:event_resetMapActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // data validations for text fields

        // register caller's name, contact and location in caller object.
        String firstName = nameText.getText();
        String lastName = " ";
        long contact = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        String location = Address.getText();
        String message = messageText.getText();
        String emergencyLevel = emergencyCategory.getSelection().getActionCommand();

        Caller caller = new Caller(firstName, lastName, contact, location);
        // pass caller object, message, emergencyLevel to EmergencyPanels - A, C, E.
        JPanel panel = null;
        if (emergencyCategory.getSelection() == null) {
            return;
        }
        if (emergencyCategory.getSelection().getActionCommand().equals("A")) {
            panel = new AEmergencyJPanel(mainPane, workPane, system, dispatcherUserAccount, caller, message, emergencyLevel);
        } else if (emergencyCategory.getSelection().getActionCommand().equals("C")) {
            panel = new CEmergencyJPanel(mainPane, workPane, system, dispatcherUserAccount, caller, message, emergencyLevel);
        } else if (emergencyCategory.getSelection().getActionCommand().equals("E")) {
            panel = new EEmergencyJPanel(mainPane, workPane);
        } else {
            return;
        }
        displayPanel(workPane, panel);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JTextField callerId;
    private javax.swing.JPanel callerLocation;
    private javax.swing.ButtonGroup emergencyCategory;
    private javax.swing.JRadioButton emergencyCategoryA;
    private javax.swing.JRadioButton emergencyCategoryC;
    private javax.swing.JRadioButton emergencyCategoryE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea messageText;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton resetMap;
    private javax.swing.JTable tbldispatcherWQ;
    // End of variables declaration//GEN-END:variables

}
