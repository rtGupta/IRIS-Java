package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Yaswnath
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }


    
    @Override
    public String toString(){
        return name;
    }
    
}
