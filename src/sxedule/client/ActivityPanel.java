package sxedule.client;

import java.awt.Color;
import javax.swing.JPanel;

class ActivityPanel extends JPanel {
    
    private long startTime;
    
    private long endTime;
    
    ActivityPanel() {
        this.setLocation(0, 0);
        this.setSize(900, 350);
        this.setBackground(Color.red);
        this.setDoubleBuffered(true);
    }
    
}
