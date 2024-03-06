/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 03/04/2024
Description:  Creating a tollbooth program that gets the information from the user of a truck.
              Then outputs the toll due, the total amount trucks and receipts, also to have the
              values that were inputted copied then the values will reset to zero.
 */

public class TollBooth extends Truck {

    private int truckCount = 0;
    private int totalReceipt =0;


    // default constructor
    public TollBooth(){

    }

    // getters and setters
    public int getTruckCount() {
        return truckCount;
    }

    public void setTruckCount(int truckCount) {
        this.truckCount = truckCount;
    }

    public int getTotalReceipt() {
        return totalReceipt;
    }

    public void setTotalReceipt(int totalReceipt) {
        this.totalReceipt = totalReceipt;
    }

    // calculating tolls
    public int calculateToll(Truck t){
    int tollDue = (5*(t.getAxles())) + (10*(t.getWeight()/1000));
    truckCount++; // keeping track of the number of trucks
    totalReceipt = totalReceipt + tollDue; // calculating the totalReceipt
    return tollDue;
    }

    // displays the totals of the receipt and number of trucks
    public void totals(){
        System.out.println( "Totals since last collection - Receipts: $" + totalReceipt + " Trucks: "+ truckCount );
    }

    // copy constructor
    public TollBooth(TollBooth otherTollBooth){
        this.truckCount = otherTollBooth.truckCount;
        this.totalReceipt = otherTollBooth.totalReceipt;

    }

    // resets all values to zero
    public void reset(){
        truckCount = 0;
        totalReceipt = 0;
    }


}
