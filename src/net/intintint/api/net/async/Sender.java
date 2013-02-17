package net.intintint.api.net.async;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Sender implements Runnable {
        
    private ObjectOutputStream objectOutputStream;

    Sender(Socket socket) {

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        //don't know what to put here
    }
    
    void output(Object output) throws IOException {
        objectOutputStream.writeObject(output);
    }
    
}