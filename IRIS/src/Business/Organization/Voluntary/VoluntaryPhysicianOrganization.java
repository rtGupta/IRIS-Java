package Business.Organization.Voluntary;

import Business.Organization.Organization;
import Business.Role.HealthCare.StaffAdministrator;
import Business.Role.Role;
import Business.Role.Voluntary.VoluntaryPhysician;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class VoluntaryPhysicianOrganization extends Organization{
    
    public VoluntaryPhysicianOrganization() {
        super(VoluntaryOrgType.VoluntaryPhysicianOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VoluntaryPhysician());
        return roles;
    }    
}
