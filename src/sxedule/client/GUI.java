package sxedule.client;

import javax.swing.JFrame;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

class GUI {
    
    private AsynchronousNetworkCommunicator networkCommunicator;
    
    private ClientTimeline clientTimeline;
    
    private JFrame topFrame;
    
    private ActivityPanel activityPanel;
    
    private AgentPanel agentPanel;
    
    private InfoPanel infoPanel;
    
    private ActivityPanelListener activityPanelListener;
    
    private AgentPanelListener agentPanelListener;
    
    private InfoPanelListener infoPanelListener;
    
    GUI() {
        
        networkCommunicator = new AsynchronousNetworkCommunicator("localhost", 25006);
        networkCommunicator.setInputObjectAcceptor(new ClientParser(clientTimeline));
        networkCommunicator.initializeConnection();
        
        topFrame = new JFrame();
        topFrame.setName("Sxedule");
        topFrame.setLocation(200, 200);
        topFrame.setSize(1200, 700);
        topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        activityPanel = new ActivityPanel();
        agentPanel = new AgentPanel();
        infoPanel = new InfoPanel();
        
        activityPanelListener = new ActivityPanelListener(networkCommunicator, activityPanel);
        agentPanelListener = new AgentPanelListener(networkCommunicator, agentPanel);
        infoPanelListener = new InfoPanelListener(networkCommunicator, infoPanel);
        
        activityPanel.addMouseListener(activityPanelListener);
        agentPanel.addMouseListener(agentPanelListener);
        infoPanel.addMouseListener(infoPanelListener);
        
        activityPanel.addMouseMotionListener(activityPanelListener);
        agentPanel.addMouseMotionListener(agentPanelListener);
        infoPanel.addMouseMotionListener(infoPanelListener);
        
        activityPanel.addMouseWheelListener(activityPanelListener);
        agentPanel.addMouseWheelListener(agentPanelListener);
        infoPanel.addMouseWheelListener(infoPanelListener);
        
        activityPanel.addKeyListener(activityPanelListener);
        agentPanel.addKeyListener(agentPanelListener);
        infoPanel.addKeyListener(infoPanelListener);
        
        topFrame.add(activityPanel);
        topFrame.add(agentPanel);
        topFrame.add(infoPanel);
        
        topFrame.setVisible(true);
        
    }
    
}
