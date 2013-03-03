package sxedule.client;

import java.util.Scanner;
import net.intintint.api.net.async.AcceptsInputObject;

class ClientParser implements AcceptsInputObject {
    
    private ClientTimeline clientTimeline;
    
    ClientParser(ClientTimeline clientTimeline) {
        this.clientTimeline = clientTimeline;
    }
    
    @Override
    public void acceptInputObject(Object inputObject) {
        
        if (inputObject instanceof String) {
            System.out.println("Client: received command: " + inputObject);
            parseCommand((String)inputObject);
        } else {
            parseCommand((String)inputObject);
        }
        
    }
    
    private void parseCommand(String inputLine) {
        
        Scanner scanner = new Scanner(inputLine);
        
        while (scanner.hasNext()) {
            
            switch (scanner.next()) {
                case "Agent":
                case "AGENT":
                case "agent":
                    if (scanner.hasNext()) {
                        switch (scanner.next()) {
                            case "Add":
                            case "ADD":
                            case "add":
                                clientTimeline.addAgent();
                                break;
                                
                            case "Edit":
                            case "EDIT":
                            case "edit":
                                if (scanner.hasNextInt()) {
                                    int agentID = scanner.nextInt();
                                    if (scanner.hasNext()) {
                                        scanner.useDelimiter("\n");
                                        clientTimeline.editAgent(agentID, scanner.next());
                                    }
                                }
                                break;
                                
                            case "Delete":
                            case "DELETE":
                            case "delete":
                                if (scanner.hasNextInt()) {
                                    clientTimeline.deleteAgent(scanner.nextInt());
                                }
                                break;
                                
                        }
                    }
                    break;
                    
                    
                case "Activity":
                case "ACTIVITY":
                case "activity":
                    if (scanner.hasNext()) {
                        switch (scanner.next()) {
                            case "add":
                                clientTimeline.addActivity();
                                break;
                                
                            case "edit":
                                if (scanner.hasNextInt()) {
                                    int activityID = scanner.nextInt();
                                    if (scanner.hasNext()) {
                                        scanner.useDelimiter("\n");
                                        clientTimeline.editActivity(activityID, scanner.next());
                                    }
                                }
                                break;
                                
                            case "delete":
                                if (scanner.hasNextInt()) {
                                    clientTimeline.deleteActivity(scanner.nextInt());
                                }
                                break;
                                
                        }
                    }
                    break;
                    
                    
                case "Row":
                case "ROW":
                case "row":
                    if (scanner.hasNextInt()) {
                        int rowID = scanner.nextInt();
                        if (scanner.hasNext()) {
//                            clientTimeline.nameRow(rowID, scanner.next());
                        }
                    }
                    
                    
            }
            
        }
        
    }
    
}
