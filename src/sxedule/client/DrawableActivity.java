package sxedule.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Set;
import javax.swing.JComponent;
import sxedule.shared.Activity;
import sxedule.shared.Agent;
import sxedule.shared.HasDuration;

class DrawableActivity extends JComponent implements HasDuration {
    
    private long startTime;
    private long endTime;
    
    private String activityName = "Activity name not set";
    
    private int row;
    
    private boolean broadcast;
    private boolean duty;
    
    public static final int RECTANGLE_ROUNDNESS = 10;
    
    private Color activityColor = Color.GRAY;
    private Color activityOutlineColor = Color.BLACK;
    private Color activityTextColor = Color.BLACK;
    
    /** If this constructor is used, then the activity must be a pending activity.
     */
    DrawableActivity() {
        activityColor = Color.CYAN;
        activityOutlineColor = Color.BLUE;
        activityName = "New Activity";
        addMouseListener(new DrawableActivityListener(this));
    }
    
    DrawableActivity(Activity activityToCopy) {
        startTime = activityToCopy.returnStartTime();
        endTime = activityToCopy.returnEndTime();
        if (activityToCopy.returnActivityName() != null) {
            activityName = activityToCopy.returnActivityName();
        }
        row = activityToCopy.returnRow();
        broadcast = activityToCopy.isBroadcast();
        duty = activityToCopy.isDuty();
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        
        super.paintComponent(graphics);
        
        Graphics2D graphics2D = (Graphics2D)graphics;
        
        //First, we set the body color and paint that round rectangle.
        graphics2D.setColor(activityColor);
        graphics2D.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, RECTANGLE_ROUNDNESS, RECTANGLE_ROUNDNESS);
        
        //Second, we set the color of the outline and pain the same round rectangle.
        graphics2D.setColor(activityOutlineColor);
        graphics2D.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, RECTANGLE_ROUNDNESS, RECTANGLE_ROUNDNESS);
        
        //Lastly, draw the Title string in black.
        graphics2D.setColor(activityTextColor);
        graphics2D.drawString(activityName, getWidth()/8, 2*getHeight()/3);
        
    }
    
//.dP"Y8 888888 888888 888888 888888 88""Yb .dP"Y8 
//`Ybo." 88__     88     88   88__   88__dP `Ybo." 
//o.`Y8b 88""     88     88   88""   88"Yb  o.`Y8b 
//8bodP' 888888   88     88   888888 88  Yb 8bodP' 
    
    public void setStartTime(long startTime) {
        
    }

    public void setEndTime(long endTime) {
        
    }

    public void setMinCampers(int minCampers) {
        
    }

    public void setMaxCampers(int maxCampers) {
        
    }

    public void setNeededStaff(int neededStaff) {
        
    }

    public void setMaxStaff(int maxStaff) {
        
    }

    public void setPredeterminedRatio(double predeterminedRatio) {
        
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setStaffPrerequisites(Set<String> staffPrerequisites) {
        
    }

    public void addToStaffPrerequisites(String flagToAdd) {
        
    }

    public void setAssignedStaff(Set<Agent> assignedStaff) {
        
    }

    public void addToAssignedStaff(Agent staffMember) {
        
    }

    public void setRow(int row) {
        
    }

    public void setBroadcast(boolean broadcast) {
        
    }

    public void setDuty(boolean duty) {
        
    }
    
    public void setColor(Color color) {
        activityColor = color;
    }
    
//88""Yb 888888 888888 88""Yb 88 888888 Yb    dP 888888 88""Yb .dP"Y8 
//88__dP 88__     88   88__dP 88 88__    Yb  dP  88__   88__dP `Ybo." 
//88"Yb  88""     88   88"Yb  88 88""     YbdP   88""   88"Yb  o.`Y8b 
//88  Yb 888888   88   88  Yb 88 888888    YP    888888 88  Yb 8bodP' 
    
    public long returnStartTime() {
        return startTime;
    }

    public long returnEndTime() {
        return endTime;
    }

    public String returnActivityName() {
        return activityName;
    }

    public int returnRow() {
        return row;
    }

    public boolean isBroadcast() {
        return broadcast;
    }

    public boolean isDuty() {
        return duty;
    }
    
}
