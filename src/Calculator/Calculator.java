package Calculator;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    // Frame
    private JFrame frame = new JFrame("Calculator");

    // Screen for calculator
    private JTextArea screen = new JTextArea();
    private JTextArea inputScreen = new JTextArea();

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
    private JButton sqrt = new JButton("\u221A");
    private JButton squared = new JButton("X\u00B2");
    private JButton oneOver = new JButton("1/X");
    private JButton decimal = new JButton(".");
    private JButton negative = new JButton("\u00B1");
    private JButton clear = new JButton("C");
    private JButton clearEntry = new JButton("CE");
    private JButton backspace = new JButton("\u232B");
    private JButton equals = new JButton("=");

    // Calculations
    String num1str = "";
    String num2str = "";
    String totalStr = "";

    double num1 = 0;
    double num2 = 0;
    double total = 0;

    boolean functionCall = false;
    boolean finished = false;
    boolean result = false;

    public Calculator() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(378,573);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);

        screen.setSize(370,140);
        screen.setLocation(7,5);
        screen.setEditable(false);

        inputScreen.setSize(380, 70);
        inputScreen.setLocation(7, 35);
        inputScreen.setEditable(false);
        inputScreen.setFont(inputScreen.getFont().deriveFont(30f));

        frame.add(screen);
        frame.add(inputScreen);
        addButtons(frame);
        setButtons(frame);
    }

    private void setButtons(JFrame frame) {
        negative.setSize(90, 60);
        negative.setLocation(2, 470);
        negative.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               String temp = inputScreen.getText();
               if (temp.contains("-")) {
                   inputScreen.setText(temp.substring(1,temp.length()));
               } else {
                   inputScreen.setText("-" + temp);
               }
           }
        });
        zero.setSize(90, 60);
        zero.setLocation(92, 470);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("0");
            }
        });
        decimal.setSize(90, 60);
        decimal.setLocation(182, 470);
        decimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append(".");
            }
        });
        equals.setSize(90, 60);
        equals.setLocation(272, 470);
        equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                result = true;
                num1str = screen.getText();
                num2str = inputScreen.getText();
                String temp = num1str + num2str + "=";
                String operator = num1str.substring(num1str.length() - 1);
                num1str = num1str.substring(0, num1str.length() - 1);
                num1 = Double.parseDouble(num1str);
                num2 = Double.parseDouble(num2str);
                screen.setText(temp);
                if(operator.equals("+")) {
                    total = num1 + num2;
                } else if (operator.equals("-")) {
                    total = num1 - num2;
                } else if (operator.equals("*")) {
                    total = num1 * num2;
                } else if (operator.equals("/")) {
                    if (num1 == 0 && num2 == 0) {
                        inputScreen.setText("Result is undefined");
                        finished = true;
                        operator = "";
                        return;
                    } else if (num2 == 0) {
                        inputScreen.setText("Cannot divide by zero");
                        finished = true;
                        operator = "";
                        return;
                    }
                    total = num1 / num2;
                } else if (operator.equals("%")) {
                    total = num1 % num2;
                }
                totalStr = Double.toString(total);
                inputScreen.setText(totalStr);
                functionCall = true;
                operator = "";
            }
        });
        one.setSize(90, 60);
        one.setLocation(2, 410);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("1");
            }
        });
        two.setSize(90, 60);
        two.setLocation(92, 410);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("2");
            }
        });
        three.setSize(90, 60);
        three.setLocation(182, 410);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("3");
            }
        });
        add.setSize(90, 60);
        add.setLocation(272, 410);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (functionCall) {
                    String temp = screen.getText();
                    temp = temp.substring(0, temp.length() - 1) + "+";
                    screen.setText(temp);
                } else {
                    screen.setText(inputScreen.getText() + "+");
                }
                inputScreen.setText("");
            }
        });
        four.setSize(90, 60);
        four.setLocation(2, 350);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("4");
            }
        });
        five.setSize(90, 60);
        five.setLocation(92, 350);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("5");
            }
        });
        six.setSize(90, 60);
        six.setLocation(182, 350);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("6");
            }
        });
        subtract.setSize(90, 60);
        subtract.setLocation(272, 350);
        subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (functionCall) {
                    String temp = screen.getText();
                    temp = temp.substring(0, temp.length() - 1) + "-";
                    screen.setText(temp);
                } else {
                    screen.setText(inputScreen.getText() + "-");
                }
                functionCall = true;
                inputScreen.setText("");
            }
        });
        seven.setSize(90, 60);
        seven.setLocation(2, 290);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("7");
            }
        });
        eight.setSize(90, 60);
        eight.setLocation(92, 290);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("8");
            }
        });
        nine.setSize(90, 60);
        nine.setLocation(182, 290);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                called();
                inputScreen.append("9");
            }
        });
        multiply.setSize(90, 60);
        multiply.setLocation(272, 290);
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (functionCall) {
                    String temp = screen.getText();
                    temp = temp.substring(0, temp.length() - 1) + "*";
                    screen.setText(temp);
                } else {
                    screen.setText(inputScreen.getText() + "*");
                }
                functionCall = true;
                inputScreen.setText("");
            }
        });
        clearEntry.setSize(90, 60);
        clearEntry.setLocation(2, 230);
        clearEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                inputScreen.setText("");
            }
        });
        clear.setSize(90, 60);
        clear.setLocation(92, 230);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                num1str = "";
                num2str = "";
                screen.setText("");
                inputScreen.setText("");
            }
        });
        backspace.setSize(90, 60);
        backspace.setLocation(182, 230);
        backspace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (result) {
                    return;
                }
                String temp = inputScreen.getText();
                if (temp.length() == 0) {
                    return;
                }
                inputScreen.setText(temp.substring(0, temp.length() - 1));
            }
        });
        divide.setSize(90, 60);
        divide.setLocation(272, 230);
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (functionCall) {
                    String temp = screen.getText();
                    temp = temp.substring(0, temp.length() - 1) + "/";
                    screen.setText(temp);
                } else {
                    screen.setText(inputScreen.getText() + "/");
                }
                functionCall = true;
                inputScreen.setText("");
            }
        });
        modulus.setSize(90, 60);
        modulus.setLocation(2, 170);
        modulus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                screen.setText(inputScreen.getText() + "%");
                inputScreen.setText("");
            }
        });
        sqrt.setSize(90, 60);
        sqrt.setLocation(92, 170);
        sqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                num1str = inputScreen.getText();
                screen.setText("\u221A" + num1str + "=");
                num1 = Double.parseDouble(num1str);
                if (num1 < 0) {
                    inputScreen.setText("Invalid input");
                    functionCall = true;
                    result = true;
                    return;
                }
                total = Math.sqrt(num1);
                totalStr = Double.toString(total);
                inputScreen.setText(totalStr);
                functionCall = true;
                result = true;
            }
        });
        squared.setSize(90, 60);
        squared.setLocation(182, 170);
        squared.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               num1str = inputScreen.getText();
               screen.setText(num1str + "\u00B2=");
               num1 = Double.parseDouble(num1str);
               total = Math.pow(num1, 2);
               totalStr = Double.toString(total);
               inputScreen.setText(totalStr);
               functionCall = true;
               result = true;
           }
        });
        oneOver.setSize(90, 60);
        oneOver.setLocation(272, 170);
        oneOver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                num1str = inputScreen.getText();
                screen.setText("1/" + num1str + "=");
                num1 = Double.parseDouble(num1str);
                total = 1/num1;
                totalStr = Double.toString(total);
                inputScreen.setText(totalStr);
                functionCall = true;
                result = true;
            }
        });
    }

    private void called() {
        if(finished) {
            finished = false;
            inputScreen.setText("");
            screen.setText("");
        } else if (functionCall) {
            functionCall = false;
            inputScreen.setText("");
        }
        result = false;
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
        frame.add(sqrt);
        frame.add(squared);
        frame.add(oneOver);
        frame.add(clearEntry);
        frame.add(backspace);
    }

    public static void main(String[] Args) {
        new Calculator();
    }
}
