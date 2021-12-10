package Business.Organization.FirstResponder;

import Business.Organization.Organization;
import Business.Role.FirstResponder.Fireman;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class FireOrganization extends Organization{
    
    public FireOrganization() {
        super(FirstResponderOrgType.FireOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Fireman());
        return roles;
    }    
}
