/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role.FirstResponder;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UI.MainScreens.LandingScreenJPanel;
import UI.OrganizationAdmin.FirstResponderAdminJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth Digumarthi
 */
public class FirstRespAdmin extends Role{
    
    @Override
    public JPanel createWorkArea(JLayeredPane mainPane, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //need to specify role specific Jpanel
        return new FirstResponderAdminJPanel(mainPane, system, account);
    }
}
