package sxedule.client; 

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class DrawableAgent extends JComponent { 
    
    private String title;
    private String firstName;
    private String lastName;
    private String uniqueTitle;
    
    public DrawableAgent() {
        
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        
        Graphics2D graphics2D = (Graphics2D)graphics;
        
    }
    
//.dP"Y8 888888 888888 888888 888888 88""Yb .dP"Y8 
//`Ybo." 88__     88     88   88__   88__dP `Ybo." 
//o.`Y8b 88""     88     88   88""   88"Yb  o.`Y8b 
//8bodP' 888888   88     88   888888 88  Yb 8bodP' 

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUniqueTitle(String uniqueTitle) {
        this.uniqueTitle = uniqueTitle;
    }
    
    
}