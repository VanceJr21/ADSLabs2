/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 03/04/2024
Description: This program has a random feature that either choose the Randoms object nextInt()
             or the LoadDice object nextInt which returns the largest number.
 */

import java.util.Random;

public class RandomDriver {
    public static void main(String[] args) {

        // LoadedDice object
        LoadedDice myDice = new LoadedDice();
        //Random randGenerator = new Random();
        printDiceRolls(myDice);

    }

    public static void printDiceRolls(Random randGenerator){
        for(int i = 0; i < 100; i++){
            System.out.println(randGenerator.nextInt(6) + 1);
        }
    }

}
