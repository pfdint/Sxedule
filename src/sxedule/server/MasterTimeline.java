package sxedule.server; 

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;

public class MasterTimeline implements Serializable {
    
    private transient Set<AsynchronousNetworkCommunicator> connectionSet;
    
    private transient InputParser inputParser;
    
// _  _              __               
//|_|(_| _ __ _|_   |_  o  _  |  _| _ 
//| |__|(/_| | |_   |   | (/_ | (_|_> 
    
    private Set<Agent> agents;
    
    private Map<Integer, Agent> agentIDMap;
    
    private transient int agentIDLabeler = 0;
    
// _                          __               
//|_| _ _|_ o     o _|_ \/   |_  o  _  |  _| _ 
//| |(_  |_ | \_/ |  |_ /    |   | (/_ | (_|_> 
    
    private Set<Activity> activities;
    
    private Map<Integer, Activity> activityIDMap;
    
    private transient int activityIDLabeler = 0;
    
    
    
    private HashMap<Integer, String> rowNameTable;
    
    private int highestRowNumber = 0;
    
// __                              
///   _ __  _ _|_ __    _ _|_ _  __
//\__(_)| |_>  |_ | |_|(_  |_(_) | 
    
    public MasterTimeline() {
        connectionSet = new HashSet<>();
        inputParser = new InputParser(this);
        agents = new HashSet<>();
        agentIDMap = new HashMap<>();
        activities = new HashSet<>();
        activityIDMap = new HashMap<>();
    }
    
// dP""b8 88     88 888888 88b 88 888888     8b    d8    db    88b 88    db     dP""b8 888888 8b    d8 888888 88b 88 888888 
//dP   `" 88     88 88__   88Yb88   88       88b  d88   dPYb   88Yb88   dPYb   dP   `" 88__   88b  d88 88__   88Yb88   88   
//Yb      88  .o 88 88""   88 Y88   88       88YbdP88  dP__Yb  88 Y88  dP__Yb  Yb  "88 88""   88YbdP88 88""   88 Y88   88   
// YboodP 88ood8 88 888888 88  Y8   88       88 YY 88 dP""""Yb 88  Y8 dP""""Yb  YboodP 888888 88 YY 88 888888 88  Y8   88   
    
    public void addConnection(AsynchronousNetworkCommunicator connectionToAdd) {
        connectionToAdd.setInputObjectAcceptor(inputParser);
        connectionSet.add(connectionToAdd);
    }
    
    public void broadcastMessage(String message) {
        for (AsynchronousNetworkCommunicator connection : connectionSet) {
            connection.output(message);
        }
    }
    
    private void broadcastUpdate(String updateMessage) {
        for (AsynchronousNetworkCommunicator connection : connectionSet) {
            connection.output(updateMessage);
        }
    }
    
//   db     dP""b8 888888 88b 88 888888     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//  dPYb   dP   `" 88__   88Yb88   88       88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
// dP__Yb  Yb  "88 88""   88 Y88   88       88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//dP""""Yb  YboodP 888888 88  Y8   88       88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP'
    
    public synchronized void addAgent() {
        
        Agent createdAgent = new Agent();
        
        agentIDMap.put(agentIDLabeler, createdAgent);
        agentIDLabeler++;
        
        agents.add(createdAgent);
        
        broadcastUpdate("agent add " + (agentIDLabeler - 1));
        
    }
    
    public synchronized void editAgent(int agentID, String restOfInput) {
        
        if (agentID >= agentIDMap.size()) {
            return;
        }
        
        Agent agentToModify = agentIDMap.get(agentID);
        
        int positionOfSeparator = restOfInput.indexOf("\"");
        if (positionOfSeparator == -1) {
            return;
        }
        
        String field = restOfInput.substring(1, positionOfSeparator);
        String value = restOfInput.substring(positionOfSeparator + 1);
        
//        String field = restOfInput.substring(1, restOfInput.indexOf("\""));
//        String value = restOfInput.substring(restOfInput.indexOf("\"") + 1, restOfInput.length() - 1);
        
        switch (field) {
            case "Title":
            case "TITLE":
            case "title": agentToModify.setTitle(value);
                break;
            case "FirstName":
            case "Firstname":
            case "FIRSTNAME":
            case "firstname": agentToModify.setFirstName(value);
                break;
            case "LastName":
            case "Lastname":
            case "LASTNAME":
            case "lastname": agentToModify.setLastName(value);
                break;
            case "UniqueTitle":
            case "Uniquetitle":
            case "UNIQUETITLE":
            case "uniquetitle": agentToModify.setUniqueTitle(value);
                break;
            case "Flags":
            case "FLAGS":
            case "flags": agentToModify.addToFlags(value);
                break;
            case "PreferenceMap":
            case "Preferencemap":
            case "preferenceMap":
            case "PREFERENCEMAP":
            case "preferencemap": agentToModify.addToPreferenceMap(value);
                break;
            case "PersonalTimeline":
            case "Personaltimeline":
            case "personalTimeline":
            case "PERSONALTIMELINE":
            case "personaltimeline": agentToModify.addToPersonalTimeline(activityIDMap.get(Integer.parseInt(value)));
                break;
        }
        
    }
    
    public synchronized void deleteAgent(int agentID) {
        agents.remove(agentIDMap.remove(agentID));
        broadcastUpdate("agent delete " + agentID);
    }
    
//   db     dP""b8 888888 88 Yb    dP 88 888888 Yb  dP     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//  dPYb   dP   `"   88   88  Yb  dP  88   88    YbdP      88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
// dP__Yb  Yb        88   88   YbdP   88   88     8P       88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//dP""""Yb  YboodP   88   88    YP    88   88    dP        88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP' 
    
