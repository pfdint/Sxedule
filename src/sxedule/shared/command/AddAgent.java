package sxedule.shared.command;

import sxedule.shared.Agent;
import sxedule.shared.Timeline;

public class AddAgent implements TimelineCommand {
    
    private transient Timeline timeline;

    @Override
    public void setTarget(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public void execute() {
        Agent createdAgent = new Agent();
        timeline.retrieveAgentIDMap().put(timeline.returnAgentIDLabeler(), createdAgent);
        timeline.incrementAgentIDLabeler();
        timeline.retrieveAgents().add(createdAgent);
    }

    @Override
    public void undo() {
        
    }
    
}
