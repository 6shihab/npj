import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculatorS implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButton= new JButton[10];
    JButton[] functionButton= new JButton[7];
    JButton addButton,subButton,mulButton,divButton;
    JButton equButton,clrButton,decButton;
    JPanel panel;

    double num1=0.0,num2=0,result=0;
    char operator;

    calculatorS(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(30,25,330,50);
        textField.setEditable(false);
        frame.add(textField);

        for (int i=0;i<10;i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
        }

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        equButton=new JButton("=");
        clrButton=new JButton("C");
        decButton=new JButton(".");

        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=equButton;
        functionButton[5]=clrButton;
        functionButton[6]=decButton;

        for (int i=0;i<7;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
        }

        panel=new JPanel();
        panel.setBounds(50,150,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);
        frame.add(panel);

        clrButton.setBounds(250,90,100,50);
        frame.add(clrButton);

        frame.setVisible(true);


    }

    public static void main(String[] args) {
        calculatorS calc=new calculatorS();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<10;i++){
            if (e.getSource()==numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==addButton  ){
            if (textField.getText().length()>0)
                num1 = Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");

        }
        if (e.getSource()==subButton ){
            if (textField.getText().length()>0)
                num1 = Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if (e.getSource()==mulButton){
            if (textField.getText().length()>0)
                num1 = Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if (e.getSource()==divButton){
            if (textField.getText().length()>0)
                num1 = Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if (e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
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
