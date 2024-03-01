import java.util.Scanner;

public class TollBoothDriver {
    public static void main(String[] args) {

        TollBooth tollBooth = new TollBooth();
        Truck truck = new Truck();

        System.out.println("Welcome to Houston Toll Road");
        System.out.println("Make one of the following Selections:");
        System.out.println("\t1- Scan truck info and Display Toll\n " +
                "\t2- Calculate and Display Booths total\n" + "\t3- Remove cash drawer\n"+
                "\t4- Exit program");

        while (true){
            Scanner input = new Scanner(System.in);
            if (input.nextInt() == 1){
                System.out.println("Enter in the axles and weight of the truck");


            }


        }
    }
}
