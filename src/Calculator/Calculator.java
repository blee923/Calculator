package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    // Frame
    private JFrame frame = new JFrame("Calculator");

    // Screen for calculator
    private JTextArea screen = new JTextArea();

    // Buttons
    private JButton one = new JButton("1");
    private JButton two = new JButton("2");
    private JButton three = new JButton("3");
    private JButton four = new JButton("4");
    private JButton five = new JButton("5");
    private JButton six = new JButton("6");
    private JButton seven = new JButton("7");
    private JButton eight = new JButton("8");
    private JButton nine = new JButton("9");
    private JButton zero = new JButton("0");
    private JButton add = new JButton("+");
    private JButton multiply = new JButton("\u00D7");
    private JButton divide = new JButton("\u00F7");
    private JButton subtract = new JButton("-");
    private JButton modulus = new JButton("mod");
    private JButton decimal = new JButton(".");
    private JButton negative = new JButton("\u00B1");
    private JButton clear = new JButton("C");
    private JButton equals = new JButton("=");

    // Calculations
    String num1str = "";
    String num2str = "";
    String totalStr = "";

    String[] statement;

    double num1 = 0;
    double num2 = 0;
    double total = 0;

    public Calculator() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(378,573);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);

        screen.setSize(380,100);
        screen.setLocation(7,5);
        screen.setEditable(false);

        frame.add(screen);
        screen.setSize(370,140);
        addButtons(frame);
        setButtons(frame);
    }

    private void setButtons(JFrame frame) {
        negative.setSize(90, 60);
        negative.setLocation(2, 470);
        zero.setSize(90, 60);
        zero.setLocation(92, 470);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("0");
            }
        });
        decimal.setSize(90, 60);
        decimal.setLocation(182, 470);
        decimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append(".");
            }
        });
        equals.setSize(90, 60);
        equals.setLocation(272, 470);
        equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String holding = screen.getText();
                if(holding.contains("+")) {
                    statement = holding.split("\\+");
                    num1str = statement[0];
                    num2str = statement[1];
                    num1 = Double.parseDouble(num1str);
                    num2 = Double.parseDouble(num2str);
                    total = num1 + num2;
                } else if (holding.contains("-")) {
                    statement = holding.split("\\-");
                    num1str = statement[0];
                    num2str = statement[1];
                    num1 = Double.parseDouble(num1str);
                    num2 = Double.parseDouble(num2str);
                    total = num1 - num2;
                } else if (holding.contains("*")) {
                    statement = holding.split("\\*");
                    num1str = statement[0];
                    num2str = statement[1];
                    num1 = Double.parseDouble(num1str);
                    num2 = Double.parseDouble(num2str);
                    total = num1 * num2;
                } else if (holding.contains("/")) {
                    statement = holding.split("\\/");
                    num1str = statement[0];
                    num2str = statement[1];
                    num1 = Double.parseDouble(num1str);
                    num2 = Double.parseDouble(num2str);
                    total = num1 / num2;
                } else if (holding.contains("%")) {
                    statement = holding.split("\\%");
                    num1str = statement[0];
                    num2str = statement[1];
                    num1 = Double.parseDouble(num1str);
                    num2 = Double.parseDouble(num2str);
                    total = num1 % num2;
                }
                totalStr = Double.toString(total);
                screen.setText(totalStr);
            }
        });
        one.setSize(90, 60);
        one.setLocation(2, 410);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("1");
            }
        });
        two.setSize(90, 60);
        two.setLocation(92, 410);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("2");
            }
        });
        three.setSize(90, 60);
        three.setLocation(182, 410);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("3");
            }
        });
        add.setSize(90, 60);
        add.setLocation(272, 410);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { screen.append("+"); }
        });
        four.setSize(90, 60);
        four.setLocation(2, 350);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("4");
            }
        });
        five.setSize(90, 60);
        five.setLocation(92, 350);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("5");
            }
        });
        six.setSize(90, 60);
        six.setLocation(182, 350);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("6");
            }
        });
        subtract.setSize(90, 60);
        subtract.setLocation(272, 350);
        subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { screen.append("-"); }
        });
        seven.setSize(90, 60);
        seven.setLocation(2, 290);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("7");
            }
        });
        eight.setSize(90, 60);
        eight.setLocation(92, 290);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("8");
            }
        });
        nine.setSize(90, 60);
        nine.setLocation(182, 290);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.append("9");
            }
        });
        multiply.setSize(90, 60);
        multiply.setLocation(272, 290);
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { screen.append("*"); }
        });
        clear.setSize(90, 60);
        clear.setLocation(92, 230);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                num1str = "";
                num2str = "";
                screen.setText("");
            }
        });
        divide.setSize(90, 60);
        divide.setLocation(272, 230);
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { screen.append("/"); }
        });
        modulus.setSize(90, 60);
        modulus.setLocation(2, 170);
        modulus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { screen.append("%"); }
        });
    }

    private void addButtons(JFrame frame) {
        frame.add(one);
        frame.add(two);
        frame.add(three);
        frame.add(four);
        frame.add(five);
        frame.add(six);
        frame.add(seven);
        frame.add(eight);
        frame.add(nine);
        frame.add(zero);
        frame.add(add);
        frame.add(multiply);
        frame.add(divide);
        frame.add(subtract);
        frame.add(decimal);
        frame.add(negative);
        frame.add(clear);
        frame.add(equals);
        frame.add(modulus);
    }

    public static void main(String[] Args) {
        new Calculator();
    }
}
