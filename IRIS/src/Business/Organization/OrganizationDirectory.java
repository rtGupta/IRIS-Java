package Business.Organization;

import Business.Organization.FirstResponder.EMTOrganization;
import Business.Organization.FirstResponder.FireOrganization;
import Business.Organization.FirstResponder.LawEnforcementOrganization;
import Business.Organization.HealthCare.NonClinicalOrganization;
import Business.Organization.Organization.Enterprise911OrgType;
import Business.Organization.Organization.FirstResponderOrgType;
import Business.Organization.Organization.HealthCareOrgType;
import Business.Organization.Organization.VoluntaryOrgType;
import Business.Organization.Voluntary.VoluntaryPhysicianOrganization;
import Business.Organization.Voluntary.VoluntaryTransportOrganization;
import Business.Organization._911.Dispatcher911Organization;
import Business.Organization._911.Physician911Organization;
import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public Organization createEnterprise911Organization(Enterprise911OrgType type) {
        Organization organization = null;
        if (type.getValue().equals(Enterprise911OrgType.DispatcherOrg.getValue())) {
            organization = new Dispatcher911Organization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Enterprise911OrgType.Physician911.getValue())) {
            organization = new Physician911Organization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public Organization createFirstResponderOrganization(FirstResponderOrgType type) {
        Organization organization = null;
        if (type.getValue().equals(FirstResponderOrgType.EMTOrg.getValue())) {
            organization = new EMTOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(FirstResponderOrgType.FireOrg.getValue())) {
            organization = new FireOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(FirstResponderOrgType.LawEnforcementOrg.getValue())) {
            organization = new LawEnforcementOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public Organization createHealthCareOrganization(HealthCareOrgType type) {
        Organization organization = null;
        if (type.getValue().equals(HealthCareOrgType.NonClinicalOrg.getValue())) {
            organization = new NonClinicalOrganization();
            organizationList.add(organization);
        }
        return organization;
    }

    public Organization createVoluntaryOrganization(VoluntaryOrgType type) {
        Organization organization = null;
        if (type.getValue().equals(VoluntaryOrgType.VoluntaryPhysicianOrg.getValue())) {
            organization = new VoluntaryPhysicianOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(VoluntaryOrgType.VoluntaryTransportOrg.getValue())) {
            organization = new VoluntaryTransportOrganization();
            organizationList.add(organization);
        }
        return organization;
    }    
}