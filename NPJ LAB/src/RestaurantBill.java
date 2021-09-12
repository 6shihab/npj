import javax.swing.*;
import java.awt.event.*;

public class RestaurantBill extends JFrame implements ActionListener{
    JFrame frame;
    JLabel label;
    JCheckBox checkBox1,checkBox2,checkBox3;
    JButton button;

    RestaurantBill() {
        frame = new JFrame("Restaurant Bill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);

        label =new JLabel("Food Ordering System");
        label.setBounds(50,50,150,25);
        frame.add(label);

        checkBox1=new JCheckBox("Pizza @ 100");
        checkBox2=new JCheckBox("Burger @ 30");
        checkBox3=new JCheckBox("Tea @ 10");

        checkBox1.setBounds(50,100,200,25);
        checkBox2.setBounds(50,150,200,25);
        checkBox3.setBounds(50,200,200,25);
        frame.add(checkBox1);
        frame.add(checkBox2);
        frame.add(checkBox3);

        button = new JButton("Order");
        button.setBounds(50,250,100,50);
        button.addActionListener(this);
        frame.add(button);


        frame.setVisible(true);
    }



    public static void main(String[] args) {
        RestaurantBill rb=new RestaurantBill();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        float amount=0;
        String msg="";
        if (checkBox1.isSelected()){
            amount+=100;
            msg="Pizza: 100\n";
        }
        if (checkBox2.isSelected()){
            amount+=30;
            msg+="Burger: 30\n";
        }
        if (checkBox3.isSelected()){
            amount+=10;
            msg+="Tea: 10\n";
        }
        msg+="-----------------------\n";
        JOptionPane.showMessageDialog(this,msg+"Total: "+amount);

    }
}
