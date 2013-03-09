package sxedule.shared.command;

import java.io.Serializable;
import sxedule.shared.Timeline;

public interface TimelineCommand extends Serializable {
    
    void setTarget(Timeline timeline);
    
    void execute();
    
    void undo();
    
}
