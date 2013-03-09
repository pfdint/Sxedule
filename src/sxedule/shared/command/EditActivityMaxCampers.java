package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityMaxCampers implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private int storedMaxCampers;
    
    public EditActivityMaxCampers(int activityToEdit, int newMaxCampers) {
        this.activityToEdit = activityToEdit;
        storedMaxCampers = newMaxCampers;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setMaxCampers(storedMaxCampers);
    }

    @Override
    public void undo() {
        
    }
    
}
