package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityEndTime implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private long storedEndTime;
    
    public EditActivityEndTime(int activityToEdit, long newEndTime) {
        this.activityToEdit = activityToEdit;
        this.storedEndTime = newEndTime;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setEndTime(storedEndTime);
    }

    @Override
    public void undo() {
        
    }
    
}
