/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 03/04/2024
Description:  Creating a tollbooth program that gets the information from the user of a truck.
              Then outputs the toll due, the total amount trucks and receipts, also to have the
              values that were inputted copied then the values will reset to zero.
 */


public class Truck {

    private String truckMake;

    private int axles;

    private int weight;

    //
    public Truck(String truckMake, int axles, int weight) {
        this.axles = axles;
        this.weight = weight;
        this.truckMake = truckMake;

    }

    // default constructor
    public Truck() {

    }

    //getters and setters
    public String getTruckMake() {
        return truckMake;
    }

    public void setTruckMake(String truckMake) {
        this.truckMake = truckMake;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
