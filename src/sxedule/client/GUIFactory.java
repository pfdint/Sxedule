package sxedule.client;

import javax.swing.JFrame;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

class GUIFactory {
    
    void buildGUI() {
        
        ClientTimeline clientTimeline = new ClientTimeline();
        ClientParser clientParser = new ClientParser(clientTimeline);
        
        AsynchronousNetworkCommunicator networkCommunicator = new AsynchronousNetworkCommunicator(SxeduleClientMain.hostname, SxeduleClientMain.portNumber);
        networkCommunicator.setInputObjectAcceptor(clientParser);
        networkCommunicator.initializeConnection();
        
        //This is where we specify the timeline to connect to. Its placement here is provisional.
        networkCommunicator.output("0");
        
        ActivityPanel activityPanel = new ActivityPanel(clientTimeline);
//        AgentPanel agentPanel = new AgentPanel(clientTimeline);
//        InfoPanel infoPanel = new InfoPanel(clientTimeline);
        
        ActivityPanelListener activityPanelListener = new ActivityPanelListener(networkCommunicator, activityPanel);
//        AgentPanelListener agentPanelListener = new AgentPanelListener(networkCommunicator, agentPanel);
//        InfoPanelListener infoPanelListener = new InfoPanelListener(networkCommunicator, infoPanel);
        
        activityPanel.addMouseListener(activityPanelListener);
//        agentPanel.addMouseListener(agentPanelListener);
//        infoPanel.addMouseListener(infoPanelListener);
        
        activityPanel.addMouseMotionListener(activityPanelListener);
//        agentPanel.addMouseMotionListener(agentPanelListener);
//        infoPanel.addMouseMotionListener(infoPanelListener);
        
        activityPanel.addMouseWheelListener(activityPanelListener);
//        agentPanel.addMouseWheelListener(agentPanelListener);
//        infoPanel.addMouseWheelListener(infoPanelListener);
        
        activityPanel.addKeyListener(activityPanelListener);
//        agentPanel.addKeyListener(agentPanelListener);
//        infoPanel.addKeyListener(infoPanelListener);
        
        JFrame topFrame = new JFrame();
        topFrame.setName("Sxedule version " + SxeduleClientMain.VERSION_STRING);
        topFrame.setLocation(100, 100);
        topFrame.setSize(SxeduleClientMain.MASTER_WIDTH, SxeduleClientMain.MASTER_HEIGHT);
        topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        topFrame.add(activityPanel);
//        topFrame.add(agentPanel);
//        topFrame.add(infoPanel);
        
        topFrame.setVisible(true);
        
    }
    
}
