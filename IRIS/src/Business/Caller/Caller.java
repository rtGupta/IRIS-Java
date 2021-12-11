/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Caller;

import Business.Utilities.Address;
import Business.Utilities.Profile;

/**
 *
 * @author aarti
 */
public class Caller {
    
    private Profile callerDetails;
    private String location;
    private Vitals vitals;
    private String[] medicalHistory;
    private double height;
    private double weight;
    private String bloodGrp;

    public Caller(String firstName, String lastName, long contact, String location) {
        this.callerDetails = new Profile(firstName, lastName, contact);
        this.location = location;
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

    public String[] getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String[] medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
