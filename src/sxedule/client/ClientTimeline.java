package sxedule.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ClientTimeline {
    
// _  _              __               
//|_|(_| _ __ _|_   |_  o  _  |  _| _ 
//| |__|(/_| | |_   |   | (/_ | (_|_> 
    
    private Set<DrawableAgent> agents;
    
    private Map<Integer, DrawableAgent> agentIDMap;
    
    private int agentIDLabeler = 0;
    
// _                          __               
//|_| _ _|_ o     o _|_ \/   |_  o  _  |  _| _ 
//| |(_  |_ | \_/ |  |_ /    |   | (/_ | (_|_> 
    
    private Set<DrawableActivity> activities;
    
    private Map<Integer, DrawableActivity> activityIDMap;
    
    private int activityIDLabeler = 0;
    
    private int highestRowNumber = 0;
    
// __                              
///   _ __  _ _|_ __    _ _|_ _  __
//\__(_)| |_>  |_ | |_|(_  |_(_) | 
    
    public ClientTimeline() {
        agents = new HashSet<>();
        agentIDMap = new HashMap<>();
        activities = new HashSet<>();
        activityIDMap = new HashMap<>();
    }
    
//   db     dP""b8 888888 88b 88 888888     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//  dPYb   dP   `" 88__   88Yb88   88       88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
// dP__Yb  Yb  "88 88""   88 Y88   88       88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//dP""""Yb  YboodP 888888 88  Y8   88       88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP'
    
    public void addDrawableAgent() {
        
        DrawableAgent createdDrawableAgent = new DrawableAgent();
        
        agentIDMap.put(agentIDLabeler, createdDrawableAgent);
        agentIDLabeler++;
        
        agents.add(createdDrawableAgent);
        
    }
    
    public void editDrawableAgent(int agentID, String restOfInput) {
        
        if (agentID >= agentIDMap.size()) {
            return;
        }
        
        DrawableAgent agentToModify = agentIDMap.get(agentID);
        
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
    
    public void deleteDrawableAgent(int agentID) {
        agents.remove(agentIDMap.remove(agentID));
    }
    
//   db     dP""b8 888888 88 Yb    dP 88 888888 Yb  dP     8b    d8 888888 888888 88  88  dP"Yb  8888b.  .dP"Y8 
//  dPYb   dP   `"   88   88  Yb  dP  88   88    YbdP      88b  d88 88__     88   88  88 dP   Yb  8I  Yb `Ybo." 
// dP__Yb  Yb        88   88   YbdP   88   88     8P       88YbdP88 88""     88   888888 Yb   dP  8I  dY o.`Y8b 
//dP""""Yb  YboodP   88   88    YP    88   88    dP        88 YY 88 888888   88   88  88  YbodP  8888Y"  8bodP' 
    
    public void addDrawableActivity() {
        
        DrawableActivity createdDrawableActivity = new DrawableActivity();
        
        activityIDMap.put(activityIDLabeler, createdDrawableActivity);
        activityIDLabeler++;
        
        activities.add(createdDrawableActivity);
        
    }
    
    public void editDrawableActivity(int activityID, String restOfInput) {
        
        DrawableActivity activityToModify = activityIDMap.get(activityID);
        
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
            case "DrawableActivityName":
            case "DrawableActivityname":
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
    
    public void deleteDrawableActivity(int activityID) {        
        activities.remove(activityIDMap.remove(activityID));
    }
    
}