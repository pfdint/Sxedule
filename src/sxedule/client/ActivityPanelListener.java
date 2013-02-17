package sxedule.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.MouseInputListener;

class ActivityPanelListener implements MouseInputListener, MouseWheelListener, KeyListener {
    
    private GUI gui;
    
    ActivityPanelListener(GUI gui) {
        this.gui = gui;
    }
    
//               
//|V| _     _  _ 
//| |(_)|_|_> (/_
    
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("Mouse clicked in Activity Panel!");
        gui.retrieveNetworkCommunicator().output("activity add");
        try {
            Thread.sleep(SxeduleClientMain.MAX_PING);
        } catch (InterruptedException ex) {
            Logger.getLogger(ActivityPanelListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        
    }
    
//                        
//|/  _  \/|_  _  _  __ _|
//|\ (/_ / |_)(_)(_| | (_|
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
