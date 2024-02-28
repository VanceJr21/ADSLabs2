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

public class DemoObserver {

    public static void main(String[] args) {

        Editors editor = new Editors();

        editor.events.subscribe("open", new LogOpenListener("file.txt"));
        editor.events.subscribe("save", new EmailNotification("admin@example.com"));
        editor.events.subscribe("delete", new DeleteListener("file.txt"));
        editor.events.subscribe("save", new EmailNotification("admin@example.com"));
        editor.events.unsubscribe("delete", new DeleteListener("file.txt"));



        try{
            editor.openFile("test.txt");
            editor.saveFile();
            editor.deleteFile();
            editor.saveFile();

        } catch (Exception e){
            e.printStackTrace();

        }
    }
}
