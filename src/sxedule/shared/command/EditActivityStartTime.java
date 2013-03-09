package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityStartTime implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private long storedStartTime;
    
    public EditActivityStartTime(int activityToEdit, long newStartTime) {
        this.activityToEdit = activityToEdit;
        this.storedStartTime = newStartTime;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setStartTime(storedStartTime);
    }

    @Override
    public void undo() {
        
    }
    
}
