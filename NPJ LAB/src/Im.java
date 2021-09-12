import java.awt.*;
import javax.swing.*;

public class Im extends JFrame {
    JFrame frame;
    ImageIcon image1,image2;

    Im(){
        frame=new JFrame("Bagh Mama Show");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setLayout(new FlowLayout());

        image1=new ImageIcon(getClass().getResource("./mama1.jpg"));
        frame.add(new JLabel(image1));

        image2=new ImageIcon(getClass().getResource("mama1.jpg"));
        frame.add(new JLabel(image2));




        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Im gui = new Im();
    }
}
