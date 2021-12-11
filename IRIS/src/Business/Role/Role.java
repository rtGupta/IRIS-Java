package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yaswanth
 */
public abstract class Role {
    
    public enum Enterprise911RoleType{
        Dispatcher("Dispatcher"),
        Physician911("Physician911");
        
        private String value;
        private Enterprise911RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public enum FirstResponderRoleType{
        FirstRespAdmin("FirstRespAdmin"),
        FireMan("FireMan"),
        Paramedic("Paramedic"),
        Police("Police");
        
        private String value;
        private FirstResponderRoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }    
    
//    public enum HealthCareRoleType{
//        StaffAdministrator("StaffAdministrator");
//        
//        private String value;
//        private HealthCareRoleType(String value){
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//        @Override
//        public String toString() {
//            return value;
//        }
//    }

    public enum VoluntaryRoleType{
        VoluntaryClinician("VoluntaryClinician"),
        VoluntaryTransport("VoluntaryTransport");
        
        private String value;
        private VoluntaryRoleType(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }

    public enum EntepriseLevelRoleType{
        Enterprise911Admin("Enterprise911Admin"),
        FirstRespAdmin("FirstRespAdmin"),
        StaffAdministrator("StaffAdministrator");
        
        private String value;
        private EntepriseLevelRoleType(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }    
	
    public abstract JPanel createWorkArea(JLayeredPane mainPane,
            UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business);    

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}