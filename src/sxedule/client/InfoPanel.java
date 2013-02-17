package sxedule.client;

import java.awt.Color;
import javax.swing.JPanel;

class InfoPanel extends JPanel {
    
    InfoPanel() {
        this.setLocation(900, 0);
        this.setSize(300, 700);
        this.setBackground(Color.yellow);
        this.setDoubleBuffered(true);
    }
    
}
