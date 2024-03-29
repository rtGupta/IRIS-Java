package Business.Role.FirstResponder;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UI.Firefighter.FirefighterJPanel;
import UI.MainScreens.LandingScreenJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public class Fireman extends Role {

    @Override
    public JPanel createWorkArea(JLayeredPane mainPane, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //need to specify role specific Jpanel
        return new FirefighterJPanel(mainPane, account, organization, enterprise, system);
    }
}
