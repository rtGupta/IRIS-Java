package Business.Organization._911;

import Business.Organization.Organization;
import Business.Role.Enterprise911.Dispatcher;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class Dispatcher911Organization extends Organization{
    
    public Dispatcher911Organization() {
        super(Enterprise911OrgType.DispatcherOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Dispatcher());
        return roles;
    }
}
