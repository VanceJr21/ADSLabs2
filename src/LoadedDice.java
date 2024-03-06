/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 03/04/2024
Description: This program has a random feature that either choose the Randoms object nextInt()
             or the LoadDice object nextInt which returns the largest number.
 */



import java.util.Random;

public class LoadedDice extends Random {

    public LoadedDice(){
        // invoking the Random object constructor
        super();
    }

    @Override
    public int nextInt(int num) {

        Random rand = new Random();
         int randNum = rand.nextInt(0,2); // setting up the 50% chance of the
                                                       // Random nextInt() and LoadedDice nextInt()

        if (randNum == 0) {
            return num - 1; // returning the largest number
        }

        return super.nextInt(num); // returning the Random method
    }
}
