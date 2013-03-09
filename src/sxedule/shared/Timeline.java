package sxedule.shared; 

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Timeline {
    
// _  _              __               
//|_|(_| _ __ _|_   |_  o  _  |  _| _ 
//| |__|(/_| | |_   |   | (/_ | (_|_> 
    
    private Set<Agent> agents;
    
    private Map<Integer, Agent> agentIDMap;
    
    private transient int agentIDLabeler = 0;
    
// _                          __               
//|_| _ _|_ o     o _|_ \/   |_  o  _  |  _| _ 
//| |(_  |_ | \_/ |  |_ /    |   | (/_ | (_|_> 
    
    private Set<Activity> activities;
    
    private Map<Integer, Activity> activityIDMap;
    
    private transient int activityIDLabeler = 0;
    
    
    
//    private HashMap<Integer, String> rowNameTable;
//    
//    private int highestRowNumber = 0;
    
// __                              
///   _ __  _ _|_ __    _ _|_ _  __
//\__(_)| |_>  |_ | |_|(_  |_(_) | 
    
    public Timeline() {
        agents = new LinkedHashSet<>();
        agentIDMap = new HashMap<>();
        activities = new LinkedHashSet<>();
        activityIDMap = new HashMap<>();
    }
    
//   db     dP""b8 888888 88b 88 888888     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//  dPYb   dP   `" 88__   88Yb88   88       88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
// dP__Yb  Yb  "88 88""   88 Y88   88       88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//dP""""Yb  YboodP 888888 88  Y8   88       88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP'
    
    public Set<Agent> retrieveAgents() {
        return agents;
    }

    public void setAgents(Set<Agent> agents) {
        this.agents = agents;
    }

    public Map<Integer, Agent> retrieveAgentIDMap() {
        return agentIDMap;
    }

    public void setAgentIDMap(Map<Integer, Agent> agentIDMap) {
        this.agentIDMap = agentIDMap;
    }

    public int returnAgentIDLabeler() {
        return agentIDLabeler;
    }

    public void setAgentIDLabeler(int agentIDLabeler) {
        this.agentIDLabeler = agentIDLabeler;
    }
    
    public void incrementAgentIDLabeler() {
        agentIDLabeler++;
    }
    
//   db     dP""b8 888888 88 Yb    dP 88 888888 Yb  dP     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//  dPYb   dP   `"   88   88  Yb  dP  88   88    YbdP      88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
// dP__Yb  Yb        88   88   YbdP   88   88     8P       88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//dP""""Yb  YboodP   88   88    YP    88   88    dP        88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP' 
    
    public Set<Activity> retrieveActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Map<Integer, Activity> retrieveActivityIDMap() {
        return activityIDMap;
    }

    public void setActivityIDMap(Map<Integer, Activity> activityIDMap) {
        this.activityIDMap = activityIDMap;
    }

    public int returnActivityIDLabeler() {
        return activityIDLabeler;
    }

    public void setActivityIDLabeler(int activityIDLabeler) {
        this.activityIDLabeler = activityIDLabeler;
    }
    
    public void incrementActivityIDLabeler() {
        activityIDLabeler++;
    }
    
//    public synchronized void nameRow(int row, String name) {
//        rowNameTable.put(row, name);
//    }
    
}