import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ex {
    public static void main(String[] args) throws InterruptedException {
//       new img();
//       new ResBill();
        Thrd1 th1=new Thrd1();
        Thrd2 th2=new Thrd2();
//        th1.start();
//        th2.start();
//        new MyCalculator();
        Client1 cl1=new Client1();
        Server1 sv1=new Server1();
        sv1.start();
        cl1.start();

    }
}
class img extends JFrame{
    JFrame frame=new JFrame("Image Show");

    img(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        ImageIcon image1 = new ImageIcon(getClass().getResource("./mama1.jpg"));
        frame.add(new JLabel(image1));
        ImageIcon image2=new ImageIcon(getClass().getResource("./mama1"));
        frame.add(new JLabel(image2));
        frame.setVisible(true);
    }
}

class ResBill extends JFrame implements ActionListener{
    JFrame frame=new JFrame("Restaurant Bill");
    JCheckBox checkBox,checkBox1,checkBox2;
    ResBill(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        JLabel label=new JLabel("Food Ordering System");
        label.setBounds(50,50,150,25);
        frame.add(label);


        checkBox=new JCheckBox("Pizza @100");
        checkBox1=new JCheckBox("Burger @70");
        checkBox2=new JCheckBox("Tea @10");
        checkBox.setBounds(50,100,150,25);
        checkBox1.setBounds(50,150,150,25);
        checkBox2.setBounds(50,200,150,25);
        frame.add(checkBox);
        frame.add(checkBox1);
        frame.add(checkBox2);

        JButton button=new JButton("Order");
        button.setBounds(150,250,100,50);
        button.addActionListener(this);
        frame.add(button);



        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        double amount=0;
        String msg="";
        if (checkBox.isSelected()){
            amount+=100;
            msg+="Pizza @100\n";
        }
        if (checkBox1.isSelected()){
            amount+=70;
            msg+="Burger @70\n";
        }
        if (checkBox2.isSelected()){
            amount+=10;
            msg+="Tea @10\n";
        }
        msg+="-------------------------\n";
        JOptionPane.showMessageDialog(this,msg+"Total: "+amount);
    }
}


class Thrd1 extends Thread{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("Thread 1 printing");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
class Thrd2 extends Thread{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("Thread 2 printing");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


class MyCalculator extends JFrame implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numButton=new JButton[10];
    JButton addButton,subButton,mulButton,divButton,clrButton,decButton,eqlButton;
    JPanel panel;
    double num1=0,num2=0,result=0;
    String operator;
    JButton modButton;

    MyCalculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setLayout(null);
        textField=new JTextField();
        textField.setBounds(50,50,300,50);
        textField.setEditable(false);
        frame.add(textField);

        for (int i=0;i<10;i++){
            numButton[i]=new JButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFocusable(false);
        }
        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        eqlButton=new JButton("=");
        clrButton=new JButton("C");
        modButton=new JButton("%");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        decButton.addActionListener(this);
        divButton.addActionListener(this);
        eqlButton.addActionListener(this);
        clrButton.addActionListener(this);
        modButton.addActionListener(this);




        panel=new JPanel();
        panel.setBounds(50,200,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButton[1]);
        panel.add(numButton[2]);
        panel.add(numButton[3]);
        panel.add(addButton);
        panel.add(numButton[4]);
        panel.add(numButton[5]);
        panel.add(numButton[6]);
        panel.add(subButton);
        panel.add(numButton[7]);
        panel.add(numButton[8]);
        panel.add(numButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButton[0]);
        panel.add(eqlButton);
        panel.add(divButton);

        clrButton.setBounds(250,125 ,100,50);
        frame.add(clrButton);

        modButton.setBounds(50,125,50,50);
        frame.add(modButton);

        frame.add(panel);



        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<10;i++){
            if (e.getSource()==numButton[i])
                textField.setText(textField.getText().concat(String.valueOf(i)));
        }
        if (e.getSource()==decButton)
            textField.setText(textField.getText().concat("."));
        if (e.getSource()==addButton){
            if (textField.getText().length()>0)
                num1=Double.parseDouble(textField.getText());
            operator="+";
            textField.setText("");
        }

        if (e.getSource()==subButton){
            if (textField.getText().length()>0)
                num1=Double.parseDouble(textField.getText());
            operator="-";
            textField.setText("");
        }

        if (e.getSource()==mulButton){
            if (textField.getText().length()>0)
                num1=Double.parseDouble(textField.getText());
            operator="*";
            textField.setText("");
        }
        if (e.getSource()==divButton){
            if (textField.getText().length()>0)
                num1=Double.parseDouble(textField.getText());
            operator="/";
            textField.setText("");
        }
        if (e.getSource()==modButton){
            if (textField.getText().length()>0)
                num1=Double.parseDouble(textField.getText());
            operator="%";
            textField.setText("");
        }
        if (e.getSource()==eqlButton){
            num2=Double.parseDouble(textField.getText());
            switch (operator){
                case "+":
                    result=num1+num2;
                    break;
                case "-":
                    result=num1-num2;
                    break;
                case "*":
                    result=num1*num2;
                    break;
                case "/":
                    result=num1/num2;
                    break;
                case "%":
                    result=num1%num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource()==clrButton){
            textField.setText("");
            num1=0;
        }


    }
}

class Client1 extends Thread{
    public void run(){
        try {
            Socket socket=new Socket("localhost",6969);
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF("Hello Server");
            dataOutputStream.flush();

            String str=dataInputStream.readUTF();
            System.out.println("message from server:"+ str);
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class Server1 extends Thread{
    public void run(){
        try {
            ServerSocket serverSocket=new ServerSocket(6969);
            Socket socket= serverSocket.accept();
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            String str=dataInputStream.readUTF();
            System.out.println("message: "+str);
            dataOutputStream.writeUTF("Hello Client");
            dataOutputStream.flush();


            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



