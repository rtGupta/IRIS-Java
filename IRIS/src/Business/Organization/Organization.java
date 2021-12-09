package Business.Organization;

import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author Yaswanth
 */
public abstract class Organization {

    private UserAccountDirectory userAccountDirectory;

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }   
}
