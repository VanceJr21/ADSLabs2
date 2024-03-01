import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    // wrapper class for items
    static class Item {
        int profit, weight;

        public Item (int val, int wt){
            this.profit =val;
            this.weight = wt;
        }
    }

    public static void main(String[] args) {

        Item[] itemArr = {
                new Item(60,10),
                new Item(100,20),
                new Item(120,30)
        };

        //size of knapsack
        int capacity = 50;

        System.out.println("Max value: " + getMaxValue(itemArr, capacity));
    }

    public static double getMaxValue(Item[] arr, int capacity){

        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {

                double ratio1 = (double) item1.profit/(double) item1.weight;
                double ratio2 = (double) item2.profit/(double) item2.weight;

                if(ratio1 < ratio2){
                    return 1;
                } else {
                    return -1;
                }

            }
        });

        // total value of knapsack
        double totalValue = 0;

        // looping through sorted array
        for (Item i : arr){

            int curWt = i.weight;
            int curVal = i.profit;


            //if i can take a whole item
            if (capacity - curWt >= 0){

                capacity = capacity - curWt;
                totalValue += curVal;
            }
            // if i cant take the whole item
            else {

                double fraction = (double) capacity/(double) curWt;
                totalValue += (curVal * fraction);

                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
        }
        // return the total value
        return  totalValue;
    }
}
