package Business.WorkQueue;

import Business.Caller.Caller;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Yaswanth
 */
public class WorkRequest {

    private int workRequestID;
    private Caller caller;
    private char emergencyLevel;
    private String status;
    private String message;
    private UserAccount sender;
    private ArrayList<UserAccount> receivers;
    private Date requestDate;
    private Date resolveDate;

    public WorkRequest(int workRequestID) {
        this.workRequestID = workRequestID;
        receivers = new ArrayList<>();
        requestDate = new Date();
    }
    
    public Caller getCaller() {
        return caller;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public ArrayList<UserAccount> getReceivers() {
        return receivers;
    }

    public void setReceiver(UserAccount receiver) {
        this.receivers.add(receiver);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public int getWorkRequestID() {
        return workRequestID;
    }

    public char getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(char emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }
    
    @Override
    public String toString() {
        return String.valueOf(workRequestID);
    }
}
