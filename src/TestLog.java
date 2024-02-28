/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/19/2024
Description: Implementing the Singleton design pattern by making Log
 */


public class TestLog {
    public static void main(String[] args) {
        Log log = Log.getInstance("Log.txt");
        log.writeLog("Vance is hungry");
        log.createLog("Log2.txt");
        log.writeLog("Today it was raining outside.");
        log.writeLog("Username: Vance -  just logged in");
        log.deleteLog("Log.txt");

    }
}
