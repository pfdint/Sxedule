package sxedule.client;

import javax.swing.JFrame;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;
import sxedule.shared.CommandQueue;
import sxedule.shared.CommandQueueThread;
import sxedule.shared.Timeline;

class GUIFactory {
    
    void buildGUI() {
        
        Timeline timeline = new Timeline();
        
        CommandQueue commandQueue = new CommandQueue(timeline, false);
        
            new CommandQueueThread(commandQueue).start();
        
        AsynchronousNetworkCommunicator networkCommunicator = new AsynchronousNetworkCommunicator(SxeduleClientMain.hostname, SxeduleClientMain.portNumber);
        
            commandQueue.addConnection(networkCommunicator);
        
            networkCommunicator.initializeConnection();
            
                //This is provisional until there is user input for the desired timeline.
                networkCommunicator.output("0");
        
        //Activity Panel
        ActivityPanel activityPanel = new ActivityPanel(timeline);
        ActivityPanelController activityPanelController = new ActivityPanelController(timeline, networkCommunicator, activityPanel);
        ActivityPanelListener activityPanelListener = new ActivityPanelListener(activityPanelController);
            activityPanel.addMouseListener(activityPanelListener);
            activityPanel.addMouseMotionListener(activityPanelListener);
            activityPanel.addMouseWheelListener(activityPanelListener);
            activityPanel.addKeyListener(activityPanelListener);
            
            commandQueue.attach(activityPanel);
            
//        //Agent Panel
//        AgentPanel agentPanel = new AgentPanel(timeline);
//        AgentPanelController agentPanelController = new AgentPanelController(timeline, networkCommunicator, agentPanel);
//        AgentPanelListener agentPanelListener = new AgentPanelListener(agentPanelController);
//            agentPanel.addMouseListener(agentPanelListener);
//            agentPanel.addMouseMotionListener(agentPanelListener);
//            agentPanel.addMouseWheelListener(agentPanelListener);
//            agentPanel.addKeyListener(agentPanelListener);
//            
//            commandQueue.attach(agentPanel);
//            
//        //Info Panel
//        InfoPanel infoPanel = new InfoPanel(timeline);
//        InfoPanelController infoPanelController = new InfoPanelController(timeline, networkCommunicator, infoPanel);
//        InfoPanelListener infoPanelListener = new InfoPanelListener(infoPanelController);
//            infoPanel.addMouseListener(infoPanelListener);
//            infoPanel.addMouseMotionListener(infoPanelListener);
//            infoPanel.addMouseWheelListener(infoPanelListener);
//            infoPanel.addKeyListener(infoPanelListener);
//            
//            commandQueue.attach(infoPanel);
            
        JFrame topFrame = new JFrame();
        topFrame.setName("Sxedule version " + SxeduleClientMain.VERSION_STRING);
        topFrame.setSize(1000, 1000);
        topFrame.setLocationRelativeTo(null);
        topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        topFrame.add(activityPanel);
//        topFrame.add(agentPanel);
//        topFrame.add(infoPanel);
        
        topFrame.pack();
        topFrame.setVisible(true);
                
    }
    
}
