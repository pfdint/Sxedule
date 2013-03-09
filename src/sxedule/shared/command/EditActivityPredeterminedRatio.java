package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityPredeterminedRatio implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private double storedPredeterminedRatio;
    
    public EditActivityPredeterminedRatio(int activityToEdit, double newPredeterminedRatio) {
        this.activityToEdit = activityToEdit;
        storedPredeterminedRatio = newPredeterminedRatio;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setPredeterminedRatio(storedPredeterminedRatio);
    }

    @Override
    public void undo() {
        
    }
    
}