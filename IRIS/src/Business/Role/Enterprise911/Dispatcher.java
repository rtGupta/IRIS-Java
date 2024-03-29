package Business.Role.Enterprise911;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UI.Dispatcher.DispatcherJPanel;
import UI.MainScreens.LandingScreenJPanel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public class Dispatcher extends Role {
    
    @Override
    public JPanel createWorkArea(JLayeredPane mainPane, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //need to specify role specific Jpanel
        return new DispatcherJPanel(mainPane, account, organization, enterprise, system);
    }
    
}
