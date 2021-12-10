package Business.Organization.Voluntary;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Voluntary.VoluntaryPhysician;
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
        roles.add(new VoluntaryPhysician());
        return roles;
    }    
}
