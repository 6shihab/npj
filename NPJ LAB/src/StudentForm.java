import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentForm extends JFrame implements ActionListener {
    JFrame frame;
    JLabel label1,label2,label3,success;
    JTextField textField1,textField2,textField3;
    JButton button;

    StudentForm(){
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setLayout(null);

        label1=new JLabel("Name:");
        label2=new JLabel("Roll:");
        label3=new JLabel("Department:");

        label1.setBounds(25,50,100,25);
        label2.setBounds(25,100,100,25);
        label3.setBounds(25,150,100,25);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        textField1=new JTextField("Enter Your Name");
        textField2=new JTextField("Enter Your Roll");
        textField3=new JTextField("Enter Your Department");

        textField1.setBounds(150,50,300,25);
        textField2.setBounds(150,100,300,25);
        textField3.setBounds(150,150,300,25);

        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);

        success=new JLabel("");
        success.setBounds(50,300,150,25);
        frame.add(success);

        button=new JButton("Submit");
        button.setBounds(200,200,150,50);
        button.setFocusable(false);
        button.addActionListener(this);
        frame.add(button);


        frame.setVisible(true);
    }


    public static void main(String[] args) {
        StudentForm stf=new StudentForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        success.setText("Submitted Successfully");
        JOptionPane.showMessageDialog(this,"saved successfully");
    }
}
