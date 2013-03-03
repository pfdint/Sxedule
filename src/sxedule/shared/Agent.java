package sxedule.shared; 

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agent implements Serializable { 
    
    private String title;
    private String firstName;
    private String lastName;
    private String uniqueTitle;
    
    private Set<String> flags;
    
    private Map<String, Integer> preferenceMap;
    
    private Set<Activity> personalTimeline;
    
    public Agent() {
        flags = new HashSet<>();
        preferenceMap = new HashMap<>();
        personalTimeline = new HashSet<>();
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
    
    public void setFlags(Set<String> flags) {
        this.flags = flags;
    }
    
    public void addToFlags(String flagToAdd) {
        flags.add(flagToAdd);
    }

    public Map<String, Integer> retrievePreferenceMap() {
        return preferenceMap;
    }

    public void setPreferenceMap(Map<String, Integer> preferenceMap) {
        this.preferenceMap = preferenceMap;
    }
    
    public void addToPreferenceMap(String value) {
        String activityName = value.substring(0, value.indexOf(":"));
        int depth = Integer.parseInt(value.substring(value.indexOf(":") + 1));
        preferenceMap.put(activityName, depth);
    }

    public void setPersonalTimeline(Set<Activity> personalTimeline) {
        this.personalTimeline = personalTimeline;
    }
    
    public void addToPersonalTimeline(Activity activityToAdd) {
        personalTimeline.add(activityToAdd);
    }
    
}