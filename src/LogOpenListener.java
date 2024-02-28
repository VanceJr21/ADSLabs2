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

public class LogOpenListener implements EventListener {

    private File log;

    // parameterized constructor
    public LogOpenListener(String filename){
        this.log = new File(filename);
    }

    public void update(String eventType, File file){
        System.out.println("Save to log " + log +": " +
                "Someone has performed " +  eventType + " " +
                "operation with the following file" + file.getName());
    }
}
