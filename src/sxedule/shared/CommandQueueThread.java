package sxedule.shared;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandQueueThread extends Thread {
    
    private CommandQueue commandQueue;
    
    public CommandQueueThread(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }
    
    @Override
    public void run() {
        while (true) {
            commandQueue.executeNextInQueue();
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(CommandQueueThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
