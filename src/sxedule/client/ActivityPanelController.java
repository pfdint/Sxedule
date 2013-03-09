package sxedule.client;

import java.util.LinkedHashSet;
import java.util.Set;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;
import sxedule.shared.Timeline;
import sxedule.shared.command.AddActivity;
import sxedule.shared.command.EditActivityEndTime;
import sxedule.shared.command.EditActivityName;
import sxedule.shared.command.EditActivityStartTime;
import sxedule.shared.command.TimelineCommand;

class ActivityPanelController {
    
    private Timeline timeline;
    
    private AsynchronousNetworkCommunicator networkCommunicator;
    
    private ActivityPanel activityPanel;
    
    ActivityPanelController(Timeline timeline, AsynchronousNetworkCommunicator networkCommunicator, ActivityPanel activityPanel) {
        this.timeline = timeline;
        this.networkCommunicator = networkCommunicator;
        this.activityPanel = activityPanel;
    }
    
    void requestNewActivity(int eventX) {
        int activityID = timeline.returnActivityIDLabeler();
        long startTime = computeTime(eventX);
        long endTime = startTime + computeDefaultDuration();
        Set<TimelineCommand> commandMacro = new LinkedHashSet<>();
        commandMacro.add(new AddActivity());
        commandMacro.add(new EditActivityStartTime(activityID, startTime));
        commandMacro.add(new EditActivityEndTime(activityID, endTime));
        commandMacro.add(new EditActivityName(activityID, "Activity" + activityID));
        networkCommunicator.output(commandMacro);
    }
    
    private long computeTime(int eventX) {
        return (long) (eventX * activityPanel.returnMinutesPerPixel() + activityPanel.returnStartTime());
    }
    
    private long computeDefaultDuration() {
        return (long) ((double)(activityPanel.getWidth() / 6) * activityPanel.returnMinutesPerPixel());
    }
    
}
