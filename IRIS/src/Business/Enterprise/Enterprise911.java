package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class Enterprise911 extends Enterprise{
    
    public Enterprise911(String name){
        super(name,EnterpriseType.Enterprise911);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
