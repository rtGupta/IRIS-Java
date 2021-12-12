package Business.Role.HealthCare;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UI.Hospital.HospitalJPanel;
import UI.MainScreens.LandingScreenJPanel;
import UI.OrganizationAdmin.HealthCareAdminJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public class StaffAdministrator extends Role {

    @Override
    public JPanel createWorkArea(JLayeredPane mainPane, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //need to specify role specific Jpanel
        return new HospitalJPanel(mainPane, account, organization, enterprise, system);
    }   
}
