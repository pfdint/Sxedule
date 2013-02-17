package sxedule.shared;

public class Clip {
    
    private long activitiesStart;
    
    private long activitiesEnd;
    
    private long agentsStart;
    
    private long agentsEnd;

    public long returnActivitiesStart() {
        return activitiesStart;
    }

    public void setActivitiesStart(long activitiesStart) {
        this.activitiesStart = activitiesStart;
    }

    public long returnActivitiesEnd() {
        return activitiesEnd;
    }

    public void setActivitiesEnd(long activitiesEnd) {
        this.activitiesEnd = activitiesEnd;
    }

    public long returnAgentsStart() {
        return agentsStart;
    }

    public void setAgentsStart(long agentsStart) {
        this.agentsStart = agentsStart;
    }

    public long returnAgentsEnd() {
        return agentsEnd;
    }

    public void setAgentsEnd(long agentsEnd) {
        this.agentsEnd = agentsEnd;
    }
    
}