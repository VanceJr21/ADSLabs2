public class TollBooth extends Truck {

    private int truckCount = 0;
    private int totalReceipt =0;


    public TollBooth(){

    }

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

    public int calculateToll(){
    int tollDue = (5*(getAxles())) + (10*(getWeight()/1000));
    truckCount++;
    return tollDue;
    }

    public void totals(){
        System.out.println( calculateToll() + ", "+ truckCount +", "+ totalReceipt);
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
