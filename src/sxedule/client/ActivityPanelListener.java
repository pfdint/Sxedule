package sxedule.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputListener;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

class ActivityPanelListener implements MouseInputListener, MouseWheelListener, KeyListener {
    
    private AsynchronousNetworkCommunicator networkCommunicator;
    
    private ActivityPanel activityPanel;
    
    ActivityPanelListener(AsynchronousNetworkCommunicator networkCommunicator, ActivityPanel activityPanel) {
        this.networkCommunicator = networkCommunicator;
        this.activityPanel = activityPanel;
    }
    
//               
//|V| _     _  _ 
//| |(_)|_|_> (/_
    
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("Mouse clicked in Activity Panel!");
        networkCommunicator.output("activity add");
        try {
            Thread.sleep(SxeduleClientMain.MAX_PING);
        } catch (InterruptedException ex) {
//            Logger.getLogger(ActivityPanelListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        int activityID = activityPanel.returnNewestActivityID();
        long startTime = activityPanel.computeTime(me.getX());
        long duration = activityPanel.computeDefaultDuration();
        networkCommunicator.output("activity edit " + activityID + " startTime\"" + startTime + "\"");
        networkCommunicator.output("activity edit " + activityID + " endTime\"" + (startTime + duration) + "\"");
        networkCommunicator.output("activity edit " + activityID + " activityname\"Activity" + activityID + "\"");
        try {
            Thread.sleep(SxeduleClientMain.MAX_PING);
        } catch (InterruptedException ex) {
//            Logger.getLogger(ActivityPanelListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        activityPanel.addLatestActivity();
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
