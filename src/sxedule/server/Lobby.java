package sxedule.server;

import java.util.Scanner;
import net.intintint.api.net.async.AcceptsInputObject;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

class Lobby implements AcceptsInputObject {
    
    private CommandQueueManager commandQueueManager;
    
    private AsynchronousNetworkCommunicator communicator;
    
    Lobby(CommandQueueManager commandQueueManager, AsynchronousNetworkCommunicator connectionToAdd) {
        this.commandQueueManager = commandQueueManager;
        communicator = connectionToAdd;
        communicator.setInputObjectAcceptor(this);
        communicator.initializeConnection();
        communicator.output("CONNECTION_ESTABLISHED");
    }
    
    @Override
    public void acceptInputObject(Object inputObject) {
        parseTimelineRequest((String)inputObject);
    }
    
    private void parseTimelineRequest(String input) {
        
        Scanner scanner = new Scanner(input);
        
        if (scanner.hasNextInt()) {
            commandQueueManager.connect(communicator, scanner.nextInt());
        } else {
            communicator.output("INPUT_NOT_INTEGER");
        }
        
    }
    
}
