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


public class EmailNotification implements EventListener{
    private String email;

    public EmailNotification(String email){
        this.email = email;
    }

    public void update(String eventType, File file){
        System.out.println("Email to " + email + " : Someone "
        + "has performed " + eventType + " operation with " +
                " the following file: " + file.getName());
    }
}
