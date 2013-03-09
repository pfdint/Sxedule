package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityMaxStaff implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private int storedMaxStaff;
    
    public EditActivityMaxStaff(int activityToEdit, int newMaxStaff) {
        this.activityToEdit = activityToEdit;
        storedMaxStaff = newMaxStaff;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setMaxStaff(storedMaxStaff);
    }

    @Override
    public void undo() {
        
    }
    
}