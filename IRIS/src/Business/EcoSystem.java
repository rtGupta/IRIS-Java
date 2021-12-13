package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Yaswanth
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private Set<String> usernames;

    public static EcoSystem getInstance() {

        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<Network>();
        usernames = new HashSet<String>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

//    public boolean checkIfUserIsUnique(String userName) {
//        if (this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
//            return true;
//        }
//        return false;
//    }
    public Set<String> getUsernames() {
        return usernames;
    }

//    public void setUsernames(Set<String> usernames) {
//        this.usernames = usernames;
//    }
    public boolean isUniqueUsername(String username) {
        return !usernames.contains(username);
    }

    public void deleteUsername(String username) {
        usernames.remove(username);
    }

    public void addUsername(String username) {
        usernames.add(username);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

}
