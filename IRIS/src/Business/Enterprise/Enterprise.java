package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yaswanth
 */
public abstract class Enterprise extends Organization{
    
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public enum EnterpriseType{
        Enterprise911("Enterprise911"),
        FirstResponderEnterprise("FirstResponderEnterprise"),
        HealthcareEnterprise("HealthcareEnterprise"),
        VoluntaryEnterprise("VoluntaryEnterprise");
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        public EnterpriseType findByValue(String value) {
            EnterpriseType resultType = null;
            for(EnterpriseType type: EnterpriseType.values()){
                if(StringUtils.equalsIgnoreCase(value, type.value)) {
                    resultType = type;
                }
            }
            return resultType;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
	
    public Enterprise(String name,EnterpriseType type){
        super(name);
        this.enterpriseType=type;
        organizationDirectory = new OrganizationDirectory();
    }

    @Override
    public String toString() {
        return super.getName();
    }
    
    
}
