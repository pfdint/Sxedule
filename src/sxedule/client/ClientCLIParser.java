package sxedule.client;

import net.intintint.api.net.async.AcceptsInputObject;

public class ClientCLIParser implements AcceptsInputObject {

    @Override
    public void acceptInputObject(Object inputObject) {
        
        if (inputObject instanceof String) {
            System.out.println((String)inputObject);
        } else {
            System.out.println("Received object: " + inputObject);
        }
        
    }
    
}
