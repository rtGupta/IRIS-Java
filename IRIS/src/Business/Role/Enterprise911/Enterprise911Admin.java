/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role.Enterprise911;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UI.OrganizationAdmin._911AdminJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public class Enterprise911Admin extends Role{
    
    @Override
    public JPanel createWorkArea(JLayeredPane mainPane, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //need to specify role specific Jpanel
        return new _911AdminJPanel(mainPane, system, account);
    }    
}
