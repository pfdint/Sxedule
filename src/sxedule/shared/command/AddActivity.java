package sxedule.shared.command;

import sxedule.shared.Activity;
import sxedule.shared.Timeline;

public class AddActivity implements TimelineCommand {
    
    private transient Timeline timeline;

    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        Activity createdActivity = new Activity();
        timeline.retrieveActivityIDMap().put(timeline.returnActivityIDLabeler(), createdActivity);
        timeline.incrementActivityIDLabeler();
        timeline.retrieveActivities().add(createdActivity);
    }

    @Override
    public void undo() {
        
    }
    
}
