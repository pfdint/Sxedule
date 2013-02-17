package sxedule.shared;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractActivity {
    
    protected long startTime;
    protected long endTime;
    
    protected int minCampers;
    protected int maxCampers;
    
    protected int neededStaff;
    protected int maxStaff;
    
    protected double predeterminedRatio;
    
    protected String activityName;
    
    protected Set<String> staffPrerequisites;
    
    protected Set<AbstractAgent> assignedStaff;
    
    protected int row;
    
    protected boolean broadcast;
    protected boolean isDuty;
    
    public AbstractActivity() {
        staffPrerequisites = new HashSet<>();
        assignedStaff = new HashSet<>();
    }

    public abstract void setStartTime(long startTime);

    public abstract void setEndTime(long endTime);
    
    public abstract void setMinCampers(int minCampers);
    
    public abstract void setMaxCampers(int maxCampers);
    
    public abstract void setNeededStaff(int neededStaff);
    
    public abstract void setMaxStaff(int maxStaff);
    
    public abstract void setPredeterminedRatio(double predeterminedRatio);
    
    public abstract void setActivityName(String activityName);
    
    public abstract void setStaffPrerequisites(Set<String> staffPrerequisites);
    
    public abstract void addToStaffPrerequisites(String flagToAdd);

    public abstract void setAssignedStaff(Set<AbstractAgent> assignedStaff);
    
    public abstract void addToAssignedStaff(AbstractAgent staffMember);

    public abstract void setRow(int row);

    public abstract void setBroadcast(boolean broadcast);

    public abstract void setIsDuty(boolean isDuty);
    
}
