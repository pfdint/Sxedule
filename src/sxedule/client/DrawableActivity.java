package sxedule.client;

import java.util.Set;
import sxedule.shared.AbstractActivity;
import sxedule.shared.AbstractAgent;

public class DrawableActivity extends AbstractActivity {
    
    public DrawableActivity() {
        super();
    }
    
//.dP"Y8 888888 888888 888888 888888 88""Yb .dP"Y8 
//`Ybo." 88__     88     88   88__   88__dP `Ybo." 
//o.`Y8b 88""     88     88   88""   88"Yb  o.`Y8b 
//8bodP' 888888   88     88   888888 88  Yb 8bodP' 
    
    @Override
    public void setStartTime(long startTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setEndTime(long endTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMinCampers(int minCampers) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMaxCampers(int maxCampers) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNeededStaff(int neededStaff) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMaxStaff(int maxStaff) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPredeterminedRatio(double predeterminedRatio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setActivityName(String activityName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setStaffPrerequisites(Set<String> staffPrerequisites) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToStaffPrerequisites(String flagToAdd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAssignedStaff(Set<AbstractAgent> assignedStaff) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToAssignedStaff(AbstractAgent staffMember) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRow(int row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBroadcast(boolean broadcast) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setIsDuty(boolean isDuty) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long returnStartTime() {
        return startTime;
    }

    public long returnEndTime() {
        return endTime;
    }

    public int returnMinCampers() {
        return minCampers;
    }

    public int returnMaxCampers() {
        return maxCampers;
    }

    public int returnNeededStaff() {
        return neededStaff;
    }

    public int returnMaxStaff() {
        return maxStaff;
    }

    public double returnPredeterminedRatio() {
        return predeterminedRatio;
    }

    public String returnActivityName() {
        return activityName;
    }

    public Set<String> retreiveStaffPrerequisites() {
        return staffPrerequisites;
    }

    public Set<AbstractAgent> retrieveAssignedStaff() {
        return assignedStaff;
    }

    public int returnRow() {
        return row;
    }

    public boolean isBroadcast() {
        return broadcast;
    }

    public boolean isIsDuty() {
        return isDuty;
    }
    
//88""Yb 888888 888888 88""Yb 88 888888 Yb    dP 888888 88""Yb .dP"Y8 
//88__dP 88__     88   88__dP 88 88__    Yb  dP  88__   88__dP `Ybo." 
//88"Yb  88""     88   88"Yb  88 88""     YbdP   88""   88"Yb  o.`Y8b 
//88  Yb 888888   88   88  Yb 88 888888    YP    888888 88  Yb 8bodP' 
    
}
