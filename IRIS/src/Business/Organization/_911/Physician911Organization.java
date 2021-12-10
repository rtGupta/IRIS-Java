package Business.Organization._911;

import Business.Organization.Organization;
import Business.Role.Enterprise911.Physician911;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class Physician911Organization extends Organization{
    
    public Physician911Organization() {
        super(Enterprise911OrgType.Physician911.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Physician911());
        return roles;
    }    
}
