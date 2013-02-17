package sxedule.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputListener;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

class InfoPanelListener implements MouseInputListener, MouseWheelListener, KeyListener {
    
    private AsynchronousNetworkCommunicator networkCommunicator;
    
    private InfoPanel infoPanel;
    
    InfoPanelListener(AsynchronousNetworkCommunicator networkCommunicator, InfoPanel infoPanel) {
        this.networkCommunicator = networkCommunicator;
        this.infoPanel = infoPanel;
    }
    
//               
//|V| _     _  _ 
//| |(_)|_|_> (/_
    
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("Mouse clicked in Info panel!");
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