package sxedule.client;

import java.util.Map;
import java.util.Set;
import sxedule.shared.AbstractActivity;
import sxedule.shared.AbstractAgent;

public class DrawableAgent extends AbstractAgent {
    
    public DrawableAgent() {
        super();
    }
    
//.dP"Y8 888888 888888 888888 888888 88""Yb .dP"Y8 
//`Ybo." 88__     88     88   88__   88__dP `Ybo." 
//o.`Y8b 88""     88     88   88""   88"Yb  o.`Y8b 
//8bodP' 888888   88     88   888888 88  Yb 8bodP' 
    
    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setLastName(String lastName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setUniqueTitle(String uniqueTitle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFlags(Set<String> flags) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToFlags(String flagToAdd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPreferenceMap(Map<String, Integer> preferenceMap) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToPreferenceMap(String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPersonalTimeline(Set<AbstractActivity> personalTimeline) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToPersonalTimeline(AbstractActivity activityToAdd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
//88""Yb 888888 888888 88""Yb 88 888888 Yb    dP 888888 88""Yb .dP"Y8 
//88__dP 88__     88   88__dP 88 88__    Yb  dP  88__   88__dP `Ybo." 
//88"Yb  88""     88   88"Yb  88 88""     YbdP   88""   88"Yb  o.`Y8b 
//88  Yb 888888   88   88  Yb 88 888888    YP    888888 88  Yb 8bodP' 
    
}
