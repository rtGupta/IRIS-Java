/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Paramedics;

import Business.Caller.Caller;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.Utilities.Profile;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
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
public class EmergencyJPanel extends javax.swing.JPanel {

    JLayeredPane mainPane;
    JLayeredPane workPane;
    private EcoSystem system;
    private UserAccount paramedicUserAccount;
    WorkRequest paramedicWorkRequest;

    /**
     * Creates new form AEmergencyJPanel
     */
    public EmergencyJPanel(JLayeredPane mainPane, JLayeredPane workPane, EcoSystem system, UserAccount account) {
        initComponents();
        this.mainPane = mainPane;
        this.workPane = workPane;
        this.system = system;
        this.paramedicUserAccount = account;
        btnHospitalTransfer.setEnabled(false);

        JPanel map = MapsUtil.defaultMap();
        map.setBounds(maps.getBounds());
        maps.removeAll();
        maps.add(map);
        this.updateUI();

        populateWorkQueueTable();
        tblParamedicsWQ.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int selectedRowIndex = tblParamedicsWQ.getSelectedRow();
                if (selectedRowIndex < 0) {
                    txtCallerName.setText("");
                    txtContact.setText("");
                    txtLocation.setText("");
                    txtMessage.setText("");

                    return;
                }

                paramedicWorkRequest = (WorkRequest) tblParamedicsWQ.getValueAt(selectedRowIndex, 0);
                if (paramedicWorkRequest != null) {
                    Profile callerInfo = paramedicWorkRequest.getCaller().getCallerDetails();
                    txtCallerName.setText(callerInfo.getFirstName() + " " + callerInfo.getLastName());
                    txtContact.setText(String.valueOf(callerInfo.getPhone()));
                    txtLocation.setText(paramedicWorkRequest.getCaller().getLocation());
                    txtMessage.setText(paramedicWorkRequest.getMessage());
                    JPanel map = MapsUtil.mapWayPoint(paramedicWorkRequest.getCaller().getCoordinates());
                    displayPanel(maps, map);
                    if (paramedicWorkRequest.getStatus().equals("Awaiting Paramedic's Action")) {
                        JOptionPane.showMessageDialog(mainPane, "You have a message from the assigned Physician!");
                        MessageFromPhysicianJPanel mpjp = new MessageFromPhysicianJPanel(mainPane, workPane, system, paramedicUserAccount, paramedicWorkRequest);
                        displayPanel(workPane, mpjp);
                    } else if (paramedicWorkRequest.getStatus().equals("Transport Care Required")
                            || paramedicWorkRequest.getStatus().equals("Scene Assessment in progress")) {
                        btnHospitalTransfer.setEnabled(true);
                        btnAcknowledge.setEnabled(false);
                        // go to HospitalTransferJPanel screen
                    } else if (!paramedicWorkRequest.getStatus().equals("Open")) {
                        btnAcknowledge.setEnabled(false);
                    }
                }
            }
        });
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

    public void populateWorkQueueTable() {
        DefaultTableModel paramedicsTableModel = (DefaultTableModel) tblParamedicsWQ.getModel();
        paramedicsTableModel.setRowCount(0);

        WorkQueue workQueue = paramedicUserAccount.getWorkQueue();
        if (workQueue != null) {
            List<WorkRequest> paramedicsWorkRequestList = workQueue.getWorkRequestList();
            if (CollectionUtils.isNotEmpty(paramedicsWorkRequestList)) {
                for (WorkRequest wr : paramedicsWorkRequestList) {
                    Object[] row = new Object[4];
                    row[0] = wr;
                    row[1] = wr.getCaller().getLocation();
                    row[2] = wr.getEmergencyLevel();
                    row[3] = wr.getStatus();
                    paramedicsTableModel.addRow(row);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParamedicsWQ = new javax.swing.JTable();
        txtCallerName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnAcknowledge = new javax.swing.JButton();
        btnHospitalTransfer = new javax.swing.JButton();
        maps = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 590));
        setMinimumSize(new java.awt.Dimension(990, 590));
        setPreferredSize(new java.awt.Dimension(990, 590));
        setRequestFocusEnabled(false);

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Emergencies Required Attention", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));

        tblParamedicsWQ.setModel(new javax.swing.table.DefaultTableModel(
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
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblParamedicsWQ);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Phone Number:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Address:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Message:");

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        jScrollPane2.setViewportView(txtMessage);

        btnAcknowledge.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAcknowledge.setText("Acknowledge");
        btnAcknowledge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcknowledgeActionPerformed(evt);
            }
        });

        btnHospitalTransfer.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHospitalTransfer.setText("Transfer To Hospital");
        btnHospitalTransfer.setEnabled(false);
        btnHospitalTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalTransferActionPerformed(evt);
            }
        });

        maps.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCallerName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAcknowledge)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(maps, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnHospitalTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(146, 146, 146))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAcknowledge, btnHospitalTransfer});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, txtCallerName, txtContact, txtLocation});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCallerName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContact)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLocation)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(maps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHospitalTransfer)
                    .addComponent(btnAcknowledge))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnHospitalTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalTransferActionPerformed
        // pass the paramedicWorkRequest object when redirecting to HospitalTransferJPanel.
        HospitalTransferJPanel htjp = new HospitalTransferJPanel(mainPane, workPane, system, paramedicUserAccount, paramedicWorkRequest);
        displayPanel(workPane, htjp);
    }//GEN-LAST:event_btnHospitalTransferActionPerformed

    private void btnAcknowledgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcknowledgeActionPerformed
        if (paramedicWorkRequest != null) {
            if (paramedicWorkRequest.getStatus().equals("Open")) {
                paramedicWorkRequest.setStatus("Scene Assessment in progress");
                // update status of this WR in sender's workqueue as well.
                paramedicWorkRequest.getSender().getWorkQueue()
                .findWorkRequestByID(paramedicWorkRequest.getWorkRequestID()).setStatus("Scene Assessment in progress");
                // update status of this WR in receiver's work queue as well.
                for (UserAccount receiverAccount : paramedicWorkRequest.getReceivers()) {
                    
                    receiverAccount.getWorkQueue()
                    .findWorkRequestByID(paramedicWorkRequest.getWorkRequestID()).setStatus("Scene Assessment in progress");
                }
                

                paramedicUserAccount.getWorkQueue()
                .findWorkRequestByID(paramedicWorkRequest.getWorkRequestID()).setStatus("Scene Assessment in progress");
                populateWorkQueueTable();

                if (paramedicWorkRequest.getEmergencyLevel() == 'C') {
                    // go to the medicalRecords screen and pass workRequest object.
                    MedicalRecordsJPanel mrjp = new MedicalRecordsJPanel(mainPane, workPane, system, paramedicUserAccount, paramedicWorkRequest);
                    displayPanel(workPane, mrjp);
                }
            } else {
                JOptionPane.showMessageDialog(this, "The work request is already in progress!");
            }
        }
    }//GEN-LAST:event_btnAcknowledgeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcknowledge;
    private javax.swing.JButton btnHospitalTransfer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLayeredPane maps;
    private javax.swing.JTable tblParamedicsWQ;
    private javax.swing.JTextField txtCallerName;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextArea txtMessage;
    // End of variables declaration//GEN-END:variables
}
