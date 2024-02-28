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


public class DeleteListener implements EventListener {
    private File log;

    public DeleteListener(String log){
        this.log = new File(log);
    }

    public void update(String eventType, File file){
        System.out.println("Deleted " + log +": " +
                "Someone has performed " +  eventType + " " +
                "operation with the following file" + file.getName());
    }
}
