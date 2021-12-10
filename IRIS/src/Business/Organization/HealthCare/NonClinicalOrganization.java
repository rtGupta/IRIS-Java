package Business.Organization.HealthCare;

import Business.Organization.Organization;
import Business.Role.HealthCare.StaffAdministrator;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class NonClinicalOrganization extends Organization{
    
    public NonClinicalOrganization() {
        super(HealthCareOrgType.NonClinicalOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StaffAdministrator());
        return roles;
    }
}
