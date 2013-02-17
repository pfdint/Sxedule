package sxedule.client;

import net.intintint.api.net.async.AcceptsInputObject;

class ClientParser implements AcceptsInputObject {
    
    private ClientTimeline clientTimeline;
    
    ClientParser(ClientTimeline clientTimeline) {
        this.clientTimeline = clientTimeline;
    }
    
    @Override
    public void acceptInputObject(Object inputObject) {
        System.out.println(inputObject);
    }
    
}
