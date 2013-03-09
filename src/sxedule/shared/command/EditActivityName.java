package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityName implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private String storedName;
    
    public EditActivityName(int activityToEdit, String newName) {
        this.activityToEdit = activityToEdit;
        storedName = newName;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setActivityName(storedName);
    }

    @Override
    public void undo() {
        
    }
    
}