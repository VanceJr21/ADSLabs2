import javax.naming.ldap.spi.LdapDnsProvider;
import java.util.ArrayList;

public class RaceCondition {
    public static void main(String[] args) {
        final int NUMTHREADS =100;

        // We'll run the experiment 1000
        for (int i = 1; i <= 1000; i++){
            System.out.printf("Run %d....", i);
            Data data = new Data();
            ArrayList<Thread> threads = new ArrayList<>();

            for(int j = 0; j < NUMTHREADS; j++){
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // This code could potentially cause race conditions
                        //This is how you fix it - by creating a critical section
                        synchronized (data) {
                            int x = data.getValue();
                            data.setValue(x + 1);
                        }
                    }
                });
                thread.start();  // Start the thread run method
                threads.add(thread); // add the thread to the arraylist
            }

            try {
                for (Thread t : threads) {
                    t.join();
                }
                // At this point all threads finished execution and they are converging
                // here
                if(data.getValue() == NUMTHREADS){
                    System.out.println("Passed");
                } else {
                    System.out.println("Failed with Race condition and value is: " + data.getValue());
                    break;
                }
            }
            catch (Exception ex){
                ex.getMessage();
            }
        }




    }

    private static class Data{
        private int value ;

        public int getValue(){
            return this.value;
        }

        public void setValue(int v){
            this.value = v;
        }
    }
}

