package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.MainScreens.LoginJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public class SystemAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //return new LoginJPanel(new JLayeredPane(), system);
        return null;
    }
    
}
