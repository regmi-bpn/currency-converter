package ConverterCurrency;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationClass extends JFrame {
    private JTextField inputField;
    private JButton rupees;
    private JButton dollar;
    private JTextField outputField;

    public OperationClass() {
        super("Converter");

        inputField = new JTextField();
        inputField.setBounds(50,50,150,20);
        add(inputField);

        rupees = new JButton("rupees");
        rupees.setBounds(50,200,100,30);
        add(rupees);

        dollar = new JButton("dollar");
        dollar.setBounds(50,150,100,30);
        add(dollar);

        outputField = new JTextField();
        outputField.setBounds(50,100,150,20);
        outputField.setEditable(false);
        add(outputField);

        handlerClass handler = new handlerClass();
        inputField.addActionListener(handler);
        dollar.addActionListener(handler);
        rupees.addActionListener(handler);
        outputField.addActionListener(handler);

    }
    private class handlerClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1=inputField.getText();
            double a=Double.parseDouble(s1);
            double c=0;

            if(e.getSource()== rupees){
                c = a*120;
            }else if(e.getSource()== dollar){
                c= (a/120);
            }

            String result=String.valueOf(c);
            outputField.setText(result);
        }
    }
}
