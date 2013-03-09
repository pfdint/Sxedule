package sxedule.shared.command;

import sxedule.shared.Timeline;

public class EditAgentUniqueTitle implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int agentToEdit;
    
    private String storedUniqueTitle;
    
    public EditAgentUniqueTitle(int agentToEdit, String newUniqueTitle) {
        this.agentToEdit = agentToEdit;
        storedUniqueTitle = newUniqueTitle;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveAgentIDMap().get(agentToEdit).setUniqueTitle(storedUniqueTitle);
    }

    @Override
    public void undo() {
        
    }
    
}
