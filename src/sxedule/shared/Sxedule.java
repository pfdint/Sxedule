package sxedule.shared;

import sxedule.client.SxeduleClientMain;
import sxedule.server.SxeduleServerMain;

public class Sxedule {

    public static void main(String[] args) {
        
        Thread serverThread = new Thread() {
            @Override
            public void run() {
                SxeduleServerMain.main(null);
            }
        };
       
       Thread clientThread = new Thread() {
           @Override
           public void run() {
               SxeduleClientMain.main(null);
           }
       };
       
       serverThread.start();
       clientThread.start();
        
    }
    
}