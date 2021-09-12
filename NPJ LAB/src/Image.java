import javax.swing.*;
import java.awt.*;

public class Image extends JFrame {
    private JLabel label1, label2;
    public Image(String title) {
        // set the frame title
        super(title);
        // set layout
        setLayout(new FlowLayout());
        // set frame size
        setSize(500, 300);
        // close the program when we exit
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // show the frame in middle of the window
        setLocationRelativeTo(null);
        // create the label for image
        label1 = new JLabel();
        label2 = new JLabel();
        // set the image as icon
        label1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("./mama1.jpg")).getImage().getScaledInstance(200,250, java.awt.Image.SCALE_SMOOTH)));
        label2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("./mama1.jpg")).getImage().getScaledInstance(200,250, java.awt.Image.SCALE_SMOOTH)));
        // add the icon to the frame
        add(label1);
        add(label2);
        // make the frame visible
        setVisible(true);
    }
}

class ImageRun {
    public static void main(String[] args) {
        new Image("Image Viewer");
    }
}
