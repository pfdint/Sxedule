package sxedule.shared; 

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Activity implements Serializable { 
    
    private long startTime;
    private long endTime;
    
    private int minCampers;
    private int maxCampers;
    
    private int neededStaff;
    private int maxStaff;
    
    private double predeterminedRatio;
    
    private String activityName;
    
    private Set<String> staffPrerequisites;
    
    private Set<Agent> assignedStaff;
    
    private int row;
    
    private boolean broadcast;
    private boolean duty;
    
    public Activity() {
        staffPrerequisites = new HashSet<>();
        assignedStaff = new HashSet<>();
    }
    
//.dP"Y8 888888 888888 888888 888888 88""Yb .dP"Y8 
//`Ybo." 88__     88     88   88__   88__dP `Ybo." 
//o.`Y8b 88""     88     88   88""   88"Yb  o.`Y8b 
//8bodP' 888888   88     88   888888 88  Yb 8bodP' 
    
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setMinCampers(int minCampers) {
        this.minCampers = minCampers;
    }

    public void setMaxCampers(int maxCampers) {
        this.maxCampers = maxCampers;
    }

    public void setNeededStaff(int neededStaff) {
        
    }

    public void setMaxStaff(int maxStaff) {
        this.maxStaff = maxStaff;
    }

    public void setPredeterminedRatio(double predeterminedRatio) {
        this.predeterminedRatio = predeterminedRatio;
    }
    
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setStaffPrerequisites(Set<String> staffPrerequisites) {
        
    }
    
    public void addToStaffPrerequisites(String flagToAdd) {
        staffPrerequisites.add(flagToAdd);
    }

    public void setAssignedStaff(Set<Agent> assignedStaff) {
        this.assignedStaff = assignedStaff;
    }
    
    public void addToAssignedStaff(Agent staffMember) {
        assignedStaff.add(staffMember);
    }
    
    public void setRow(int row) {
        this.row = row;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public void setDuty(boolean isDuty) {
        this.duty = isDuty;
    }
    
//88""Yb 888888 888888 88""Yb 88 888888 Yb    dP 888888 88""Yb .dP"Y8 
//88__dP 88__     88   88__dP 88 88__    Yb  dP  88__   88__dP `Ybo." 
//88"Yb  88""     88   88"Yb  88 88""     YbdP   88""   88"Yb  o.`Y8b 
//88  Yb 888888   88   88  Yb 88 888888    YP    888888 88  Yb 8bodP' 

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

    public Set<String> retrieveStaffPrerequisites() {
        return staffPrerequisites;
    }

    public Set<Agent> retrieveAssignedStaff() {
        return assignedStaff;
    }

    public int returnRow() {
        return row;
    }

    public boolean isBroadcast() {
        return broadcast;
    }

    public boolean isDuty() {
        return duty;
    }
    
}