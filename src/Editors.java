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

public class Editors {

    public EventManager events;

    private File file;

    public Editors(){
        this.events = new EventManager("open", "save", "delete");
    }

    // open file event
    public void openFile(String filePath){
        this.file = new File(filePath);

        // notify for the open event
        events.notify("open", file);
    }

    //save file event
    public void saveFile() throws Exception{
        if (this.file != null){
            events.notify("save", file);
        }
        else {
            throw new Exception("Please open a file first");
        }
    }

    public void deleteFile() throws Exception{

        if(this.file != null){
            this.file = null;
        } else {
            throw new Exception("failed to delete");
        }


    }
}
