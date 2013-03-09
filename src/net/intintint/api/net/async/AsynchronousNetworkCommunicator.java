package net.intintint.api.net.async;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsynchronousNetworkCommunicator implements AsynchronousCommunicator {
    
    private Receiver receiver;
    
    private Sender sender;
    
    private String hostname;
    
    private int portNumber;
    
    private Socket socket;
    
    private AcceptsInputObject inputObjectAcceptor;

    public AsynchronousNetworkCommunicator(Socket socket) {
        
        this.socket = socket;
        this.hostname = socket.getLocalAddress().getHostName();
        this.portNumber = socket.getLocalPort();
        
    }
    
    public AsynchronousNetworkCommunicator(String hostname, int portNumber) {
        
        this.hostname = hostname;
        this.portNumber = portNumber;
        
    }
    
    @Override
    public void initializeConnection() {
        
        if (socket == null) {
            try {
                socket = new Socket(hostname, portNumber);
            } catch (UnknownHostException ex) {
                Logger.getLogger(AsynchronousNetworkCommunicator.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Unknown host: " + hostname);
            } catch (IOException ex) {
                Logger.getLogger(AsynchronousNetworkCommunicator.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Unable to obtain IO for connection to host: " + hostname);
            }
        }
        
        receiver = new Receiver(inputObjectAcceptor, socket);
        sender = new Sender(socket);
        
        receiver.start();
        sender.start();
        
    }
    
    @Override
    public void output(Object output) {
        
        try {
            sender.output(output);
        } catch (IOException ex) {
            Logger.getLogger(AsynchronousNetworkCommunicator.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ObjectOutputStream failed to open or something.");
        }
        
    }
    
    @Override
    public void setInputObjectAcceptor(AcceptsInputObject inputObjectAcceptor) {
        if (receiver == null) {
            this.inputObjectAcceptor = inputObjectAcceptor;
        } else {
            receiver.setInputObjectAcceptor(inputObjectAcceptor);
        }
    }
    
    @Override
    public void terminateConnection() {
        
        sender.interrupt();
        receiver.interrupt();
        
        sender = null;
        receiver = null;
        
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(AsynchronousNetworkCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String returnConnectionInfo() {
        return hostname + ":" + portNumber;
    }
    
}