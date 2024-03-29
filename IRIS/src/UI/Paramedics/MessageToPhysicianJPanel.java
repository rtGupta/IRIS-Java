/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Paramedics;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization._911.Physician911Organization;
import Business.Role.Enterprise911.Physician911;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import Util.CameraUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.bytedeco.javacv.FrameGrabber;

/**
 *
 * @author akshatajadhav
 */
public class MessageToPhysicianJPanel extends javax.swing.JPanel {

    final String VIDEO_FILE_NAME;
    boolean initializeCamera = true;
    boolean cameraOn = false;
    boolean recorderOn = false;
    boolean messageRecorded = false;
    CameraUtil cu;
    JLayeredPane mainPane;
    JLayeredPane workPane;
    private EcoSystem system;
    private UserAccount paramedicUserAccount;
    WorkRequest request;

    /**
     * Creates new form VitalCollectionsJPanel
     */
    public MessageToPhysicianJPanel(JLayeredPane mainPane, JLayeredPane workPane, EcoSystem system, UserAccount account, WorkRequest request) {
        initComponents();
        this.mainPane = mainPane;
        this.workPane = workPane;
        this.system = system;
        this.paramedicUserAccount = account;
        this.request = request;
        VIDEO_FILE_NAME = request.getCaller().getCallerDetails().getFirstName() + request.getWorkRequestID() + "_paramedic";

        loadPhysicianDropDown();
    }

    private void loadPhysicianDropDown() {
        for (Network network : system.getNetworkList()) {
            Enterprise frEnterprise = network.getEnterpriseDirectory()
                    .findEnterprise(Enterprise.EnterpriseType.Enterprise911.getValue());
            for (Organization org : frEnterprise.getOrganizationDirectory().getOrganizationList()) {
                if (org instanceof Physician911Organization) {
                    this.loadValues(org, jComboBox1);
                }
            }
        }
    }

    private void loadValues(Organization org, JComboBox<UserAccount> drpdown) {
        for (UserAccount acc : org.getUserAccountDirectory().getUserAccountList()) {
            drpdown.addItem(acc);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        camera = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cameraBtn = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 590));
        setMinimumSize(new java.awt.Dimension(990, 590));
        setPreferredSize(new java.awt.Dimension(990, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(990, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(994, 0, 0, -1));

        jPanel2.setBackground(new java.awt.Color(38, 38, 38));

        camera.setBackground(new java.awt.Color(255, 255, 255));
        camera.setPreferredSize(new java.awt.Dimension(640, 400));

        javax.swing.GroupLayout cameraLayout = new javax.swing.GroupLayout(camera);
        camera.setLayout(cameraLayout);
        cameraLayout.setHorizontalGroup(
            cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cameraLayout.setVerticalGroup(
            cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Message to Physician");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        cameraBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/camera_58px.png"))); // NOI18N
        cameraBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cameraBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(cameraBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cameraBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(camera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(camera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        submitBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setText("Physician:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, -1, 22));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 202, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //workRequest.setReceiver((UserAccount) jComboBox1.getSelectedItem());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void cameraBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cameraBtnMouseClicked
        if (!cameraOn && initializeCamera && !messageRecorded) {
            System.out.println("initialized");
            try {
                cameraBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/loadingCamera.gif")));
                cu = new CameraUtil(VIDEO_FILE_NAME, 640, 480);
                cu.startCamera(camera);
                cameraOn = true;
                recorderOn = true;
                cameraBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/recording.png")));
            } catch (FrameGrabber.Exception ex) {
                Logger.getLogger(MessageToPhysicianJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if (cameraOn && !messageRecorded) {
            if (recorderOn == false) {
//                recorderOn = true;
//                cameraBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/recording.png")));
//                cu.startRecording();
            } else if (recorderOn) {
                recorderOn = false;
                cameraBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/video_48px.png")));
                cu.stopCamera();
                messageRecorded = true;
            }
            return;
        }
        if (messageRecorded) {
            JOptionPane.showMessageDialog(this, "Video Message Recorded");
        }
    }//GEN-LAST:event_cameraBtnMouseClicked

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        request.setReceiver((UserAccount) jComboBox1.getSelectedItem());        
        request.setStatus("Awaiting Physician's review");

        // update status of this WR in sender's workqueue as well.
        paramedicUserAccount.getWorkQueue()
                .findWorkRequestByID(request.getWorkRequestID()).setStatus("Awaiting Physician's review");
        // update status of this WR in receiver's work queue as well.
        request.getReceivers().forEach(receiver -> {
            if (receiver.getRole() instanceof Physician911) {
                receiver.getWorkQueue().getWorkRequestList().add(request);
            } else {
                receiver.getWorkQueue().findWorkRequestByID(request.getWorkRequestID()).setStatus("Awaiting Physician's review");
            }
        });
        
        paramedicUserAccount.getWorkQueue()
                        .findWorkRequestByID(request.getWorkRequestID()).setStatus("Awaiting Physician's review");
        if (!messageRecorded) {
            JOptionPane.showMessageDialog(this, "Please record video message!");
            return;
        }
        if (cu != null) {
            cu.stopCamera();
        }
        
        // redirect to Paramedic's home screen.
        ParamedicHistoryJPanel phjp = new ParamedicHistoryJPanel(mainPane, workPane, system, paramedicUserAccount);
        displayPanel(workPane, phjp);
    }//GEN-LAST:event_submitBtnActionPerformed

    public void displayPanel(JLayeredPane lpane, JPanel panel) {
        lpane.removeAll();
        lpane.add(panel);
        lpane.repaint();
        lpane.revalidate();
        JFrame parentFrame = (JFrame) SwingUtilities.getRoot(mainPane);
        parentFrame.pack();
        parentFrame.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel camera;
    private javax.swing.JLabel cameraBtn;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables

    public void stopCamera() {
        if (cu != null) {
            cu.stopCamera();
        }
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (cu != null) {
            cu.stopCamera();
        }
    }
}
