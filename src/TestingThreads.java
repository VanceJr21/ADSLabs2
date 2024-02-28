public class TestingThreads {

    public static void main(String[] args) {
       /* MyThread t1;
        for(int i=1; i < 10; i++){
            t1 = new MyThread("Thread-" +i);
            t1.start();
            t1.interrupt();
        }

        System.out.println("Main Method finished execution");
        */

        GreetingClass g1 = new GreetingClass("Hello", "Thread-1");
        GreetingClass g2 = new GreetingClass("Ahlan", "Thread-2");

        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        t1.start();
        t2.start();

    }
}
