package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditAgentFirstName implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int agentToEdit;
    
    private String storedFirstName;
    
    public EditAgentFirstName(int agentToEdit, String newFirstName) {
        this.agentToEdit = agentToEdit;
        storedFirstName = newFirstName;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveAgentIDMap().get(agentToEdit).setFirstName(storedFirstName);
    }

    @Override
    public void undo() {
        
    }
    
}
