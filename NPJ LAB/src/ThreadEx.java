import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


public class ThreadEx extends Thread {
    public static void main(String[] args) {
        Thread1 T1=new Thread1();
        Thread2 T2= new Thread2();
        T1.start();
        T2.start();
    }
}

class Thread1 extends Thread{
    public void run() {
        JFrame frame1=new JFrame();
        JLabel[] label1=new JLabel[20];
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500,500);
        frame1.setLayout(new FlowLayout());
        for (int i=0;i<20;i++){
                label1[i] = new JLabel(String.valueOf(i+1));
                frame1.add(label1[i]);
                frame1.setVisible(true);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }



    }
}

class Thread2 extends Thread{
    public void run() {
        JFrame frame2=new JFrame();
        JLabel[] label2=new JLabel[15];
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400,400);
        frame2.setLayout(new FlowLayout());
        frame2.setLocationRelativeTo(null);

        for (int i=0;i<15;i++){
            label2[i] = new JLabel(String.valueOf(i+1));
            frame2.add(label2[i]);
            frame2.setVisible(true);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}


