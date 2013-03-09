package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditActivityNeededStaff implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int activityToEdit;
    
    private int storedNeededStaff;
    
    public EditActivityNeededStaff(int activityToEdit, int newNeededStaff) {
        this.activityToEdit = activityToEdit;
        storedNeededStaff = newNeededStaff;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveActivityIDMap().get(activityToEdit).setNeededStaff(storedNeededStaff);
    }

    @Override
    public void undo() {
        
    }
    
}