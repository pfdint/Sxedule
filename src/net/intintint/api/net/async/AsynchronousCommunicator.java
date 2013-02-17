package net.intintint.api.net.async;

public interface AsynchronousCommunicator {
    
    void initializeConnection();
    
    void output(Object output);
    
    void setInputObjectAcceptor(AcceptsInputObject inputObjectAcceptor);
    
    void terminateConnection();
    
}