    public synchronized void addActivity() {
        
        Activity createdActivity = new Activity();
        
        activityIDMap.put(activityIDLabeler, createdActivity);
        activityIDLabeler++;
        
        activities.add(createdActivity);
        
        broadcastUpdate("activity add " + (activityIDLabeler - 1));
        
    }
    
    public synchronized void editActivity(int activityID, String restOfInput) {
        
        Activity activityToModify = activityIDMap.get(activityID);
        
        int positionOfSeparator = restOfInput.indexOf("\"");
        if (positionOfSeparator == -1) {
            return;
        }
        
        String field = restOfInput.substring(1, positionOfSeparator);
        String value = restOfInput.substring(positionOfSeparator + 1);
        
        switch (field) {
            case "StartTime":
            case "Starttime":
            case "startTime":
            case "STARTTIME":
            case "starttime": activityToModify.setStartTime(Long.parseLong(value));
                break;
            case "EndTime":
            case "Endtime":
            case "endTime":
            case "ENDTIME":
            case "endtime": activityToModify.setEndTime(Long.parseLong(value));
                break;
            case "MinCampers":
            case "Mincampers":
            case "minCampers":
            case "MINCAMPERS":
            case "mincampers": activityToModify.setMinCampers(Integer.parseInt(value));
                break;
            case "MaxCampers":
            case "Maxcampers":
            case "maxCampers":
            case "MAXCAMPERS":
            case "maxcampers": activityToModify.setMaxCampers(Integer.parseInt(value));
                break;
            case "NeededStaff":
            case "Neededstaff":
            case "neededStaff":
            case "NEEDEDSTAFF":
            case "neededstaff": activityToModify.setNeededStaff(Integer.parseInt(value));
                break;
            case "MaxStaff":
            case "Maxstaff":
            case "maxStaff":
            case "MAXSTAFF":
            case "maxstaff": activityToModify.setMaxStaff(Integer.parseInt(value));
                break;
            case "PredeterminedRatio":
            case "Predeterminedratio":
            case "predeterminedRatio":
            case "PREDETERMINEDRATIO":
            case "predeterminedratio": activityToModify.setPredeterminedRatio(Double.parseDouble(value));
                break;
            case "ActivityName":
            case "Activityname":
            case "activityName":
            case "ACTIVITYNAME":
            case "activityname": activityToModify.setActivityName(value);
                break;
            case "StaffPrerequisites":
            case "Staffprerequisites":
            case "staffPrerequisites":
            case "STAFFPREREQUISITES":
            case "staffprerequisites": activityToModify.addToStaffPrerequisites(value);
                break;
            case "AssignedStaff":
            case "Assignedstaff":
            case "assignedStaff":
            case "ASSIGNEDSTAFF":
            case "assignedstaff": activityToModify.addToAssignedStaff(agentIDMap.get(Integer.parseInt(value)));
                break;
            case "Row":
            case "ROW":
            case "row": activityToModify.setRow(Integer.parseInt(value));
                break;
            case "Broadcast":
            case "BROADCAST":
            case "broadcast": activityToModify.setBroadcast(Boolean.parseBoolean(value));
                break;
            case "Duty":
            case "DUTY":
            case "duty": activityToModify.setIsDuty(Boolean.parseBoolean(value));
                break;
        }
        
    }
    
    public synchronized void deleteActivity(int activityID) {        
        activities.remove(activityIDMap.remove(activityID));
        broadcastUpdate("activity delete " + activityID);
    }
    
    public synchronized void nameRow(int row, String name) {
        rowNameTable.put(row, name);
        broadcastUpdate("row " + row + " " + name);
    }
    
//88""Yb 888888 88""Yb .dP"Y8 88 .dP"Y8 888888 888888 88b 88  dP""b8 888888     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//88__dP 88__   88__dP `Ybo." 88 `Ybo."   88   88__   88Yb88 dP   `" 88__       88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
//88"""  88""   88"Yb  o.`Y8b 88 o.`Y8b   88   88""   88 Y88 Yb      88""       88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//88     888888 88  Yb 8bodP' 88 8bodP'   88   888888 88  Y8  YboodP 888888     88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP' 
    
    public void saveFile(String filename) {
        
        String userhome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");
        
    }
    
//88  88 888888 88     88""Yb 888888 88""Yb     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//88  88 88__   88     88__dP 88__   88__dP     88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
//888888 88""   88  .o 88"""  88""   88"Yb      88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//88  88 888888 88ood8 88     888888 88  Yb     88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP' 
    
    
    
//    public int computeRow(int startTime, int endTime) {
//        
//        for (int i = highestRowNumber; i > 1; i--) {
//            if (isOccupiedInRow(findActivitiesWithRow(i), startTime, endTime)) {
//                if (i == highestRowNumber) {
//                    highestRowNumber++;
//                }
//                return i + 1;
//            }
//        }
//        return 1;
//    }
//    
//    public boolean isOccupiedInRow(Set<Activity> activitiesWithRow, int startTime, int endTime) {
//        
//        for (Activity activityInQuestion : activitiesWithRow) {
//            
//            if ( (startTime > activityInQuestion.returnStartTime() && startTime < activityInQuestion.returnEndTime()) || (endTime > activityInQuestion.returnStartTime() && endTime < activityInQuestion.returnEndTime())) {
//                return true;
//            }
//            
//        }
//        
//        return false;
//        
//    }
//    
//    public Set<Activity> findActivitiesWithRow(int targetRow) {
//        
//        Set<Activity> setToReturn = new HashSet<>();
//        for (Activity activityInQuestion : activities) {
//            if (activityInQuestion.returnRow() == targetRow) {
//                setToReturn.add(activityInQuestion);
//            }
//        }
//        
//        return setToReturn;
//        
//    }
    
}