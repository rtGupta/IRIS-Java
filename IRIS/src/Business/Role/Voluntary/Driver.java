package Business.Role.Voluntary;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UI.MainScreens.LoginJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public class Driver extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //need to specify role specific Jpanel
        return new LoginJPanel(new JLayeredPane(), system);
    }
}
