package sxedule.server; 

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

public class SxeduleServerMain { 
    
    public static final int SERVER_PORT = 25006;
    
    private static Set<MasterTimeline> timelineSet;
    
    private static boolean listening;
    
    public static void main(String[] args) {
        
        timelineSet = new LinkedHashSet<>();
        
        listening = true;
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
        } catch (IOException ex) {
            Logger.getLogger(SxeduleServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (listening) {
            
            AsynchronousNetworkCommunicator newConnection = null;
            try {
                newConnection = new AsynchronousNetworkCommunicator(serverSocket.accept());
            } catch (IOException ex) {
                Logger.getLogger(SxeduleServerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            new Lobby(newConnection);
            
        }
        
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(SxeduleServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    static void stop() {
        listening = false;
    }
    
    static MasterTimeline createNewTimeline() {
        MasterTimeline newTimeline = new MasterTimeline();
        timelineSet.add(newTimeline);
        return newTimeline;
    }
    
    static Set<MasterTimeline> retrieveTimelineSet() {
        return timelineSet;
    }
    
}