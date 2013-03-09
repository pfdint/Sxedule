package sxedule.client;

public class SxeduleClientMain {
    
    public static final String VERSION_STRING = "0:1";
    
    public static final String hostname = "localhost";
    
    public static final int portNumber = 25006;
    
    public static final int MASTER_WIDTH = 1200;
    
    public static final int MASTER_HEIGHT = 700;

    public static void main(String[] args) {
        new GUIFactory().buildGUI();
    }
    
}
