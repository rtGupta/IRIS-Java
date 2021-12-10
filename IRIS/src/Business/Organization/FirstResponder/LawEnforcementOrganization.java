package Business.Organization.FirstResponder;

import Business.Organization.Organization;
import Business.Role.FirstResponder.Police;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class LawEnforcementOrganization extends Organization{
    
    public LawEnforcementOrganization() {
        super(FirstResponderOrgType.LawEnforcementOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Police());
        return roles;
    } 
}
