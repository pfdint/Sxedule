package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditAgentTitle implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int agentToEdit;
    
    private String storedTitle;
    
    public EditAgentTitle(int agentToEdit, String newTitle) {
        this.agentToEdit = agentToEdit;
        storedTitle = newTitle;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveAgentIDMap().get(agentToEdit).setTitle(storedTitle);
    }

    @Override
    public void undo() {
        
    }
    
}
