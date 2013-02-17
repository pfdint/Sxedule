package sxedule.shared;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractAgent {
    
    protected String title;
    protected String firstName;
    protected String lastName;
    protected String uniqueTitle;
    
    protected Set<String> flags;
    
    protected Map<String, Integer> preferenceMap;
    
    protected Set<AbstractActivity> personalTimeline;
    
    public AbstractAgent() {
        flags = new HashSet<>();
        preferenceMap = new HashMap<>();
        personalTimeline = new HashSet<>();
    }

    public abstract void setTitle(String title);

    public abstract void setFirstName(String firstName);

    public abstract void setLastName(String lastName);

    public abstract void setUniqueTitle(String uniqueTitle);

    public abstract void setFlags(Set<String> flags);
    
    public abstract void addToFlags(String flagToAdd);
    
    public abstract void setPreferenceMap(Map<String, Integer> preferenceMap);
    
    public abstract void addToPreferenceMap(String value);
    
    public abstract void setPersonalTimeline(Set<AbstractActivity> personalTimeline);
    
    public abstract void addToPersonalTimeline(AbstractActivity activityToAdd);
    
}
