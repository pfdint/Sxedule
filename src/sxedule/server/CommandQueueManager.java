package sxedule.server;

import java.util.LinkedHashSet;
import java.util.Set;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;
import sxedule.shared.CommandQueue;
import sxedule.shared.CommandQueueThread;
import sxedule.shared.Timeline;

public class CommandQueueManager {
    
    private Set<CommandQueue> commandQueueSet;
    
    public CommandQueueManager() {
        commandQueueSet = new LinkedHashSet<>();
    }
    
    public void connect(AsynchronousNetworkCommunicator networkCommunicator, int queueNumber) {
        
        if (queueNumber < commandQueueSet.size()) {
            CommandQueue targetCommandQueue = null;
                for (int index = 0; index < queueNumber; index++) {
                    targetCommandQueue = commandQueueSet.iterator().next();
                }
                targetCommandQueue.addConnection(networkCommunicator);
            } else if (queueNumber == commandQueueSet.size()) {
                createNewCommandQueue(networkCommunicator);
            } else {
                networkCommunicator.output("TIMELINE_NUMBER_INVALID");
            }
        
    }
    
    private void createNewCommandQueue(AsynchronousNetworkCommunicator networkCommunicator) {
        Timeline timeline = new Timeline();
        CommandQueue newCommandQueue = new CommandQueue(timeline, true);
        new CommandQueueThread(newCommandQueue).start();
        newCommandQueue.addConnection(networkCommunicator);
        commandQueueSet.add(newCommandQueue);
    }
    
}
