package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   
    public EnterpriseDirectory(){
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Enterprise911){
            enterprise=new Enterprise911(name);
            enterpriseList.add(enterprise);
        }else if(type==Enterprise.EnterpriseType.FirstResponderEnterprise){
            enterprise=new FirstResponderEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type==Enterprise.EnterpriseType.HealthcareEnterprise){
            enterprise=new HealthcareEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type==Enterprise.EnterpriseType.VoluntaryEnterprise){
            enterprise=new VoluntaryEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
    public Enterprise findEnterprise(EnterpriseType type){
        Enterprise resultEnterprise = null;
        for(Enterprise enterprise: enterpriseList){
            if(enterprise.getEnterpriseType().equals(type)){
                resultEnterprise = enterprise; 
            }
        }
        return resultEnterprise;
    }
    
}
