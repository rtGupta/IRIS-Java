package Business.Organization.FirstResponder;

import Business.Organization.Organization;
import Business.Role.FirstResponder.Paramedic;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class EMTOrganization extends Organization{
    
    public EMTOrganization() {
        super(FirstResponderOrgType.EMTOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Paramedic());
        return roles;
    }
}
