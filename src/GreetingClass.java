public class GreetingClass implements Runnable{

    private String greetingsMSG;
    private String threadName;
    private static final  int REPETITIONS = 10;
    private static final int DELAY = 100;


    public GreetingClass(String greeting, String name){
        this.greetingsMSG = greeting;
        this.threadName = name;
        System.out.println("Creating Thread -> " + this.threadName);
    }

    public void run(){
        System.out.println("Running Thread -> " + this.threadName);
       try {
           for(int i =0; i < REPETITIONS; i++){
               System.out.println("Executing Thread -> " + this.threadName + " Greeting Message -> " + this.greetingsMSG);
           }
           Thread.sleep(DELAY);
       } catch (InterruptedException ex){
           System.out.println("Interrupted Thread -> " + this.threadName);
       }
       System.out.println("Exiting Thread -> " + this.threadName);
    }
}
