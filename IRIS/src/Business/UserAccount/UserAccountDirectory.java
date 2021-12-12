package Business.UserAccount;

import Business.Role.Role;
import Business.Utilities.Profile;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author Yaswanth
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Role role, Profile profile){
        UserAccount userAccount = new UserAccount();
        userAccount.setProfileDetails(profile);
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    public UserAccount findAccount(String username) {
        for (UserAccount ua: userAccountList) {
            if (ua.getUsername().equals(username)) {
                return ua;
            }
        }
        return null;
    }
    
    public boolean removeUserAccount(UserAccount userAccount){
        boolean deleted = false;
        if(userAccount != null && CollectionUtils.isNotEmpty(userAccountList)){
            Iterator iterator = userAccountList.iterator();
            while(iterator.hasNext()){
                if(userAccount.equals(iterator.next())){
                    iterator.remove();
                    deleted = true;
                }
            }
        }
        return deleted;
    }
}
