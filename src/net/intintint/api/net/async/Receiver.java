package net.intintint.api.net.async;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Receiver extends Thread {
        
    private InputStream inputStream;
    
    private AcceptsInputObject inputObjectAcceptor;
    
    Receiver(AcceptsInputObject inputStreamAcceptor, Socket socket) {
        
        this.inputObjectAcceptor = inputStreamAcceptor;
        
        try {
            inputStream = socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object inputObject;

            while ((inputObject = objectInputStream.readObject()) != null) {
                inputObjectAcceptor.acceptInputObject(inputObject);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void setInputObjectAcceptor(AcceptsInputObject inputObjectAcceptor) {
        this.inputObjectAcceptor = inputObjectAcceptor;
    }
    
}