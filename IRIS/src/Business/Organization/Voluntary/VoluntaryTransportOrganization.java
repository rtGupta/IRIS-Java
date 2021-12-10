package Business.Organization.Voluntary;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Voluntary.Driver;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class VoluntaryTransportOrganization extends Organization{
    
    public VoluntaryTransportOrganization() {
        super(VoluntaryOrgType.VoluntaryTransportOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Driver());
        return roles;
    }    
}
