package Business.Organization.Voluntary;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Voluntary.VoluntaryClinician;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class VoluntaryClinicianOrganization extends Organization{
    
    public VoluntaryClinicianOrganization() {
        super(VoluntaryOrgType.VoluntaryClinicianOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VoluntaryClinician());
        return roles;
    }    
}
