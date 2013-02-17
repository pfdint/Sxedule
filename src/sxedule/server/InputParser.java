package sxedule.server;

import java.util.Scanner;
import net.intintint.api.net.async.AcceptsInputObject;

class InputParser implements AcceptsInputObject {
    
    MasterTimeline parentTimeline;
    
    InputParser(MasterTimeline parentMasterTimeline) {
        this.parentTimeline = parentMasterTimeline;
    }
    
    /** Invocation of this method implies there is something to be read.
     */
    @Override
    public void acceptInputObject(Object inputObject) {
        
        if (inputObject instanceof String) {
            parseRequest((String)inputObject);
        } else {
            parseRequest((String)inputObject);
        }
        
    }
    
    private void parseRequest(String inputLine) {
        
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
                                parentTimeline.addAgent();
                                break;
                                
                            case "Edit":
                            case "EDIT":
                            case "edit":
                                if (scanner.hasNextInt()) {
                                    int agentID = scanner.nextInt();
                                    if (scanner.hasNext()) {
                                        scanner.useDelimiter("\n");
                                        parentTimeline.editAgent(agentID, scanner.next());
                                    } else {
                                        parentTimeline.broadcastMessage("Must provide fields to edit.");
                                    }
                                } else {
                                    parentTimeline.broadcastMessage("Must provide and agent ID to edit.");
                                }
                                break;
                                
                            case "Delete":
                            case "DELETE":
                            case "delete":
                                if (scanner.hasNextInt()) {
                                    parentTimeline.deleteAgent(scanner.nextInt());
                                } else {
                                    parentTimeline.broadcastMessage("Must provide an agent ID to delete.");
                                }
                                break;
                                
                            default:
                                parentTimeline.broadcastMessage("<help statement for agent>");
                                break;
                        }
                    } else {
                        System.out.println("<help statement for agent>");//@todo help statements for agent and activity
                    }
                    break;
                    
                    
                case "Activity":
                case "ACTIVITY":
                case "activity":
                    if (scanner.hasNext()) {
                        switch (scanner.next()) {
                            case "add":
                                parentTimeline.addActivity();
                                break;
                                
                            case "edit":
                                if (scanner.hasNextInt()) {
                                    int activityID = scanner.nextInt();
                                    if (scanner.hasNext()) {
                                        scanner.useDelimiter("\n");
                                        parentTimeline.editActivity(activityID, scanner.next());
                                    } else {
                                        parentTimeline.broadcastMessage("Must provide fields to edit.");
                                    }
                                } else {
                                    parentTimeline.broadcastMessage("Must provide and agent ID to edit.");
                                }
                                break;
                                
                            case "delete":
                                if (scanner.hasNextInt()) {
                                    parentTimeline.deleteActivity(scanner.nextInt());
                                } else {
                                    parentTimeline.broadcastMessage("Must provide an agent ID to delete.");
                                }
                                break;
                                
                            default:
                                parentTimeline.broadcastMessage("<help statement for activity>");
                                break;
                        }
                    } else {
                        parentTimeline.broadcastMessage("<help statement for activity>");
                    }
                    break;
                    
                    
                case "Row":
                case "ROW":
                case "row":
                    if (scanner.hasNextInt()) {
                        int rowID = scanner.nextInt();
                        if (scanner.hasNext()) {
                            parentTimeline.nameRow(rowID, scanner.next());
                        } else {
                            parentTimeline.broadcastMessage("Provide a name for the row.");
                        }
                    } else {
                        parentTimeline.broadcastMessage("Specify a row to name (specify by number)");
                    }
                    
                    
                default:
                    parentTimeline.broadcastMessage("Failed at first argument");
                    break;
            }
            
        }
        
    }
    
}
