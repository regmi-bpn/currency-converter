package ConverterCurrency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static ConverterCurrency.ConversionService.*;

public class Converter extends JFrame {
    private static JFrame frame;

    private static JLabel fromLabel;
    private static JTextField fromValue;
    private static JLabel fromCurrency;

    private static JLabel toLabel;
    private static JTextField toValue;
    private static JComboBox<String> toCurrency;

    private static JButton convert;

    public static void main(String[] args) throws IOException {
        initData();
        frame = new JFrame("Converter");
        fromLabel = new JLabel("From");
        fromLabel.setBounds(10, 30, 40, 20);

        fromValue = new JTextField(10);
        fromValue.setText("0.0");
        fromValue.setBounds(60, 30, 70, 20);

        fromCurrency = new JLabel("NPR");
        fromCurrency.setBounds(140, 30, 60, 20);

        frame.add(fromLabel);
        frame.add(fromValue);
        frame.add(fromCurrency);

        toLabel = new JLabel("To");
        toLabel.setBounds(10, 60, 40, 20);

        toValue = new JTextField(10);
        toValue.setBounds(60, 60, 70, 20);
        toValue.setDisabledTextColor(Color.BLACK);
        toValue.disable();

        toCurrency = new JComboBox<>(getUnits());
        toCurrency.setBounds(140, 60, 60, 20);

        frame.add(toLabel);
        frame.add(toValue);
        frame.add(toCurrency);

        convert = new JButton("Convert");
        convert.setBounds(10, 90, 190, 20);
        convert.addActionListener(new ConvertListener());

        frame.add(convert);

        frame.setSize(250, 170);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    static class ConvertListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String to = (String) toCurrency.getSelectedItem();
            double fromAmount = Double.parseDouble(fromValue.getText());
            double toRate = getRate(to);
            double toCurr = fromAmount * toRate;
            toValue.setText(String.valueOf(toCurr));
        }
    }


}
