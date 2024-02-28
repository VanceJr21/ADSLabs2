/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 02/16/2024
Description: Observer Lab -> Making sure the Unsubscribe method works.
                             DeleteFile implemented.
                             OpenFile implemented.
                             SaveFile implemented.
 */




import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EventManager {

    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations){

        // creating listeners for our operations
        for(String operation : operations){
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    // subscribe method
    public void subscribe(String eventType, EventListener listener){

        List<EventListener> users = listeners.get(eventType);

        //add the new listener
        users.add(listener);
    }

    //unsubscribe method
    public void unsubscribe(String eventType, EventListener listener){
        List<EventListener> users = listeners.get(eventType);

        //removes a listener
        System.out.println("Unsubscribe -> " + users); // show unsubscribe is working
        users.remove(listener);

    }

    public void notify(String eventType, File file){
        List<EventListener> users = listeners.get(eventType);

        for(EventListener listener : users){
            listener.update(eventType, file);
        }

    }

}
