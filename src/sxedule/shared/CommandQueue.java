package sxedule.shared;

//import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import net.intintint.api.net.async.AcceptsInputObject;
import net.intintint.api.net.async.AsynchronousNetworkCommunicator;
import sxedule.client.Observable;
import sxedule.client.Observer;
import sxedule.shared.command.TimelineCommand;

public class CommandQueue implements AcceptsInputObject, Observable {
    
    private Set<AsynchronousNetworkCommunicator> connectionSet;
    
    private Timeline timeline;
    
    private Queue<Set<TimelineCommand>> commandQueue;
    
    private Set<Observer> observers;
    
    private boolean rebroadcast;
    
//    private Deque<Set<TimelineCommand>> undoDeque;

    public CommandQueue(Timeline timeline, boolean rebroadcast) {
        this.timeline = timeline;
        connectionSet = new HashSet<>();
        commandQueue = new LinkedList<>();
        observers = new HashSet<>();
        this.rebroadcast = rebroadcast;
//        undoDeque = new LinkedList<>();
    }
    
    @Override
    public void acceptInputObject(Object inputObject) {
        if (inputObject instanceof String) {
            System.out.println(inputObject);
        } else {
            Set<TimelineCommand> commandMacro = (Set<TimelineCommand>) inputObject;
            commandQueue.offer(commandMacro);
        }
    }
    
    public void executeNextInQueue() {
        LinkedHashSet<TimelineCommand> commandMacro = (LinkedHashSet<TimelineCommand>) commandQueue.poll();
        if (commandMacro == null) {
            return;
        }
        for (TimelineCommand commandInQuestion : commandMacro) {
            commandInQuestion.setTarget(timeline);
            commandInQuestion.execute();
        }
        if (rebroadcast) {
            rebroadcast(commandMacro);
        }
        notifyObservers();
    }
    
    public void addConnection(AsynchronousNetworkCommunicator connection) {
        connection.setInputObjectAcceptor(this);
        connectionSet.add(connection);
    }
    
    private void rebroadcast(Set<TimelineCommand> commandMacro) {
        for (AsynchronousNetworkCommunicator connection : connectionSet) {
            connection.output(commandMacro);
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
}
