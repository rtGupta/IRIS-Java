package Business.Role.FirstResponder;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UI.MainScreens.LandingScreenJPanel;
import UI.PoliceOfficer.PoliceOfficerJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public class Police extends Role {

    @Override
    public JPanel createWorkArea(JLayeredPane mainPane, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //need to specify role specific Jpanel
        return new PoliceOfficerJPanel(mainPane, account, organization, enterprise, system);
    }
}
