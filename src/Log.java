import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.LongFunction;
/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/19/2024
Description: Implementing the Singleton design pattern by making Log
 */

public final class Log {

    //Singleton design pattern
    private static Log instance;

    public String filepath;

    // default constructor
    private Log(){

    }

    // parameterized constructor
    private Log(String filepath){
        this.filepath = filepath;
    }

    public static Log getInstance(String filepath){
        if ( instance == null){
            instance = new Log(filepath);
        }
        return instance;
    }

    public void writeLog(String newLogEntry){
        // checking if the file exist

        try {
            FileWriter fw = new FileWriter(this.filepath, true);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss"); //timestamp for the new log entry
            String formatDate = sdf.format(date);
            fw.write(formatDate + " - " + newLogEntry +"\n"); // appending to the file
            fw.close();

        }catch (IOException e){
            System.out.println("File is not found.");
        }
    }

    // creating the file
    public void createLog(String filepath){
       this.filepath =filepath;

    }

    public void deleteLog(String filepath){
        //creating a new file object
        File file = new File(filepath);
        // checking if the file exists
        if (!file.exists()){
            System.out.println("File does not exist");
        }
        file.delete();
    }
    // www.stackoverflow.com
}
