package Business.UserAccount;

import Business.Role.Role;
import Business.Utilities.Profile;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Yaswanth
 */
public class UserAccount {
    
    private Profile profileDetails;
    private String username;
    private String password;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
    }

    public Profile getProfileDetails() {
        return profileDetails;
    }

    public void setProfileDetails(Profile profileDetails) {
        this.profileDetails = profileDetails;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return username;
    }
    
}