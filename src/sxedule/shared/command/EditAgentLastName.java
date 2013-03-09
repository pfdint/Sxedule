package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditAgentLastName implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int agentToEdit;
    
    private String storedLastName;
    
    public EditAgentLastName(int agentToEdit, String newLastName) {
        this.agentToEdit = agentToEdit;
        storedLastName = newLastName;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveAgentIDMap().get(agentToEdit).setLastName(storedLastName);
    }

    @Override
    public void undo() {
        
    }
    
}
