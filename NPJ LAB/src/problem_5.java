
import java.io.*;
import java.util.concurrent.TimeUnit;
public class problem_5 extends Thread{
    public void run()
    {
        // This is a thread
        for(int i=0; i<=5; i++){
            System.out.println("Wassup! Nigga !");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        problem_5 thread = new problem_5();
        thread.start();

        for(int i=0; i<=10; i++){
            System.out.println(" "+i);
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
