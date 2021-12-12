package Business.Utilities;

import java.util.Date;

/**
 *
 * @author aarti
 */
public class Profile {
    
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private long phone;
    private Date dob;
    private String hospitalName;
    private String homeAddress;
    private String workAddress;
    private double[] location;
//    private double latitude;
//    private double longitude;
    
    public Profile(String firstName, String lastName, String gender, String email, long phone, Date dob, String homeAddress, String workAddress) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
      this.email = email;
      this.phone = phone;
      this.dob = dob;
      this.homeAddress = homeAddress;
      this.workAddress = workAddress;
    }
    
    public Profile(String firstName, String lastName, long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    
    public Profile(String hospitalName, String email, long phone, String workAddress) {
        this.hospitalName = hospitalName;
        this.email = email;
        this.workAddress = workAddress;
        this.phone = phone;
    }    
    
    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    
}
