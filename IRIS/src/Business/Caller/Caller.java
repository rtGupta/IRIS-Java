/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Caller;

import Business.Utilities.Address;
import Business.Utilities.Profile;
import java.util.List;

/**
 *
 * @author aarti
 */
public class Caller {

    private Profile callerDetails;
    private String location;
    private Vitals vitals;
    private List<String> medicalHistory;
    private double height;
    private double weight;
    private String bloodGrp;
    private double[] coordinates;

    public Caller(String firstName, String lastName, long contact, String location, double[] coordinates) {
        this.callerDetails = new Profile(firstName, lastName, contact);
        this.location = location;
        this.coordinates = coordinates;
    }

    public Boolean isVitalSignsWithinNormalRange(Vitals vs) {
        return !((vs.getBodyTemp() > 98.6)
                || (vs.getOxyLevel() < 88)
                || (vs.getPulse() < 60 || vs.getPulse() > 100)
                || ((vs.getHighBP() < 90 || vs.getHighBP() > 120)
                || (vs.getLowBP() < 60 || vs.getLowBP() > 80)));
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public Profile getCallerDetails() {
        return callerDetails;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBloodGrp() {
        return bloodGrp;
    }

    public void setBloodGrp(String bloodGrp) {
        this.bloodGrp = bloodGrp;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
