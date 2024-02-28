import java.util.Random;
import java.util.Scanner;

public class SearchSelfOrganizing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = 20;

        SelfOrganizingList list = new SelfOrganizingList(N);

        Random rand = new Random();

        for (int i =0; i < N; i++){
            list.insert(Math.abs(rand.nextInt(1000)));
        }

        int n = 0;
        while (n != -1){
            list.printList();
            System.out.println("\nEnter an element to search, -1 to exit");
            n = sc.nextInt();
            System.out.println("Search result: " + list.search(n));
        }

        sc.close();

    }
}
