/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise911;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.FirstResponderEnterprise;
import Business.Enterprise.HealthcareEnterprise;
import Business.Enterprise.VoluntaryEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import UI.MainScreens.LoginJPanel;
import UI.MainScreens.LandingScreenJPanel;
import javax.swing.JPanel;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author akshatajadhav
 */
public class MainJFrame extends javax.swing.JFrame {

    private EcoSystem system;
    public static DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public Network network;
    public EnterpriseDirectory enterpriseDirectory;
    public OrganizationDirectory organizationDirectory;
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();

        system = dB4OUtil.retrieveSystem();
        
//        Network network = null;
        if(CollectionUtils.isEmpty(system.getNetworkList())){
            this.network = system.createAndAddNetwork();
            network.setName("Boston");
        }else {
            this.network = system.getNetworkList().get(0);
        }
        if(network != null ){
            if(network.getEnterpriseDirectory()!=null && CollectionUtils.isEmpty(network.getEnterpriseDirectory().getEnterpriseList())){
                EnterpriseDirectory enterpriseDirectory = network.getEnterpriseDirectory();
                enterpriseDirectory.createAndAddEnterprise(Enterprise.EnterpriseType.Enterprise911.getValue(), Enterprise.EnterpriseType.Enterprise911);
                enterpriseDirectory.createAndAddEnterprise(Enterprise.EnterpriseType.FirstResponderEnterprise.getValue(), Enterprise.EnterpriseType.FirstResponderEnterprise);
                enterpriseDirectory.createAndAddEnterprise(Enterprise.EnterpriseType.HealthcareEnterprise.getValue(), Enterprise.EnterpriseType.HealthcareEnterprise);
                enterpriseDirectory.createAndAddEnterprise(Enterprise.EnterpriseType.VoluntaryEnterprise.getValue(), Enterprise.EnterpriseType.VoluntaryEnterprise);
                network.setEnterpriseDirectory(enterpriseDirectory);                
            }
            this.enterpriseDirectory = network.getEnterpriseDirectory();            
        }
        if(enterpriseDirectory != null) {
            for (Enterprise enterprise : enterpriseDirectory.getEnterpriseList()) {
                if (enterprise != null && enterprise.getOrganizationDirectory()!=null
                        && CollectionUtils.isEmpty(enterprise.getOrganizationDirectory().getOrganizationList())) {
                    OrganizationDirectory organizationDirectory = enterprise.getOrganizationDirectory();
                    if(enterprise instanceof Enterprise911){
                        organizationDirectory.createEnterprise911Organization(Organization.Enterprise911OrgType.DispatcherOrg);
                        organizationDirectory.createEnterprise911Organization(Organization.Enterprise911OrgType.Physician911);
                        enterprise.setOrganizationDirectory(organizationDirectory);
                    } else if(enterprise instanceof FirstResponderEnterprise) {
                        organizationDirectory.createFirstResponderOrganization(Organization.FirstResponderOrgType.EMTOrg);
                        organizationDirectory.createFirstResponderOrganization(Organization.FirstResponderOrgType.FireOrg);
                        organizationDirectory.createFirstResponderOrganization(Organization.FirstResponderOrgType.LawEnforcementOrg);
                        enterprise.setOrganizationDirectory(organizationDirectory);                        
                    } else if(enterprise instanceof HealthcareEnterprise) {
                        organizationDirectory.createHealthCareOrganization(Organization.HealthCareOrgType.NonClinicalOrg);
                        enterprise.setOrganizationDirectory(organizationDirectory);                        
                    } else if(enterprise instanceof VoluntaryEnterprise) {
                        organizationDirectory.createVoluntaryOrganization(Organization.VoluntaryOrgType.VoluntaryClinicianOrg);
                        organizationDirectory.createVoluntaryOrganization(Organization.VoluntaryOrgType.VoluntaryTransportOrg);
                        enterprise.setOrganizationDirectory(organizationDirectory);                        
                    }
                }
            }
            network.setEnterpriseDirectory(enterpriseDirectory);
        }
        //system.getNetworkList().set(0, network);
        
        LandingScreenJPanel lsjp = new LandingScreenJPanel(mainPane, system);
        displayPanel(lsjp);
    }

    public void displayPanel(JPanel panel) {
        mainPane.removeAll();
        mainPane.add(panel);
        mainPane.repaint();
        mainPane.revalidate();
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainPaneMouseClicked(evt);
            }
        });
        mainPane.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPaneMouseClicked

    }//GEN-LAST:event_mainPaneMouseClicked

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane mainPane;
    // End of variables declaration//GEN-END:variables
}
