package sxedule.client;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import sxedule.shared.Activity;
import sxedule.shared.HasDuration;
import sxedule.shared.Timeline;

class ActivityPanel extends JPanel implements Observer {
    
    private Timeline timeline;
    
    private int originalWidth = 900;
    
    private int originalHeight = 500;
    
    private long startTime = 0;
    
    private long endTime = 1000;
    
    private double minutesPerPixel = .6;
    
    private Set<DrawableActivity> visibleActivities;
    
//    private DrawableActivity pendingActivity;
    
    ActivityPanel(Timeline timeline) {
        this.timeline = timeline;
        
        visibleActivities = new HashSet<>();
//        this.setLocation(0, 0);
//        this.setSize(originalWidth, originalHeight);
        this.setBounds(0, 0, originalWidth, originalHeight);
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
    }
    
    private void addActivity(DrawableActivity drawableActivityToAdd) {
        // Set its bounds according to the info you find in it
        int xPos = computePixelPosition(drawableActivityToAdd.returnStartTime());
        int yPos = 0;
        int width = computePixelPosition(drawableActivityToAdd.returnEndTime()) - xPos;
        int height = 50;
        drawableActivityToAdd.setBounds(xPos, yPos, width, height);
        add(drawableActivityToAdd);
    }
    
//    void addLatestActivity() {
//        Activity latestActivity = timeline.retrieveActivityIDMap().get(returnNewestActivityID());
//        int xPos = computePixelPosition(latestActivity.returnStartTime());
//        int yPos = 0;
//        int width = getWidth()/6;
//        int height = 50;
//        DrawableActivity newDrawableActivity = new DrawableActivity(latestActivity);
//        newDrawableActivity.setBounds(xPos, yPos, width, height);
//        add(newDrawableActivity);
//        visibleActivities.add(newDrawableActivity);
//        repaint();
//    }
//    
//    void addPendingActivity(int xPos, int yPos) {
//        if (pendingActivity != null) {
//            removePendingActivity();
//        }
//        pendingActivity = new DrawableActivity();
//        pendingActivity.setBounds(xPos - getWidth()/12, yPos - 25, getWidth()/6, 50);
//        add(pendingActivity);
//        repaint();
//    }
//    
//    void removePendingActivity() {
//        remove(pendingActivity);
//        pendingActivity = null;
//    }
    
    @Override
    public void update() {
        // Only have to search through currently displayed activities to remove.
        for (DrawableActivity drawableActivity : visibleActivities) {
            if (!shouldBeVisible(drawableActivity)) {
                visibleActivities.remove(drawableActivity);
                remove(drawableActivity);
            }
        }
        // Now search for activities to add. Have to use all of them.
        for (Activity activityInQuestion : timeline.retrieveActivities()) {
            if (shouldBeVisible(activityInQuestion)) {
                DrawableActivity newDrawableActivity = new DrawableActivity(activityInQuestion);
                if (!visibleActivities.contains(newDrawableActivity)) {
                    visibleActivities.add(newDrawableActivity);
                    addActivity(newDrawableActivity);
                    System.out.print(newDrawableActivity);
                }
            }
        }
        
        repaint();
    }
    
    private boolean shouldBeVisible(HasDuration activity) {
        if (activity.returnEndTime() >= startTime || activity.returnStartTime() <= endTime) {
            return true;
        }
        return false;
    }
    
    private int computePixelPosition(long time) {
        return (int) ((time - startTime) / minutesPerPixel);
    }
    
    double returnMinutesPerPixel() {
        return minutesPerPixel;
    }
    
    long returnStartTime() {
        return startTime;
    }
    
}
