package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityBroadcast implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private boolean storedBroadcast;
    
    public EditActivityBroadcast(int activityToEdit, boolean newBroadcast) {
        this.activityToEdit = activityToEdit;
        storedBroadcast = newBroadcast;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setBroadcast(storedBroadcast);
    }

    @Override
    public void undo() {
        
    }
    
}