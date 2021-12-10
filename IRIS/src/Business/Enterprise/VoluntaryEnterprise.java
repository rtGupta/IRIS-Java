package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class VoluntaryEnterprise extends Enterprise{
    
    public VoluntaryEnterprise(String name){
        super(name, EnterpriseType.VoluntaryEnterprise);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
