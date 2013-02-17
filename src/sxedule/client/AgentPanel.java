package sxedule.client;

import java.awt.Color;
import javax.swing.JPanel;

class AgentPanel extends JPanel {
    
    AgentPanel() {
        this.setLocation(0, 350);
        this.setSize(900, 350);
        this.setBackground(Color.orange);
        this.setDoubleBuffered(true);
    }
    
}
