package sxedule.shared.command;

import sxedule.shared.Timeline;

public class DeleteAgent implements TimelineCommand {
    
    private transient Timeline timeline;
    
    private int agentToDelete;
    
    public DeleteAgent(int agentToDelete) {
        this.agentToDelete = agentToDelete;
    }
    
    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        timeline.retrieveAgents().remove(timeline.retrieveAgentIDMap().remove(agentToDelete));
    }

    @Override
    public void undo() {
        
    }
    
}
