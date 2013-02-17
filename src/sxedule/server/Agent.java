package sxedule.server; 

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import sxedule.shared.AbstractActivity;
import sxedule.shared.AbstractAgent;

public class Agent extends AbstractAgent implements Serializable { 
    
    public Agent() {
        super();
    }
    
//.dP"Y8 888888 888888 888888 888888 88""Yb .dP"Y8 
//`Ybo." 88__     88     88   88__   88__dP `Ybo." 
//o.`Y8b 88""     88     88   88""   88"Yb  o.`Y8b 
//8bodP' 888888   88     88   888888 88  Yb 8bodP' 
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public void setUniqueTitle(String uniqueTitle) {
        this.uniqueTitle = uniqueTitle;
    }
    
    @Override
    public void setFlags(Set<String> flags) {
        this.flags = flags;
    }
    
    @Override
    public void addToFlags(String flagToAdd) {
        flags.add(flagToAdd);
    }

    public Map<String, Integer> retrievePreferenceMap() {
        return preferenceMap;
    }

    @Override
    public void setPreferenceMap(Map<String, Integer> preferenceMap) {
        this.preferenceMap = preferenceMap;
    }
    
    @Override
    public void addToPreferenceMap(String value) {
        String activityName = value.substring(0, value.indexOf(":"));
        int depth = Integer.parseInt(value.substring(value.indexOf(":") + 1));
        preferenceMap.put(activityName, depth);
    }

    @Override
    public void setPersonalTimeline(Set<AbstractActivity> personalTimeline) {
        this.personalTimeline = personalTimeline;
    }
    
    @Override
    public void addToPersonalTimeline(AbstractActivity activityToAdd) {
        personalTimeline.add(activityToAdd);
    }
    
}