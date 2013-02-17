package sxedule.server;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import net.intintint.api.net.async.AcceptsInputObject;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

class Lobby implements AcceptsInputObject {
    
    private AsynchronousNetworkCommunicator communicator;
    
    Lobby(AsynchronousNetworkCommunicator connectionToAdd) {
        communicator = connectionToAdd;
        communicator.setInputObjectAcceptor(this);
        communicator.initializeConnection();
        welcome();
    }
    
    @Override
    public void acceptInputObject(Object inputObject) {
        parseTimelineRequest((String)inputObject);
    }
    
    private void parseTimelineRequest(String input) {
        
        Scanner scanner = new Scanner(input);
        
        MasterTimeline targetTimeline = null;
        Set<MasterTimeline> serverTimelineSet = SxeduleServerMain.retrieveTimelineSet();
        Iterator<MasterTimeline> iterator = serverTimelineSet.iterator();
        int sizeOfSet = serverTimelineSet.size();
        
        if (scanner.hasNextInt()) {
            
            int targetTimelineNumber = scanner.nextInt();
            
            if (targetTimelineNumber < sizeOfSet) {
                for (int index = 0; index < targetTimelineNumber; index++) {
                    targetTimeline = iterator.next();
                }
                usher(targetTimeline, targetTimelineNumber);
            } else if (targetTimelineNumber == sizeOfSet) {
                usher(SxeduleServerMain.createNewTimeline(), targetTimelineNumber);
            } else {
                communicator.output("That is not a valid Timeline number.");
            }
            
        } else {
            communicator.output("Specify a timeline to connect to or a number one greater than the current number of timelines.");
        }
        
    }
    
    private void welcome() {
        communicator.output("Welcome to the server! Specify a timeline to connect to or nothing will happen.");
    }
    
    private void usher(MasterTimeline targetTimeline, int timelineNumber) {
        communicator.output("Now connecting to Timeline " + timelineNumber);
        targetTimeline.addConnection(communicator);
    }
    
}
