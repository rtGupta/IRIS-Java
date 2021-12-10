package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class HealthcareEnterprise extends Enterprise{
    
    public HealthcareEnterprise(String name){
        super(name,EnterpriseType.HealthcareEnterprise);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
