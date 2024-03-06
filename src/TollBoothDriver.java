/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 03/04/2024
Description:  Creating a tollbooth program that gets the information from the user of a truck.
              Then outputs the toll due, the total amount trucks and receipts, also to have the
              values that were inputted copied then the values will reset to zero.
 */


import java.util.Scanner;

public class TollBoothDriver {
    public static void main(String[] args) {

        TollBooth tollBooth = new TollBooth();


        while (true){
            // prompting the user
            System.out.println("Make one of the following Selections:");
            System.out.println("\t1- Scan truck info and Display Toll\n " +
                    "\t2- Calculate and Display Booths total\n" + "\t3- Remove cash drawer\n"+
                    "\t4- Exit program");

            // creating the users input
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            // enter in truck information and calculate the tolldue
            if (choice == 1) {

                System.out.println("Enter the trucks make");
                String truckMake = input.next();

                System.out.println("Enter the in the number of axles");
                int truckAxle = input.nextInt();

                System.out.println("Enter in the truck's weight");
                int truckWt = input.nextInt();

                Truck truck = new Truck(truckMake, truckAxle, truckWt);

                System.out.println("Truck make: " + truck.getTruckMake() + " \nThe tolldue is: $" + tollBooth.calculateToll(truck));
                System.out.println("I am here");
            }

            // prints the total of receipts and truck count
             if (choice == 2) {
                 tollBooth.totals();
             }

            // prints the total of receipts and truck count
            // then copies the information
            // then rest all the values to zero
             if (choice == 3) {

                 System.out.println("*** Collecting receipts ***");
                 tollBooth.totals();
                 // copy then reset the values to zero
                 TollBooth tollBooth2 = new TollBooth(tollBooth);
                 tollBooth.reset();
             }

             // exiting the program
             if (choice == 4) {
                break;
            }

        }
    }
}
