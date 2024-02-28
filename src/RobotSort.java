/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 02/02/2024
Description: Creating a sorting algorithm that will take any entry from an array then sorts it.
 */

import java.util.*;
public class RobotSort {
    public static void main(String[] args) {
        String[] coloredBalls = {"Red","Blue","Red","White","Blue","Red","Red","White","Blue","White"};
        int left = 0;
        int right = coloredBalls.length -1;
        int current= 0;
        System.out.println(Arrays.toString(coloredBalls));

        while(current <= right){
            if (coloredBalls[current].equals("Red")){
                 String temp = coloredBalls[left];
                 coloredBalls[left] = coloredBalls[current];
                 coloredBalls[current] =temp;
                 current++;
                 left++;
            } else if (coloredBalls[current].equals("Blue")) {
                String temp = coloredBalls[right];
                coloredBalls[right] = coloredBalls[current];
                coloredBalls[current] =temp;
                right--;
            } else if (coloredBalls[current].equals("White")) {
                current++;
            } else{
                current++;
            }
        }
        System.out.println("---- Sorted ----");
        System.out.println(Arrays.toString(coloredBalls));

    }

}
