public class Truck {
    private String truckMake;

    private int axles;

    private int weight;

    public Truck(String truckMake, int axles, int weight) {
        this.axles = axles;
        this.weight = weight;
        this.truckMake = truckMake;
    }

    public Truck() {

    }

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
