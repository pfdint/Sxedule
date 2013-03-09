package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityDuty implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private boolean storedDuty;
    
    public EditActivityDuty(int activityToEdit, boolean newDuty) {
        this.activityToEdit = activityToEdit;
        storedDuty = newDuty;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setDuty(storedDuty);
    }

    @Override
    public void undo() {
        
    }
    
}