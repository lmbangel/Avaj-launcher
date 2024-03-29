package weather;

import simulator.Aircrafts.Flyable;
import java.util.*;

public class Tower {

    private List <Flyable> observers = new LinkedList<Flyable>();

    public void register(Flyable flyable){
        if (!observers.contains(flyable))
            observers.add(flyable);
    }
    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }
    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}
