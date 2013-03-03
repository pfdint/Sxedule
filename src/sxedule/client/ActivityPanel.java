package sxedule.client;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import sxedule.shared.Activity;

class ActivityPanel extends JPanel {
    
    private ClientTimeline clientTimeline;
    
    private int originalWidth = 900;
    
    private int originalHeight = 350;
    
    private long startTime = 0;
    
    private long endTime = 0;
    
    private double minutesPerPixel = 60/100;
    
    private Set<DrawableActivity> visibleActivities;
    
    ActivityPanel(ClientTimeline clientTimeline) {
        this.clientTimeline = clientTimeline;
        
        visibleActivities = new HashSet<>();
        this.setLocation(0, 0);
        this.setSize(originalWidth, originalHeight);
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
    }
    
    void addLatestActivity() {
        Activity latestActivity = clientTimeline.retrieveActivityIDMap().get(returnNewestActivityID());
        int xPos = computePixelPosition(latestActivity.returnStartTime());
        int yPos = 0;
        int width = getWidth()/6;
        int height = 50;
        DrawableActivity newDrawableActivity = new DrawableActivity();
        newDrawableActivity.setBounds(xPos, yPos, width, height);
        add(newDrawableActivity);
        visibleActivities.add(newDrawableActivity);
        repaint();
    }
    
    int computePixelPosition(long time) {
        return (int) ((time - startTime) / minutesPerPixel);
    }
    
    long computeTime(int eventX) {
        return (long) (eventX * minutesPerPixel + startTime);
    }
    
    long computeDefaultDuration() {
        return (long) ((originalWidth / 6) * minutesPerPixel);
    }
    
    int returnNewestActivityID() {
        return clientTimeline.returnLatestActivityID();
    }
    
}
