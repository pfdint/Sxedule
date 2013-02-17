package sxedule.server; 

import java.io.Serializable;
import java.util.Set;
import sxedule.shared.AbstractActivity;
import sxedule.shared.AbstractAgent;

public class Activity extends AbstractActivity implements Serializable { 
    
    public Activity() {
        super();
    }
    
//.dP"Y8 888888 888888 888888 888888 88""Yb .dP"Y8 
//`Ybo." 88__     88     88   88__   88__dP `Ybo." 
//o.`Y8b 88""     88     88   88""   88"Yb  o.`Y8b 
//8bodP' 888888   88     88   888888 88  Yb 8bodP' 
    
    @Override
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public void setMinCampers(int minCampers) {
        this.minCampers = minCampers;
    }

    @Override
    public void setMaxCampers(int maxCampers) {
        this.maxCampers = maxCampers;
    }

    @Override
    public void setNeededStaff(int neededStaff) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMaxStaff(int maxStaff) {
        this.maxStaff = maxStaff;
    }

    @Override
    public void setPredeterminedRatio(double predeterminedRatio) {
        this.predeterminedRatio = predeterminedRatio;
    }
    
    @Override
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public void setStaffPrerequisites(Set<String> staffPrerequisites) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void addToStaffPrerequisites(String flagToAdd) {
        staffPrerequisites.add(flagToAdd);
    }

    @Override
    public void setAssignedStaff(Set<AbstractAgent> assignedStaff) {
        this.assignedStaff = assignedStaff;
    }
    
    @Override
    public void addToAssignedStaff(AbstractAgent staffMember) {
        assignedStaff.add(staffMember);
    }
    
    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    @Override
    public void setIsDuty(boolean isDuty) {
        this.isDuty = isDuty;
    }
    
}