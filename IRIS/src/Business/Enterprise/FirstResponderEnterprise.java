package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class FirstResponderEnterprise extends Enterprise{
    
    public FirstResponderEnterprise(String name){
        super(name,EnterpriseType.FirstResponderEnterprise);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
