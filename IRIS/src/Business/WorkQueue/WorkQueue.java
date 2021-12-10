package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Yaswanth
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public int retrieveLastWRID() {
        int wqLength = getWorkRequestList().size();
        return getWorkRequestList().get(wqLength - 1) != null
                ? getWorkRequestList().get(wqLength - 1).getWorkRequestID() : 1;
    }
}
