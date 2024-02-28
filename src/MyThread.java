public class MyThread extends Thread{
    private String threadName;

    public MyThread(String name){
        this.threadName = name;
    }

    public void run(){
        System.out.println("Executing Thread: " + this.threadName);
        try {
            System.out.println("Thread " + this.threadName + " is going to sleep");
            Thread.sleep(1000);
            System.out.println("Thread " + this.threadName +  " woke up");
        }
        catch (InterruptedException ex){
            System.out.println("Someone interrupted my execution");
        }
    }
}
