package Business.Organization.FirstResponder;

import Business.Organization.Organization;

/**
 *
 * @author Yaswanth
 */
public class EMTOrganization extends Organization{
    
    public enum MedicalConditions {
        Cancer("Cancer"),
        ChronicKidneyDisease("Chronic Kidney Disease"),
        Diabetes("Diabetes"),
        HeartConds("Heart Conditions"),
        HIV("HIV Infection"),
        Dementia("Dementia"),
        Pregnancy("Pregnancy"),
        Smoker("Smoking, current or former"),
        TB("Tuberculosis");
        
        private String condition;

        private MedicalConditions(String condition) {
            this.condition = condition;
        }
        
        public String getValue() {
            return condition;
        }
    }
    
    public MedicalConditions[] getListOfMedicalConditions() {
        return MedicalConditions.values();
    }
    
}
