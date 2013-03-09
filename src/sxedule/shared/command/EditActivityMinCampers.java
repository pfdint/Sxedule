package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityMinCampers implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private int storedMinCampers;
    
    public EditActivityMinCampers(int activityToEdit, int newMinCampers) {
        this.activityToEdit = activityToEdit;
        storedMinCampers = newMinCampers;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setMinCampers(storedMinCampers);
    }

    @Override
    public void undo() {
        
    }
    
}
