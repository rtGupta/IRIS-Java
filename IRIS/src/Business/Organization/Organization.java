package Business.Organization;

import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yaswanth
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Enterprise911OrgType{
        DispatcherOrg("Dispatcher"),
        Physician911("911 Physician");
        
        private String value;
        private Enterprise911OrgType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
        public Enterprise911OrgType findByValue(String value) {
            Enterprise911OrgType resultType = null;
            for(Enterprise911OrgType type: Enterprise911OrgType.values()){
                if(StringUtils.equalsIgnoreCase(value, type.value)) {
                    resultType = type;
                }
            }
            return resultType;
        }
    }
    
    public enum FirstResponderOrgType{
        EMTOrg("EMTOrg"),
        FireOrg("FireOrg"),
        LawEnforcementOrg("LawEnforcementOrg");
        
        private String value;
        private FirstResponderOrgType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
        public FirstResponderOrgType findByValue(String value) {
            FirstResponderOrgType resultType = null;
            for(FirstResponderOrgType type: FirstResponderOrgType.values()){
                if(StringUtils.equalsIgnoreCase(value, type.value)) {
                    resultType = type;
                }
            }
            return resultType;
        }
    }

    public enum HealthCareOrgType{
        NonClinicalOrg("NonClinicalOrg");
        
        private String value;
        private HealthCareOrgType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
        public HealthCareOrgType findByValue(String value) {
            HealthCareOrgType resultType = null;
            for(HealthCareOrgType type: HealthCareOrgType.values()){
                if(StringUtils.equalsIgnoreCase(value, type.value)) {
                    resultType = type;
                }
            }
            return resultType;
        }
    }

    public enum VoluntaryOrgType{
        VoluntaryClinicianOrg("VoluntaryClinicianOrg"),
        VoluntaryTransportOrg("VoluntaryTransportOrg");
        
        private String value;
        private VoluntaryOrgType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
        public VoluntaryOrgType findByValue(String value) {
            VoluntaryOrgType resultType = null;
            for(VoluntaryOrgType type: VoluntaryOrgType.values()){
                if(StringUtils.equalsIgnoreCase(value, type.value)) {
                    resultType = type;
                }
            }
            return resultType;
        }
    }    

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    public int getOrganizationID() {
        return organizationID;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
