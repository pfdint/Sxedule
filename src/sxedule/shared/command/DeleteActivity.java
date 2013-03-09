package sxedule.shared.command;

import sxedule.shared.Timeline;

public class DeleteActivity implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToDelete;
    
    public DeleteActivity(int activityToDelete) {
        this.activityToDelete = activityToDelete;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivities().remove(timeline.retrieveActivityIDMap().remove(activityToDelete));
    }

    @Override
    public void undo() {
        
    }
    
}
