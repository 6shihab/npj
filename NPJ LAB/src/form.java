import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class form extends JFrame implements ActionListener {
    JFrame frame;
    JLabel label1,label2,label3,label4;
    JTextField textField1,textField2,textField3;
    JButton button;

    form(){
        frame=new JFrame("Student Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setLayout(null);

        label1=new JLabel("Name:");
        label1.setBounds(50,50,100,25);
        frame.add(label1);

        label2=new JLabel("Roll:");
        label2.setBounds(50,100,100,25);
        frame.add(label2);

        label3=new JLabel("Department:");
        label3.setBounds(50,150,100,25);
        frame.add(label3);

        textField1=new JTextField("Enter Your Name");
        textField1.setBounds(150,50,200,25);
        frame.add(textField1);

        textField2=new JTextField("Enter Your Roll");
        textField2.setBounds(150,100,200,25);
        frame.add(textField2);

        textField3=new JTextField("Enter Your Department");
        textField3.setBounds(150,150,200,25);
        frame.add(textField3);

        label4=new JLabel("");
        label4.setBounds(50,250,200,25);
        frame.add(label4);

        button =new JButton("Submit");
        button.setBounds(150,200,100,50);
        button.addActionListener(this);
        frame.add(button);



        frame.setVisible(true);

    }


    public static void main(String[] args) {
        form fr=new form();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label4.setText("Submitted Successfully");
    }
}
